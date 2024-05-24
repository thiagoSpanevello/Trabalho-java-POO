package com.ciscos.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import com.ciscos.project.utils.Context;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        this.setLocation(x, y);
        
        menu.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        landing = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cisco's Medieval RPG: ULTIMATE EDITION ");
        setMaximumSize(new java.awt.Dimension(578, 491));
        setMinimumSize(new java.awt.Dimension(578, 491));
        setPreferredSize(new java.awt.Dimension(578, 491));
        setResizable(false);
        setSize(new java.awt.Dimension(578, 491));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(255, 102, 102));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif"))); // NOI18N
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 120, 120));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        landing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogar.png"))); // NOI18N
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
        landing.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 210, 40));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creditos.png"))); // NOI18N
        jButton3.setAutoscrolls(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        landing.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 40));

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
        Creditos credits = new Creditos();
        credits.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                CharCreation createChar = new CharCreation();
                createChar.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

    }//GEN-LAST:event_jButton2MouseEntered

    /**
     * @param args the command line arguments
     */
    
    public void isThereASession(){
        if(Context.getSession().player != null){
            
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/" + Context.getSession().player.getClass().getSimpleName().toLowerCase() + ".gif")));
            
            menu.setVisible(true);
            landing.setVisible(false);
        }else {
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel landing;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
