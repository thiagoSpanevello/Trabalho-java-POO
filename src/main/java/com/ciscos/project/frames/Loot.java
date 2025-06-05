package com.ciscos.project.frames;

import com.ciscos.project.Entity;
import com.ciscos.project.equipment.Armor;
import com.ciscos.project.equipment.Necklace;
import com.ciscos.project.equipment.Pants;
import com.ciscos.project.equipment.Ring;
import com.ciscos.project.equipment.Weapon;
import com.ciscos.project.utils.Context;
import com.ciscos.project.items.Item;
import com.ciscos.project.items.List;
import com.ciscos.project.utils.ColorBlind;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JOptionPane;

public class Loot extends javax.swing.JFrame {

    private final Entity enemy;
    private Item[] userInventory;
    private Item[] enemyInventory;

    private void mountEnemyList(Item[] inv) {
        int size = 0;

        for (int i = 0; i < inv.length; i++) {
            if (inv[i] != null) {
                size++;
            }
        }
        String[] items = new String[size];
        enemyInventory = new Item[size];

        int index = 0;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }

            String text;

            text = inv[i].data.getName().substring(0, 1).toUpperCase() + inv[i].data.getName().substring(1);
            if (inv[i].maxStack > 1) {
                text += " x" + inv[i].getCurrentStack();
            }

            if (inv[i].data.getClass().getSimpleName().equals("Armor")) {
                Armor a = (Armor) inv[i].data;
                text += " (res: " + a.defense  * 100 + "%, mag: " + a.magicResist * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Pants")) {
                Pants a = (Pants) inv[i].data;
                text += " (res: " + a.defense * 100 + "%, mag: " + a.magicResist * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Ring")) {
                Ring r = (Ring) inv[i].data;
                text += " (mult: " + r.getMultiplier() * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Necklace")) {
                Necklace r = (Necklace) inv[i].data;
                text += " (mult: " + r.getMultiplier() * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Weapon")) {
                Weapon w = (Weapon) inv[i].data;
                text += " (dam: " + w.getDamage() + ", mult: " + w.getMultiplier() * 100 + "%)";
            }

            enemyInventory[index] = inv[i];
            items[index] = text;
            index++;
        }

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = items;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void mountClientList(Item[] inv) {
        int size = 0;

        for (int i = 0; i < inv.length; i++) {
            if (inv[i] != null) {
                size++;
            }
        }
        String[] items = new String[size];
        userInventory = new Item[size];

        int index = 0;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }

            String text;

            text = inv[i].data.getName().substring(0, 1).toUpperCase() + inv[i].data.getName().substring(1);
            if (inv[i].maxStack > 1) {
                text += " x" + inv[i].getCurrentStack();
            }

            if (inv[i].data.getClass().getSimpleName().equals("Armor")) {
                Armor a = (Armor) inv[i].data;
                text += " (res: " + a.defense  * 100 + "%, mag: " + a.magicResist * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Pants")) {
                Pants a = (Pants) inv[i].data;
                text += " (res: " + a.defense  * 100 + "%, mag: " + a.magicResist * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Ring")) {
                Ring r = (Ring) inv[i].data;
                text += " (mult: " + r.getMultiplier() * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Necklace")) {
                Necklace r = (Necklace) inv[i].data;
                text += " (mult: " + r.getMultiplier() * 100 + "%)";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Weapon")) {
                Weapon w = (Weapon) inv[i].data;
                text += " (dam: " + w.getDamage() + ", mult: " + w.getMultiplier() * 100 + "%)";
            }
            int price = (int) Math.floor(inv[i].price * 0.9 * inv[i].getCurrentStack());

            userInventory[index] = inv[i];
            items[index] = text;
            index++;
        }

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = items;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    public Loot(Entity temp) {
        initComponents();

        equipButton.setVisible(false);

        Random random = new Random();
        enemy = new Entity(30, 0);

        int n = random.nextInt(10);

        System.out.println(temp);

        if (temp.equipment.getArmorItem() != null) {
            enemy.putOnInventory(temp.equipment.getArmorItem());
        }
        if (temp.equipment.getPantsItem() != null) {
            enemy.putOnInventory(temp.equipment.getPantsItem());
        }

        if (random.nextInt(10) < 4) {
            Item[] weapons = List.getWeapons().get(Context.getSession().getClass().getSimpleName());

            int prob = 0;
            for (int i = 0; i < weapons.length; i++) {
                prob += Math.pow(2, i);
            }

            int chance = random.nextInt(prob) + 1;

            for (int i = weapons.length - 1; i >= 0; i--) {
                if (chance <= Math.pow(2, weapons.length - 1 - i)) {
                    enemy.putOnInventory(weapons[i]);
                    break;
                }
                if (i == 0) {
                    enemy.putOnInventory(weapons[i]);
                }
            }
        }

        if (random.nextInt(100) < 5) {
            Item ring = List.getRings().get(Context.getSession().getClass().getSimpleName());
            enemy.putOnInventory(ring);
        }

        if (random.nextInt(100) < 5) {
            Item necklaces = List.getNecklaces().get(Context.getSession().getClass().getSimpleName());
            enemy.putOnInventory(necklaces);
        }

        Item[] potions = List.potions;
        for (int i = 0; i < potions.length; i++) {
            enemy.putOnInventory(potions[i]);
        }
        
        jLabel3.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/backblur.png")));
        jLabel2.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/backblur.png")));

        Item[] randoms = List.randoms;

        int prob = 0;
        for (int i = 0; i < randoms.length; i++) {
            prob += Math.pow(2, i);
        }

        int chance = random.nextInt(prob) + 1;

        for (int i = randoms.length - 1; i >= 0; i--) {
            if (chance <= Math.pow(2, randoms.length - 1 - i)) {
                if (randoms[i].maxStack == 1) {
                    enemy.putOnInventory(randoms[i]);
                } else {
                    enemy.putOnInventory(new Item(randoms[i].data, randoms[i].price, randoms[i].sellable, random.nextInt(20 - 6) + 6, randoms[i].maxStack));
                }
                break;
            }
            if (i == 0) {
                if (randoms[i].maxStack == 1) {
                    enemy.putOnInventory(randoms[i]);
                } else {
                    enemy.putOnInventory(new Item(randoms[i].data, randoms[i].price, randoms[i].sellable, random.nextInt(20 - 6) + 6, randoms[i].maxStack));
                }
            }
        }

        mountEnemyList(enemy.getInventory());
        mountClientList(Context.getSession().getInventory());

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        

        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        equipButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2 + 50;

        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        equipButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backblur.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cisco's Medieval RPG: loot");
        setMinimumSize(new java.awt.Dimension(580, 490));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sell.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 40, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buy.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 196, 40));

        equipButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equip.png"))); // NOI18N
        equipButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        equipButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipButtonMouseClicked(evt);
            }
        });
        getContentPane().add(equipButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 152, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        jList2.setBackground(new java.awt.Color(0, 0, 0));
        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jList2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 430, 340));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 430, 340));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backblur.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 600, 490));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backblur.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Context.setSeller(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        Context.setSeller(null);
    }//GEN-LAST:event_formWindowClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jList2.getSelectedIndex() < 0) {
            return;
        }

        jList1.clearSelection();

        Item item = enemyInventory[jList2.getSelectedIndex()];

        int i = 0;
        Item[] inv = enemy.getInventory();
        while (i < inv.length) {
            if (inv[i] == item) {
                break;
            }
            i++;
        }

        enemy.removeFromInventory(i);
        Context.getSession().putOnInventory(item);

        mountClientList(Context.getSession().getInventory());
        mountEnemyList(enemy.getInventory());

        jList2.clearSelection();
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean isEquipable(Object obj) {
        if (obj.getClass().getSimpleName().equals("Armor")) {
            return true;
        }
        if (obj.getClass().getSimpleName().equals("Pants")) {
            return true;
        }
        if (obj.getClass().getSimpleName().equals("Weapon")) {
            return true;
        }
        if (obj.getClass().getSimpleName().equals("Ring")) {
            return true;
        }
        if (obj.getClass().getSimpleName().equals("Necklace")) {
            return true;
        }
        return false;
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        Item item = userInventory[jList1.getSelectedIndex()];
        if (isEquipable(item.data)) {
            equipButton.setVisible(true);
        } else
            equipButton.setVisible(false);
    }//GEN-LAST:event_jList1ValueChanged

    private void equipButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipButtonMouseClicked
        // TODO add your handling code here:
        
        if(jList1.getSelectedIndex() < 0) return;
        
        Item item = userInventory[jList1.getSelectedIndex()];

        int i = 0;
        Item[] inv = Context.getSession().getInventory();
        while (i < inv.length) {
            if (inv[i] == item) {
                break;
            }
            i++;
        }

        Context.getSession().equip(i);
        JOptionPane.showMessageDialog(this, item.data.getName() + " foi equipado com sucesso!");
        equipButton.setVisible(false);
        mountClientList(Context.getSession().getInventory());
        
        jList1.clearSelection();
        equipButton.setVisible(false);
    }//GEN-LAST:event_equipButtonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jList1.getSelectedIndex() < 0) {
            return;
        }

        jList2.clearSelection();

        Item item = userInventory[jList1.getSelectedIndex()];

        int i = 0;
        Item[] inv = Context.getSession().getInventory();
        while (i < inv.length) {
            if (inv[i] == item) {
                break;
            }
            i++;
        }

        Context.getSession().removeFromInventory(i);
        enemy.putOnInventory(item);

        equipButton.setVisible(false);
        
        mountEnemyList(enemy.getInventory());
        mountClientList(Context.getSession().getInventory());

        jList1.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Loot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loot(new Entity(0, 0)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton equipButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
