/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ciscos.project.frames;

import com.ciscos.project.Entity;
import com.ciscos.project.items.Item;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.mage.Spell;
import com.ciscos.project.utils.Context;
import com.ciscos.project.Character;
import com.ciscos.project.items.List;
import com.ciscos.project.items.Potion;
import com.ciscos.project.utils.Damage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class Combat extends javax.swing.JFrame {

    private boolean onTurn = true;
    private Entity enemy;
    private int option = 0;

    final int defaultDelay = 700;

    /**
     * Creates new form Combat
     */
    private boolean hasHealPotion() {
        Item[] inv = Context.getSession().getInventory();

        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].data.getName().equals("poção de vida")) {
                heal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                heal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/heal.png")));
                return true;
            }
        }

        heal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        heal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noHeal.png")));
        return false;
    }

    private boolean hasManaPotion() {
        Item[] inv = Context.getSession().getInventory();

        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].data.getName().equals("poção de mana")) {
                mana.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/mana.png")));
                return true;
            }
        }

        mana.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        mana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noMana.png")));
        
        return false;
    }

    private void getToLevel() {
        double mult = 1;

        double damage = 0;
        
        Random random = new Random();
        
        double damageMult = 1.10 - (random.nextInt(21) / 100); 
        
        if(Context.getSession().getClass().getSimpleName().equals("Archer")) {
            damage = Context.getSession().equipment.getWeapon().getMultiplier() * damageMult;
        }
        
        if(Context.getSession().getClass().getSimpleName().equals("Mage")) {
            damage = 7 * (1 + Context.getSession().equipment.getWeapon().getMultiplier()) * damageMult;
        }
        
        if(Context.getSession().getClass().getSimpleName().equals("Berserker")) {
            damage = Context.getSession().equipment.getWeapon().getDamage() * damageMult;
        }
        
        
        for (int i = 1; i < Context.getSession().getLevel(); i++) {
            mult *= 1.1;
        }
        
        damage *= mult;
        
        if(damage > 0.3 * enemy.getHp() * mult) damage = 0.3 * enemy.getHp() * mult;
        
        Entity temp = new Entity(enemy.getName(), Context.getSession().getLevel(), enemy.getHp() * mult, (int) Math.ceil(enemy.getSpeed() * mult), damage, enemy.getDamageType(), enemy.getCoins());
        
        
        
        enemy = temp;
    }

    public Combat() {
        initComponents();
        charIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/" + Context.getSession().getClass().getSimpleName().toLowerCase() + ".gif")));
        Random rand = new Random();
        Context.setCombat(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);

        int random = rand.nextInt(5);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatBackgrounds/" + random + ".jpeg")));

        if (Context.getSession().getClass().getSimpleName().equals("Berserker") || Context.getSession().getClass().getSimpleName().equals("Archer")) {
            spell2.setVisible(false);
            spell3.setVisible(false);
            manaBar.setVisible(false);

            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
        }

        if (Context.getSession().getClass().getSimpleName().equals("Berserker")) {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/berserkerAttack.png"))); // NOI18N
        }

        if (Context.getSession().getClass().getSimpleName().equals("Archer")) {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/archerAttack.png"))); // NOI18N
        }

        if (Context.getSession().getClass().getSimpleName().equals("Mage")) {
            Mage m = (Mage) Context.getSession();
            System.out.println(m.getMaxMana() + " " + m.getMaxMana());
            manaBar.setValue((int) m.getMana());
            manaBar.setMaximum((int) m.getMaxMana());
            manaBar.setForeground(Color.blue);

            Spell[] spells = m.getSpells();

            jLabel5.setText("0" + spells[0].getMana());
            jLabel6.setText("" + spells[1].getMana());
            jLabel4.setText("" + spells[2].getMana());
            
            checkMana();
        }

        
        hasHealPotion();
        hasManaPotion();
        checkTurn();
        JLabel[] buttons = {attack, run};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        String[] undeads = {" esqueleto", " morto-vivo", " ancestral", " milenar", " soberano"};
        String[] mythicals = {" pidão", " puro-sange", " ancestral", " divino", " primordial", " soberano"};

        String[] variant = {" sanguinário", " amaldiçoado", " selado"};

        int variantType = rand.nextInt(variant.length * 2);

        random = rand.nextInt(7);

        switch (random) {
            case 0:
                //archer
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archerSkel.gif")));
                enemy = new Entity("Arqueiro" + undeads[rand.nextInt(undeads.length)], 0, 65, 15, 4, "physical", rand.nextInt(10) + 5);
                break;
            case 1:
                //berserker
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/karasu.gif")));
                enemy = new Entity("Harpia" + mythicals[rand.nextInt(mythicals.length)], 0, 70, 10, 5, "physical", rand.nextInt(10) + 5);
                break;
            case 2:
                //magic
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/kitsune.gif")));
                enemy = new Entity("Kitsune" + mythicals[rand.nextInt(mythicals.length)], 0, 60, 10, 6, "magic", rand.nextInt(10) + 5);
                break;
            case 3:
                //archer
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/spearmanSkel.gif")));
                enemy = new Entity("Lanceiro" + undeads[rand.nextInt(undeads.length)], 0, 65, 15, 4, "physical", rand.nextInt(10) + 5);
                break;
            case 4:
                //berserker
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/warriorSkel.gif")));
                enemy = new Entity("Guerreiro" + undeads[rand.nextInt(undeads.length)], 0, 70, 10, 5, "physical", rand.nextInt(10) + 5);
                break;
            case 5:
                //berserker
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/werewolf.gif")));
                enemy = new Entity("Licantropo" + mythicals[rand.nextInt(mythicals.length)], 0, 70, 10, 5, "physical", rand.nextInt(10) + 5);
                break;
            case 6:
                //magic
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/yamabushi.gif")));
                enemy = new Entity("Yokai" + mythicals[rand.nextInt(mythicals.length)], 0, 60, 10, 6, "magic", rand.nextInt(10) + 5);
                break;

        }

        if (variantType < variant.length) {
            enemy.setName(enemy.getName() + variant[variantType]);
        }
        
        getToLevel();
        
        if (rand.nextInt(10) <= 6 ) {
            Item[] armors = List.armors;
            int prob = 0;
            for (int i = 0; i < armors.length; i++) {
                prob += Math.pow(2, i);
            }
            int chance = rand.nextInt(prob) + 1;
            for (int i = armors.length - 1; i >= 0; i--) {
                if (chance <= Math.pow(2, armors.length - 1 - i)) {
                    enemy.equip(armors[i]);
                    break;
                }
                if (i == 0) {
                    enemy.equip(armors[i]);
                }
            }
        }


        if (rand.nextInt(10) <= 6 ) {
            Item[] pants = List.pants;

            int prob = 0;
            
            for (int i = 1; i < pants.length; i++) {
                prob += Math.pow(2, i);
            }

            int chance = rand.nextInt(prob) + 1;

            for (int i = pants.length - 1; i >= 0; i--) {
                if (chance <= Math.pow(2, pants.length - 1 - i)) {
                    enemy.equip(pants[i]);
                    break;
                }
                if (i == 0) {
                    enemy.equip(pants[i]);
                }
            }
        }

        enemyName.setText(enemy.getName());
        charName.setText(Context.getSession().getName());

        jProgressBar3.setValue((int) Context.getSession().getHp());
        jProgressBar3.setMaximum((int) Context.getSession().getMaxHp());
        jProgressBar3.setForeground(Color.red);
        
        jProgressBar2.setValue((int) enemy.getHp());
        jProgressBar2.setMaximum((int) enemy.getMaxHp());
        jProgressBar2.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        block6 = new javax.swing.JLabel();
        block5 = new javax.swing.JLabel();
        block4 = new javax.swing.JLabel();
        block3 = new javax.swing.JLabel();
        block2 = new javax.swing.JLabel();
        block1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mana = new javax.swing.JLabel();
        heal = new javax.swing.JLabel();
        spell2 = new javax.swing.JLabel();
        spell3 = new javax.swing.JLabel();
        attack = new javax.swing.JLabel();
        run = new javax.swing.JLabel();
        manaBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        charIcon = new javax.swing.JLabel();
        charName = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        enemyName = new javax.swing.JLabel();
        enemyIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(608, 358));
        setResizable(false);
        setSize(new java.awt.Dimension(608, 358));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        block6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        block5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        block4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        block3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        block2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        block1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/blocked.png"))); // NOI18N
        getContentPane().add(block1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 0, 8)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("10");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 93, -1, -1));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("10");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 44, -1, -1));

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("10");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 93, -1, -1));

        mana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noMana.png"))); // NOI18N
        mana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manaMouseClicked(evt);
            }
        });
        getContentPane().add(mana, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        heal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noHeal.png"))); // NOI18N
        heal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                healMouseClicked(evt);
            }
        });
        getContentPane().add(heal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell2.png"))); // NOI18N
        spell2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spell2MouseClicked(evt);
            }
        });
        getContentPane().add(spell2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell3.png"))); // NOI18N
        spell3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spell3MouseClicked(evt);
            }
        });
        getContentPane().add(spell3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell1.png"))); // NOI18N
        attack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attackMouseClicked(evt);
            }
        });
        getContentPane().add(attack, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        run.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/run.png"))); // NOI18N
        run.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                runMouseClicked(evt);
            }
        });
        getContentPane().add(run, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));
        getContentPane().add(manaBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 110, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));
        getContentPane().add(charIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 172, 140, 120));

        charName.setForeground(new java.awt.Color(255, 255, 255));
        charName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(charName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, -1));
        getContentPane().add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 10));
        getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 140, 10));

        enemyName.setForeground(new java.awt.Color(255, 255, 255));
        enemyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(enemyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 180, -1));
        getContentPane().add(enemyIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 169, 140, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatBackgrounds/4.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Context.setCombat(null);
        Context.getMainWindow().sync();
    }//GEN-LAST:event_formWindowClosed

    private void delayAction(Callable<Integer> func, int ms) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    func.call();
                } catch (Exception ex) {
                    Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        },
                ms
        );
    }

//    delayAction(() -> {
//                JOptionPane.showMessageDialog(this, text);
//                return 0;
//            }, 10000
//            );

    private void runMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runMouseClicked
        // TODO add your handling code here:
        if(!onTurn) return;
        
        Random random = new Random();

        int runTry = random.nextInt(10);

        JOptionPane.showMessageDialog(this, "tentano fugi");

        onTurn = false;
        checkTurn();
        if (runTry < 7) {
            int xp = 5 - Context.getRunningCount();
            String message = Context.getSession().getName() + " fugiu com sucesso e ganhou " + xp + " de experiência!";
            if (Context.getRunningCount() > 0) {
                message += " (perdeu " + Context.getRunningCount() + " de xp por suas fugas consecutivas)";
            }

            final String text = message;

            JOptionPane.showMessageDialog(this, text);
            Context.getSession().addXp(xp);
            Context.increaseRunningCount();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, Context.getSession().getName() + " não conseguiu fugir!");

            Entity a = (Entity) Context.getSession();
            Entity b = enemy;

            onTurn = true;
            attack(b, a);
        }
    }//GEN-LAST:event_runMouseClicked

    private void checkTurn() {
        if (onTurn) {
            block1.setVisible(false);
            block2.setVisible(false);
            block3.setVisible(false);
            block4.setVisible(false);
            block5.setVisible(false);
            block6.setVisible(false);
        } else {
            if (Context.getSession().getClass().getSimpleName().equals("Mage")) {
                block1.setVisible(true);
                block2.setVisible(true);
            }

            block3.setVisible(true);
            block4.setVisible(true);
            block5.setVisible(true);
            block6.setVisible(true);
        }
    }

    private void checkMana() {
        Mage m = (Mage) Context.getSession();

        double currentMana = m.getMana();

        manaBar.setValue((int) currentMana);

        Spell[] spells = m.getSpells();

        if (currentMana >= spells[0].getMana()) {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell1.png")));
            jLabel5.setVisible(true);
        } else {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/mageAttack.png")));
            jLabel5.setVisible(false);
        }

        if (currentMana >= spells[1].getMana()) {
            spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell2.png")));
            spell2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noSpell2.png")));
            spell2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }

        if (currentMana >= spells[2].getMana()) {
            spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/spell3.png")));
            spell3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noSpell3.png")));
            spell3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void attack(Entity a, Entity b) {
        Damage damage;
        
        if(a.getHp() == 0) return;
        
        if (a.getClass().getSimpleName().equals("Entity")) {
            damage = a.attack();
        } else if (a.getClass().getSimpleName().equals("Berserker") || a.getClass().getSimpleName().equals("Archer")) {
            damage = a.attack();
            
        } else {
            damage = a.attack(option);
            checkMana();
        }

        double resist = 0;
        if (b.equipment.getArmor() != null) {
            if (damage.type.equals("magic")) {
                resist += b.equipment.getArmor().magicResist;
            } else {
                resist += b.equipment.getArmor().defense;
            }
        }
        if (b.equipment.getPants() != null) {
            if (damage.type.equals("magic")) {
                resist += b.equipment.getPants().magicResist;
            } else {
                resist += b.equipment.getPants().defense;
            }
        }
        double resistedDamage = damage.damage * resist;
        double damageDealt = damage.damage - resistedDamage;
        double currentHp = b.getHp() - damageDealt;
        if (currentHp < 0) {
            b.setHp(0);
        } else {
            b.setHp(currentHp);
        }

        if (b.getClass().getSimpleName().equals("Entity")) {
            jProgressBar2.setValue((int) b.getHp());
        } else {
            jProgressBar3.setValue((int) b.getHp());
            Context.getMainWindow().sync();
        }

        checkTurn();

        if (b.getHp() == 0) {
            JOptionPane.showMessageDialog(this, b.getName() + " foi derrotado por " + a.getName() + "!");

            if (b.getClass().getSimpleName().equals("Entity")) {
                a.setCoins(a.getCoins() + b.getCoins());
                a.addXp(35);
                JOptionPane.showMessageDialog(this, a.getName() + " recebeu " + b.getCoins() + " moedas e 35 de xp!");

                Loot loot = new Loot(b);
                loot.setVisible(true);
            }            

            Context.resetRunningCount();

            this.dispose();
        }
    }

    private void combat() {
        onTurn = false;
        Entity a = (Entity) Context.getSession();
        Entity b = enemy;

        if (a.getSpeed() > b.getSpeed()) {
            attack(a, b);
            delayAction(() -> {
                onTurn = true;
                attack(b, a);
                
                return 0;
            }, defaultDelay
            );
        } else if (a.getSpeed() < b.getSpeed()) {
            attack(b, a);
            delayAction(() -> {
                onTurn = true;
                attack(a, b);
                
                return 0;
            }, defaultDelay
            );
        } else {
            Random random = new Random();
            int op = random.nextInt(10);
            if (op <= 5) {
                attack(a, b);
                delayAction(() -> {
                    onTurn = true;
                    attack(b, a);

                    return 0;
                }, defaultDelay
                );
            } else {
                attack(b, a);
                delayAction(() -> {
                    onTurn = true;
                    attack(a, b);

                    return 0;
                }, defaultDelay
                );
            }
        }
    }

    private void attackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attackMouseClicked
        if(!onTurn) return;
        
        option = 0;
        combat();
    }//GEN-LAST:event_attackMouseClicked

    private void spell2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spell2MouseClicked
        if(!onTurn) return;
        
        Mage m = (Mage) Context.getSession();
        
        if(m.getMana() < m.getSpells()[1].getMana()) return;
        
        option = 1;
        combat();        // TODO add your handling code here:
    }//GEN-LAST:event_spell2MouseClicked

    private void spell3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spell3MouseClicked
        if(!onTurn) return;
        
        Mage m = (Mage) Context.getSession();
        
        if(m.getMana() < m.getSpells()[2].getMana()) return;
        
        
        option = 2;
        combat();        // TODO add your handling code here:
    }//GEN-LAST:event_spell3MouseClicked

    private void healMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healMouseClicked
        if(!onTurn || !hasHealPotion()) return;
        Item[] inv = Context.getSession().getInventory();
        int index = -1;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].data.getName().equals("poção de vida")) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            onTurn = false;
            checkTurn();

            Potion p = (Potion) inv[index].data;

            Character c = Context.getSession();

            double newHp = c.getHp() + (p.getMultiplier() * c.getMaxHp());

            if (newHp > c.getMaxHp()) {
                newHp = c.getMaxHp();
            }

            c.setHp(newHp);
            Context.getMainWindow().sync();

            jProgressBar3.setValue((int) Context.getSession().getHp());

            try {
                inv[index].decreaseStack();
            } catch (Exception e) {
                Context.getSession().removeFromInventory(index);
            }
            hasHealPotion();
            Entity a = (Entity) Context.getSession();
            Entity b = enemy;

            delayAction(() -> {
                onTurn = true;
                attack(b, a);
                checkTurn();
                return 0;
            }, defaultDelay
            );
        }
    }//GEN-LAST:event_healMouseClicked

    private void manaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manaMouseClicked
        if(!onTurn || !hasManaPotion()) return;
        Item[] inv = Context.getSession().getInventory();
        int index = -1;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].data.getName().equals("poção de mana")) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            onTurn = false;
            checkTurn();

            Potion p = (Potion) inv[index].data;

            if (Context.getSession().getClass().getSimpleName().equals("Berserker") || Context.getSession().getClass().getSimpleName().equals("Archer")) {
                JOptionPane.showMessageDialog(this, "Sabe que isso aqui não muda nada pra ti né? (Luigi agradece)");
            } else {
                Mage m = (Mage) Context.getSession();

                int newMana = (int) Math.ceil(m.getMana() + (p.getMultiplier() * m.getMaxMana()));

                if (newMana > m.getMaxMana()) {
                    newMana = m.getMaxMana();
                }

                m.setMana(newMana);
                checkMana();
            }

            try {
                inv[index].decreaseStack();
            } catch (Exception e) {
                Context.getSession().removeFromInventory(index);
            }
            hasManaPotion();

            Entity a = (Entity) Context.getSession();
            Entity b = enemy;

            delayAction(() -> {
                onTurn = true;
                attack(b, a);
                checkTurn();
                return 0;
            }, defaultDelay
            );
        }        // TODO add your handling code here:
    }//GEN-LAST:event_manaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Combat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attack;
    private javax.swing.JLabel block1;
    private javax.swing.JLabel block2;
    private javax.swing.JLabel block3;
    private javax.swing.JLabel block4;
    private javax.swing.JLabel block5;
    private javax.swing.JLabel block6;
    private javax.swing.JLabel charIcon;
    private javax.swing.JLabel charName;
    private javax.swing.JLabel enemyIcon;
    private javax.swing.JLabel enemyName;
    private javax.swing.JLabel heal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JLabel mana;
    private javax.swing.JProgressBar manaBar;
    private javax.swing.JLabel run;
    private javax.swing.JLabel spell2;
    private javax.swing.JLabel spell3;
    // End of variables declaration//GEN-END:variables
}
