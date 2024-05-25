/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ciscos.project.frames;

import com.ciscos.project.Entity;
import com.ciscos.project.items.Item;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.utils.Context;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Thiago
 */
public class Combat extends javax.swing.JFrame {

    Entity enemy;

    /**
     * Creates new form Combat
     */
    
    private boolean hasHealPotion(){
        Item[] inv = Context.getSession().getInventory();
        
        for(int i =0; i < inv.length; i++){
            if(inv[i] == null) continue;
            if(inv[i].data.getName().equals("poção de vida")) return true;
        }
        
        return false;
    }
    
    private boolean hasManaPotion(){
        Item[] inv = Context.getSession().getInventory();
        
        for(int i =0; i < inv.length; i++){
            if(inv[i] == null) continue;
            if(inv[i].data.getName().equals("poção de mana")) return true;
        }
        
        return false;
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

        if(Context.getSession().getClass().getSimpleName().equals("Berserker") || Context.getSession().getClass().getSimpleName().equals("Archer")) {
            spell2.setVisible(false);
            spell3.setVisible(false);
            manaBar.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
        }
        
        if(Context.getSession().getClass().getSimpleName().equals("Berserker")) {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/berserkerAttack.png"))); // NOI18N
        }
        
        if(Context.getSession().getClass().getSimpleName().equals("Archer")) {
            attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/archerAttack.png"))); // NOI18N
        }
        
        if(Context.getSession().getClass().getSimpleName().equals("Mage")) {
            Mage m = (Mage) Context.getSession();
            System.out.println(m.getMaxMana() + " " + m.getMaxMana());
            m.setMana(m.getMaxMana());
            manaBar.setValue((int) m.getMana());
            manaBar.setMaximum((int) m.getMaxMana());
            manaBar.setForeground(Color.blue);
        }
        
        if(hasManaPotion()) {
            mana.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/mana.png"))); // NOI18N
        }
        
        if(hasHealPotion()) {
            heal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            heal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/heal.png"))); // NOI18N
        }
        
        JLabel[] buttons = {attack, spell2, spell3, run};
        
        for(int i =0; i < buttons.length; i++){
            buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        
        String[] undeads = {" esqueleto", " morto-vivo", " ancestral", " milenar", " soberano"};
        String[] mythicals = {" pidão", " puro-sange", " ancestral", " divino", " primordial", " soberano"};

        String[] variant = {" sanguinário", " amaldiçoado", " selado"};

        int variantType = rand.nextInt(variant.length * 2);

        random = rand.nextInt(7);
        switch (random) {
            case 0:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archerSkel.gif")));
                enemy = new Entity("Arqueiro" + undeads[rand.nextInt(undeads.length)], 100, 10, 10);
                break;
            case 1:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/karasu.gif")));
                enemy = new Entity("Harpia" + mythicals[rand.nextInt(mythicals.length)], 100, 10, 10);
                break;
            case 2:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/kitsune.gif")));
                enemy = new Entity("Kitsune" + mythicals[rand.nextInt(mythicals.length)], 100, 10, 10);
                break;
            case 3:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/spearmanSkel.gif")));
                enemy = new Entity("Lanceiro" + undeads[rand.nextInt(undeads.length)], 100, 10, 10);
                break;
            case 4:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/warriorSkel.gif")));
                enemy = new Entity("Guerreiro" + undeads[rand.nextInt(undeads.length)], 100, 10, 10);
                break;
            case 5:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/werewolf.gif")));
                enemy = new Entity("Licantropo" + mythicals[rand.nextInt(mythicals.length)], 100, 10, 10);
                break;
            case 6:
                enemyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/yamabushi.gif")));
                enemy = new Entity("Yokai" + mythicals[rand.nextInt(mythicals.length)], 100, 10, 10);
                break;

        }

        if (variantType < variant.length) {
            enemy.setName(enemy.getName() + variant[variantType]);
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
        setMaximumSize(new java.awt.Dimension(608, 360));
        setMinimumSize(new java.awt.Dimension(608, 360));
        setPreferredSize(new java.awt.Dimension(608, 360));
        setResizable(false);
        setSize(new java.awt.Dimension(608, 360));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(mana, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        heal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noHeal.png"))); // NOI18N
        getContentPane().add(heal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noSpell2.png"))); // NOI18N
        getContentPane().add(spell2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noSpell3.png"))); // NOI18N
        getContentPane().add(spell3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        attack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/combatIcons/noSpell1.png"))); // NOI18N
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
    }//GEN-LAST:event_formWindowClosed

    private void runMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runMouseClicked
        // TODO add your handling code here:
        Random random = new Random();
        
        int runTry = random.nextInt(10);
        
        if(runTry < 7) {
            int xp = 5 - Context.getRunningCount();
            String message = Context.getSession().getName() + " fugiu com sucesso e ganhou " + xp + " de experiência!";
            if(Context.getRunningCount() > 0) message+= " (perdeu " + Context.getRunningCount() + " de xp por suas fugas consecutivas)";
            JOptionPane.showMessageDialog(this, message);
            Context.getSession().addXp(xp);
            Context.getMainWindow().sync();
            
            Context.increaseRunningCount();
            this.dispose();
            return;
        } 
        JOptionPane.showMessageDialog(this, Context.getSession().getName() + " não conseguiu fugir!");   
    }//GEN-LAST:event_runMouseClicked

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
