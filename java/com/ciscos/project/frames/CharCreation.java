package com.ciscos.project.frames;

import com.ciscos.project.berserker.Berserker;
import com.ciscos.project.mage.Mage;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class CharCreation extends javax.swing.JFrame {

    public CharCreation() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2 + 50;
        int y = (dim.height-h)/2 + 50;

        this.setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        cbClass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nome do Personagem");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
        getContentPane().add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 390, 30));

        cbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mago", "Arqueiro", "Berserker" }));
        cbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClassActionPerformed(evt);
            }
        });
        getContentPane().add(cbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, 30));

        jLabel3.setText("Classe do Personagem");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 333, 390, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tfName.getText().length() >= 4){
            if (cbClass.getSelectedItem().toString() == "Berserker"){
            Berserker berserker = new Berserker(tfName.getText(), 20, 10, 5, 10);
            }else if(cbClass.getSelectedItem().toString() == "Mago"){
            Mage mago = new Mage(tfName.getText(), 10, 5, 100, 5, 10);
            }else{
            
            }
            JOptionPane.showMessageDialog(this, "Personagem " + tfName.getText() + " da classe " + cbClass.getSelectedItem().toString() + " foi criado com sucesso!");
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "O nome do personagem precisa ter quatro letras ou mais!");
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CharCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharCreation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbClass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
