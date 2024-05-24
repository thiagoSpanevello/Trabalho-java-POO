package com.ciscos.project.frames;

import com.ciscos.project.archer.Archer;
import com.ciscos.project.berserker.Berserker;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.utils.Context;
import com.ciscos.project.Character;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class CharCreation extends javax.swing.JFrame {

    public CharCreation() {
        initComponents();
        Context.setCreation(this);
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

        specialField = new javax.swing.JLabel();
        specialInput = new javax.swing.JTextField();
        speedInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hpInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        cbClass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        characterGif = new javax.swing.JLabel();
        characterName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cisco's Medieval RPG: Criação");
        setResizable(false);
        setSize(new java.awt.Dimension(580, 490));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        specialField.setForeground(new java.awt.Color(255, 255, 255));
        specialField.setText("Destreza");
        getContentPane().add(specialField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        specialInput.setEditable(false);
        specialInput.setText("5");
        specialInput.setActionCommand("<Not Set>");
        specialInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                specialInputCaretUpdate(evt);
            }
        });
        getContentPane().add(specialInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 160, 30));

        speedInput.setEditable(false);
        speedInput.setText("15");
        speedInput.setActionCommand("<Not Set>");
        speedInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                speedInputCaretUpdate(evt);
            }
        });
        getContentPane().add(speedInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Velocidade");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pontos de vida (HP)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        hpInput.setEditable(false);
        hpInput.setText("60");
        hpInput.setActionCommand("<Not Set>");
        hpInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                hpInputCaretUpdate(evt);
            }
        });
        hpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpInputActionPerformed(evt);
            }
        });
        getContentPane().add(hpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do Personagem");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        nameInput.setActionCommand("<Not Set>");
        nameInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nameInputCaretUpdate(evt);
            }
        });
        getContentPane().add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 270, 30));

        cbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arqueiro", "Berserker", "Mago" }));
        cbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClassActionPerformed(evt);
            }
        });
        getContentPane().add(cbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Classe do Personagem");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/concluir.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 320, 40));

        jPanel1.setBackground(new java.awt.Color(111, 111, 95));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif"))); // NOI18N
        jPanel1.add(characterGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        characterName.setBackground(new java.awt.Color(0, 0, 0));
        characterName.setForeground(new java.awt.Color(255, 255, 255));
        characterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        characterName.setMaximumSize(new java.awt.Dimension(0, 80));
        characterName.setName(""); // NOI18N
        jPanel1.add(characterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 140, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backblur.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClassActionPerformed
        // TODO add your handling code here:
        int i = cbClass.getSelectedIndex();
        
        switch (i) {
            case 0:
                specialField.setText("Destreza");
                
                hpInput.setText("60");
                speedInput.setText("15");
                specialInput.setText("5");
                
                characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif")));
                break;
            case 1:
                specialField.setText("Força");
                
                hpInput.setText("70");
                speedInput.setText("10");
                specialInput.setText("5");
                
                characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/berserker.gif")));
                break;
            case 2:
                specialField.setText("Inteligência");
                
                hpInput.setText("50");
                speedInput.setText("10");
                specialInput.setText("5");
                
                characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/mage.gif")));
                break;  
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_cbClassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nameInput.getText().length() >= 4){
            Character p;
            if (cbClass.getSelectedItem().toString().equals("Berserker")){
                Berserker berserker = new Berserker(nameInput.getText(), 70, 10, 5, 10);
                Context.setSession(berserker);
            }else if(cbClass.getSelectedItem().toString().equals("Mago")){
                Mage mago = new Mage(nameInput.getText(), 50, 10, 100, 5);
                Context.setSession(mago);
            }else{
                Archer arqueiro = new Archer(nameInput.getText(), 60, 15, 5);
                Context.setSession(arqueiro);
            }
            p = Context.getSession();
            JOptionPane.showMessageDialog(this, "Personagem " + p.getName() + " da classe " + cbClass.getSelectedItem().toString() + " foi criado com sucesso!");
            dispose();
            Context.getMainWindow().isThereASession();
        }else{
            JOptionPane.showMessageDialog(this, "O nome do personagem precisa ter quatro letras ou mais!");
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nameInputCaretUpdate
        // TODO add your handling code here:
        characterName.setText(nameInput.getText());
    }//GEN-LAST:event_nameInputCaretUpdate

    private void hpInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_hpInputCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_hpInputCaretUpdate

    private void speedInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_speedInputCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_speedInputCaretUpdate

    private void specialInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_specialInputCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_specialInputCaretUpdate

    private void hpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hpInputActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Context.setCreation(null);
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JLabel characterGif;
    private javax.swing.JLabel characterName;
    private javax.swing.JTextField hpInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel specialField;
    private javax.swing.JTextField specialInput;
    private javax.swing.JTextField speedInput;
    // End of variables declaration//GEN-END:variables
}
