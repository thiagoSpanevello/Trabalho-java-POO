package com.ciscos.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import com.ciscos.project.utils.Context;
import com.ciscos.project.utils.ColorBlind;
import com.ciscos.project.Character;
import com.ciscos.project.mage.Mage;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        Context.setMainWindow(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        try {
        InputStream is = getClass().getResourceAsStream("/Fonts/minecraft_font.ttf");
        if (is == null) {
            throw new IOException("Fonte não encontrada!");
        }
        Font minecraftFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(12f);
        jButton1.setFont(minecraftFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        jButton1.setForeground(new Color(221, 221, 197));
        jButton1.setFocusPainted(false); 
        jButton1.setContentAreaFilled(true);      
        jButton1.setOpaque(true); 
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        

        
        jLabel1.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/cisco logo.png")));        
        jButton2.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/jogar.png")));        
        jButton3.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/creditos.png")));

        jLabel9.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/gui.png")));     
        jLabel3.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/background menu.png")));  
        money.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/coin.png")));
        jLabel8.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/mapIcon.png")));
        jLabel7.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/luigi.png")));
        
        advice1.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/advice.png")));
        advice.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/advice.png")));
        

        
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
        HPbarP.setValue((int) Context.getSession().getHp());
        HPbarP.setMaximum((int) Context.getSession().getMaxHp());
        
        XPbar.setValue((int) Context.getSession().getXp());
        XPbar.setMaximum(100);
        labelHPP.setText("HP: " + String.format("%.2f", Context.getSession().getHp()) + "/" + String.format("%.2f", Context.getSession().getMaxHp()));
        labelXp.setText("Nível: " + Context.getSession().getLevel() + "   XP: " + String.format("%.2f", Context.getSession().getXp()) + "/" + String.format("%.2f", Context.getSession().getMaxXp()));

        money.setText("  " + Context.getSession().getCoins());
        advice1.setVisible(!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxHp());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        advice1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        advice = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        characterName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelHPP = new javax.swing.JLabel();
        HPbarP = new javax.swing.JProgressBar();
        labelXp = new javax.swing.JLabel();
        XPbar = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        landing = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/camp.gif"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        menu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 340, -1, -1));

        money.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        money.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coin.png"))); // NOI18N
        money.setText("  0");
        menu.add(money, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 120, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/luigi.png"))); // NOI18N
        menu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        advice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/advice.png"))); // NOI18N
        menu.add(advice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("mercado negro");
        menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 422, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vendedor do");
        menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/seller.gif"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        characterName.setBackground(new java.awt.Color(0, 0, 0));
        characterName.setForeground(new java.awt.Color(255, 255, 255));
        characterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characterName.setMaximumSize(new java.awt.Dimension(0, 80));
        characterName.setName(""); // NOI18N
        menu.add(characterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 140, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif"))); // NOI18N
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 120, 120));

        labelHPP.setForeground(new java.awt.Color(255, 255, 255));
        labelHPP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHPP.setPreferredSize(new java.awt.Dimension(146, 16));
        menu.add(labelHPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 20));

        HPbarP.setBackground(new java.awt.Color(102, 102, 102));
        HPbarP.setPreferredSize(new java.awt.Dimension(146, 16));
        menu.add(HPbarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 20));

        labelXp.setForeground(new java.awt.Color(255, 255, 255));
        labelXp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.add(labelXp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, 20));

        XPbar.setBackground(new java.awt.Color(102, 102, 102));
        menu.add(XPbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gui.png"))); // NOI18N
        menu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapIcon.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background menu.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        landing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogar.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton2.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        landing.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 220, 40));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creditos.png"))); // NOI18N
        jButton3.setAutoscrolls(true);
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        landing.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 220, 40));

        jButton1.setBackground(new java.awt.Color(111, 111, 111));
        jButton1.setForeground(new java.awt.Color(221, 221, 197));
        jButton1.setText("Modos");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        landing.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 190, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cisco logo.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(680, 620));
        jLabel1.setMinimumSize(new java.awt.Dimension(680, 620));
        jLabel1.setPreferredSize(new java.awt.Dimension(680, 620));
        landing.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        getContentPane().add(landing, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (Context.getCredits() != null) {
            return;
        }
        Creditos credits = new Creditos();
        credits.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (Context.getCreation() != null) {
            return;
        }
        CharCreation createChar = new CharCreation();
        createChar.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

    }//GEN-LAST:event_jButton2MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Context.setHasEverShopped(true);

        if (Context.getSeller() == null) {
            Seller seller = new Seller();
            seller.setVisible(true);
        }

        advice.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
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

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        if (!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxXp()) {
            Context.setHasEverHealed(true);
        }

        Context.getSession().restore();
        this.sync();
        advice1.setVisible(false);
        JOptionPane.showMessageDialog(this, Context.getSession().getName() + " descansou e está em seu perfeito estado!");
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int mode;  
        if (Context.getColorblind()+1 < 4) {
            mode = Context.getColorblind()+1;
            Context.setColorblind(mode);
        }else{
            mode = 0;
            Context.setColorblind(0);
        }
            switch (mode) {
            case 0:
                jButton1.setText("Normal");
                break;
            case 1:
                 jButton1.setText("Protanopia");
                 break;
            case 2:
                 jButton1.setText(" Deuteranopia");
                 break;
            case 3:
                 jButton1.setText("Tritanopia");
                break;
            default:
                throw new AssertionError("Modo inválido: " + mode);
        }
            reloadUI();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void isThereASession() {
        if (Context.getSession() != null) {
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/" + Context.getSession().getClass().getSimpleName().toLowerCase() + ".gif")));
            characterName.setText(Context.getSession().getName());
            labelHPP.setText("HP: " + String.format("%.2f", Context.getSession().getHp()) + "/" + String.format("%.2f", Context.getSession().getMaxHp()));
            HPbarP.setValue((int) Context.getSession().getHp());
            HPbarP.setMaximum((int) Context.getSession().getMaxHp());
            HPbarP.setForeground(ColorBlind.filter(Color.red, Context.getColorblind()));
            XPbar.setForeground(ColorBlind.filter(Color.BLUE, Context.getColorblind()));
            
            XPbar.setValue((int) Context.getSession().getXp());
            XPbar.setMaximum(100);
            labelXp.setText("Nível: " + Context.getSession().getLevel() + "   XP: " + String.format("%.2f", Context.getSession().getXp()) + "/" + String.format("%.2f", Context.getSession().getMaxXp()));
            menu.setVisible(true);
            landing.setVisible(false);
            advice1.setVisible(!Context.isHasEverHealed() && Context.getSession().getHp() < Context.getSession().getMaxHp());
            money.setText("  " + Context.getSession().getCoins());
        } else {
            menu.setVisible(true);
            landing.setVisible(false);
        }
    }
    
    private void reloadUI() {
        jLabel1.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/cisco logo.png")));        
        jButton2.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/jogar.png")));        
        jButton3.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/creditos.png")));
        jLabel9.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/gui.png")));     
        jLabel3.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/background menu.png")));  
        money.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/coin.png")));
        jLabel8.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/mapIcon.png")));
        jLabel7.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/luigi.png")));
        advice1.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/advice.png")));
        advice.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/advice.png")));

        HPbarP.setForeground(ColorBlind.filter(Color.red, Context.getColorblind()));
        XPbar.setForeground(ColorBlind.filter(Color.BLUE, Context.getColorblind()));

        if (Context.getSession() != null) {
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/" + Context.getSession().getClass().getSimpleName().toLowerCase() + ".gif")));
            HPbarP.setMaximum((int) Context.getSession().getMaxHp());
            HPbarP.setValue((int) Context.getSession().getHp());
            XPbar.setValue((int) Context.getSession().getXp());
            XPbar.setMaximum(100);
            labelHPP.setText("HP: " + String.format("%.2f", Context.getSession().getHp()) + "/" + String.format("%.2f", Context.getSession().getMaxHp()));
            labelXp.setText("Nível: " + Context.getSession().getLevel() + "   XP: " + String.format("%.2f", Context.getSession().getXp()) + "/" + String.format("%.2f", Context.getSession().getMaxXp()));
            money.setText("  " + Context.getSession().getCoins());
            characterName.setText(Context.getSession().getName());
        }

        // Revalidate e repaint para garantir atualização visual
        this.revalidate();
        this.repaint();
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
    private javax.swing.JProgressBar HPbarP;
    private javax.swing.JProgressBar XPbar;
    private javax.swing.JLabel advice;
    private javax.swing.JLabel advice1;
    private javax.swing.JLabel characterName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelHPP;
    private javax.swing.JLabel labelXp;
    private javax.swing.JPanel landing;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel money;
    // End of variables declaration//GEN-END:variables
}
