package com.ciscos.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import com.ciscos.project.utils.Context;
import com.ciscos.project.Character;
import com.ciscos.project.mage.Mage;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        Context.setMainWindow(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        credits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sellerImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adventureMap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        luigi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        restoreCampfire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);
        advice1.setVisible(false);
        advice.setVisible(!Context.hasEverShopped());
        menu.setVisible(false);
    }

    public void sync() {
        HPbar.setValue((int) Context.getSession().getHp());
        HPbar.setMaximum((int) Context.getSession().getMaxHp());

        XPbar.setValue((int) Context.getSession().getXp());
        XPbar.setMaximum(100);
        labelHP.setText("HP: " + String.format("%.2f", Context.getSession().getHp()) + "/" + String.format("%.2f", Context.getSession().getMaxHp()));
        labelXp.setText("Nível: " + Context.getSession().getLevel() + "   XP: " + String.format("%.2f", Context.getSession().getXp()) + "/" + String.format("%.2f", Context.getSession().getMaxXp()));

        coins.setText("  " + Context.getSession().getCoins());
        advice1.setVisible(!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxHp());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        advice1 = new javax.swing.JLabel();
        restoreCampfire = new javax.swing.JLabel();
        coins = new javax.swing.JLabel();
        luigi = new javax.swing.JLabel();
        advice = new javax.swing.JLabel();
        sellerName2 = new javax.swing.JLabel();
        sellerName1 = new javax.swing.JLabel();
        sellerImg = new javax.swing.JLabel();
        characterName = new javax.swing.JLabel();
        charGif = new javax.swing.JLabel();
        labelHP = new javax.swing.JLabel();
        HPbar = new javax.swing.JProgressBar();
        labelXp = new javax.swing.JLabel();
        XPbar = new javax.swing.JProgressBar();
        statusGUI = new javax.swing.JLabel();
        adventureMap = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        landing = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        credits = new javax.swing.JButton();
        background1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cisco's Medieval RPG: ULTIMATE EDITION ");
        setMinimumSize(new java.awt.Dimension(580, 490));
        setResizable(false);
        setSize(new java.awt.Dimension(580, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(255, 102, 102));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        advice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/advice.png"))); // NOI18N
        menu.add(advice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 10, -1));

        restoreCampfire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/camp.gif"))); // NOI18N
        restoreCampfire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restoreCampfireMouseClicked(evt);
            }
        });
        menu.add(restoreCampfire, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 340, -1, -1));

        coins.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        coins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coin.png"))); // NOI18N
        coins.setText("  0");
        menu.add(coins, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 120, -1));

        luigi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/luigi.png"))); // NOI18N
        menu.add(luigi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        advice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/advice.png"))); // NOI18N
        menu.add(advice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        sellerName2.setForeground(new java.awt.Color(255, 255, 255));
        sellerName2.setText("mercado negro");
        menu.add(sellerName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 422, -1, -1));

        sellerName1.setForeground(new java.awt.Color(255, 255, 255));
        sellerName1.setText("Vendedor do");
        menu.add(sellerName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        sellerImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/seller.gif"))); // NOI18N
        sellerImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellerImgMouseClicked(evt);
            }
        });
        menu.add(sellerImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        characterName.setBackground(new java.awt.Color(0, 0, 0));
        characterName.setForeground(new java.awt.Color(255, 255, 255));
        characterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characterName.setMaximumSize(new java.awt.Dimension(0, 80));
        characterName.setName(""); // NOI18N
        menu.add(characterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 140, -1));

        charGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif"))); // NOI18N
        menu.add(charGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 120, 120));

        labelHP.setForeground(new java.awt.Color(255, 255, 255));
        labelHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHP.setPreferredSize(new java.awt.Dimension(146, 16));
        menu.add(labelHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 20));

        HPbar.setBackground(new java.awt.Color(102, 102, 102));
        HPbar.setPreferredSize(new java.awt.Dimension(146, 16));
        menu.add(HPbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 20));

        labelXp.setForeground(new java.awt.Color(255, 255, 255));
        labelXp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.add(labelXp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, 20));

        XPbar.setBackground(new java.awt.Color(102, 102, 102));
        menu.add(XPbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 20));

        statusGUI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gui.png"))); // NOI18N
        menu.add(statusGUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        adventureMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapIcon.png"))); // NOI18N
        adventureMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adventureMapMouseClicked(evt);
            }
        });
        menu.add(adventureMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background menu.png"))); // NOI18N
        background.setText("jLabel3");
        menu.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        landing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        play.setBackground(new java.awt.Color(0, 0, 0));
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogar.png"))); // NOI18N
        play.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        play.setMaximumSize(new java.awt.Dimension(100, 50));
        play.setMinimumSize(new java.awt.Dimension(100, 50));
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playMouseEntered(evt);
            }
        });
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        landing.add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 220, 40));

        credits.setBackground(new java.awt.Color(0, 0, 0));
        credits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creditos.png"))); // NOI18N
        credits.setAutoscrolls(true);
        credits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        credits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsActionPerformed(evt);
            }
        });
        landing.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 220, 40));

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cisco logo.png"))); // NOI18N
        background1.setToolTipText("");
        background1.setMaximumSize(new java.awt.Dimension(680, 620));
        background1.setMinimumSize(new java.awt.Dimension(680, 620));
        background1.setPreferredSize(new java.awt.Dimension(680, 620));
        landing.add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        getContentPane().add(landing, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsActionPerformed
        if (Context.getCredits() != null) {
            return;
        }
        Creditos credits = new Creditos();
        credits.setVisible(true);
    }//GEN-LAST:event_creditsActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed

        if (Context.getCreation() != null) {
            return;
        }
        CharCreation createChar = new CharCreation();
        createChar.setVisible(true);
    }//GEN-LAST:event_playActionPerformed

    private void playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseEntered

    }//GEN-LAST:event_playMouseEntered

    private void sellerImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellerImgMouseClicked
        // TODO add your handling code here:
        Context.setHasEverShopped(true);

        if (Context.getSeller() == null) {
            Seller seller = new Seller();
            seller.setVisible(true);
        }

        advice.setVisible(false);
    }//GEN-LAST:event_sellerImgMouseClicked

    private void adventureMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adventureMapMouseClicked
        if (Context.getMap() != null) {
            return;
        }
        
        if (Context.getSession().getHp() == 0) {
            JOptionPane.showMessageDialog(this, Context.getSession().getName() + " precisa descansar antes de se aventurar novamente!");
            return;
        }

        if (Context.getSession().getClass().getSimpleName().equals("Mage")) {
            Mage m = (Mage) Context.getSession();
            
            if (m.getMana() < m.getSpells()[0].getMana()) {
                JOptionPane.showMessageDialog(this, Context.getSession().getName() + " precisa descansar antes de se aventurar novamente!");
                return;
            }
            
            if (m.getMana() < m.getMaxMana()* 0.75) {
                JOptionPane.showMessageDialog(this, Context.getSession().getName() + " está com menos de 75% de mana, talvez seja melhor descansar.");
            }
        }
        
        if (Context.getSession().getHp() < Context.getSession().getMaxHp() * 0.75) {
            JOptionPane.showMessageDialog(this, Context.getSession().getName() + " está com menos de 75% de vida, talvez seja melhor descansar.");
        }


        

        CombatMap combatMap = new CombatMap();
        combatMap.setVisible(true);

    }//GEN-LAST:event_adventureMapMouseClicked

    private void restoreCampfireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreCampfireMouseClicked
        // TODO add your handling code here:
        if (!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxXp()) {
            Context.setHasEverHealed(true);
        }

        Context.getSession().restore();
        this.sync();
        advice1.setVisible(false);
        JOptionPane.showMessageDialog(this, Context.getSession().getName() + " descansou e está em seu perfeito estado!");
    }//GEN-LAST:event_restoreCampfireMouseClicked

    /**
     * @param args the command line arguments
     */
    public void isThereASession() {
        if (Context.getSession() != null) {
            charGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/" + Context.getSession().getClass().getSimpleName().toLowerCase() + ".gif")));
            characterName.setText(Context.getSession().getName());
            labelHP.setText("HP: " + String.format("%.2f", Context.getSession().getHp()) + "/" + String.format("%.2f", Context.getSession().getMaxHp()));
            HPbar.setValue((int) Context.getSession().getHp());
            HPbar.setMaximum((int) Context.getSession().getMaxHp());
            HPbar.setForeground(Color.red);
            XPbar.setValue((int) Context.getSession().getXp());
            XPbar.setMaximum(100);
            XPbar.setForeground(Color.BLUE);
            labelXp.setText("Nível: " + Context.getSession().getLevel() + "   XP: " + String.format("%.2f", Context.getSession().getXp()) + "/" + String.format("%.2f", Context.getSession().getMaxXp()));
            menu.setVisible(true);
            landing.setVisible(false);
            advice1.setVisible(!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxHp());
            coins.setText("  " + Context.getSession().getCoins());
        } else {
            menu.setVisible(true);
            landing.setVisible(false);
        }
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar HPbar;
    private javax.swing.JProgressBar XPbar;
    private javax.swing.JLabel adventureMap;
    private javax.swing.JLabel advice;
    private javax.swing.JLabel advice1;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel charGif;
    private javax.swing.JLabel characterName;
    private javax.swing.JLabel coins;
    private javax.swing.JButton credits;
    private javax.swing.JLabel labelHP;
    private javax.swing.JLabel labelXp;
    private javax.swing.JPanel landing;
    private javax.swing.JLabel luigi;
    private javax.swing.JPanel menu;
    private javax.swing.JButton play;
    private javax.swing.JLabel restoreCampfire;
    private javax.swing.JLabel sellerImg;
    private javax.swing.JLabel sellerName1;
    private javax.swing.JLabel sellerName2;
    private javax.swing.JLabel statusGUI;
    // End of variables declaration//GEN-END:variables
}
