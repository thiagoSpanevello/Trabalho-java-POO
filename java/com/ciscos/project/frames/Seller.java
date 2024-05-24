/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ciscos.project.frames;

import com.ciscos.project.archer.Arrow;
import com.ciscos.project.equipment.Armor;
import com.ciscos.project.equipment.Necklace;
import com.ciscos.project.equipment.Pants;
import com.ciscos.project.equipment.Ring;
import com.ciscos.project.equipment.Weapon;
import com.ciscos.project.utils.Context;
import com.ciscos.project.items.Item;
import com.ciscos.project.utils.Utils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lilia
 */
public class Seller extends javax.swing.JFrame {
    private int sellerCoinsValue = 0;
    private Item[] userInventory;

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
                text += " (res: " + a.defense + ", mag: " + a.magicResist + ")";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Pants")) {
                Pants a = (Pants) inv[i].data;
                text += " (res: " + a.defense + ", mag: " + a.magicResist + ")";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Ring")) {
                Ring r = (Ring) inv[i].data;
                text += " (mult: " + r.getMultiplier() + ")";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Necklace")) {
                Necklace r = (Necklace) inv[i].data;
                text += " (mult: " + r.getMultiplier() + ")";
            }

            if (inv[i].data.getClass().getSimpleName().equals("Weapon")) {
                Weapon w = (Weapon) inv[i].data;
                text += " (dam: " + w.getDamage() + ", mult: " + w.getMultiplier() + ")";
            }

            text += " - " + (int) inv[i].price * inv[i].getCurrentStack();

            userInventory[index] = inv[i];
            items[index] = text;
            index++;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
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

    public Seller() {
        initComponents();

        Context.setSeller(this);

        Random random = new Random();
        this.sellerCoinsValue = random.nextInt(3000 - 1000 + 1000) + 1000;
        
        sellerCoins.setText("  "+this.sellerCoinsValue);
        
        if (Context.getSession().getInventory()[0] == null) {
            Context.getSession().putOnInventory(new Item(new Arrow(12, 0.02), 12, true, 20, 64));
            Context.getSession().putOnInventory(new Item(new Arrow(12, 0.02), 12, true, 20, 64));
            Context.getSession().putOnInventory(new Item(new Arrow(12, 0.02), 12, true, 20, 64));
            Context.getSession().putOnInventory(new Item(new Arrow(12, 0.02), 12, true, 20, 64));
            Context.getSession().putOnInventory(new Item(new Arrow(12, 0.02), 12, true, 20, 64));
            Context.getSession().putOnInventory(new Item(new Armor("armadura das escamas do dragão do fim", 12, 10), 20, true, 1));
            Context.getSession().putOnInventory(new Item(new Pants("Calça", 12, 10), 20, true, 1));
            Context.getSession().putOnInventory(new Item(new Ring("Anel", "Inteligencia", 12), 20, true, 1));
            Context.getSession().putOnInventory(new Item(new Necklace("Colar", "Inteligencia", 12), 20, true, 1));
            Context.getSession().putOnInventory(new Item(new Weapon("Espada", "espada", 12, 12), 20, true, 1));
        }

        userCoins.setText("  " + Context.getSession().getCoins());
        
        Utils.print(Context.getSession().getInventory());

        mountClientList(Context.getSession().getInventory());

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

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
        sellerCoins = new javax.swing.JLabel();
        userCoins = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backblur.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cisco's Medieval RPG: store");
        setMaximumSize(new java.awt.Dimension(580, 490));
        setMinimumSize(new java.awt.Dimension(580, 490));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sellerCoins.setForeground(new java.awt.Color(255, 255, 255));
        sellerCoins.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sellerCoins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coin.png"))); // NOI18N
        sellerCoins.setText("  0");
        getContentPane().add(sellerCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 120, -1));

        userCoins.setForeground(new java.awt.Color(255, 255, 255));
        userCoins.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userCoins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coin.png"))); // NOI18N
        userCoins.setText("  0");
        getContentPane().add(userCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 120, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buy.png"))); // NOI18N
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 196, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equip.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 152, 40));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sell.png"))); // NOI18N
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 40, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
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
        jScrollPane3.setViewportView(jList2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 430, 340));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
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
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel sellerCoins;
    private javax.swing.JLabel userCoins;
    // End of variables declaration//GEN-END:variables
}
