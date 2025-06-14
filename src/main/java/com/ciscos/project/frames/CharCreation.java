package com.ciscos.project.frames;

import com.ciscos.project.archer.Archer;
import com.ciscos.project.berserker.Berserker;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.utils.Context;
import com.ciscos.project.items.List;
import com.ciscos.project.items.Item;
import com.ciscos.project.equipment.Weapon;
import com.ciscos.project.Character;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import com.ciscos.project.utils.ColorBlind;

public class CharCreation extends javax.swing.JFrame {

    public CharCreation() {
        initComponents();
        Context.setCreation(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        cbClass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        int w = this.getSize().width;
        int h = this.getSize().height;

        int x = (dim.width - w) / 2 + 50;
        int y = (dim.height - h) / 2 + 50;

        jLabel1.setIcon(ColorBlind.colorblindimage(getClass().getResource("/images/backblur.png")));
        
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
        characterName = new javax.swing.JLabel();
        characterGif = new javax.swing.JLabel();
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        specialField.setForeground(new java.awt.Color(255, 255, 255));
        specialField.setText("Destreza");
        getContentPane().add(specialField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        specialInput.setEditable(false);
        specialInput.setBackground(new java.awt.Color(40, 40, 40));
        specialInput.setText("5");
        specialInput.setActionCommand("<Not Set>");
        specialInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        specialInput.setCaretColor(new java.awt.Color(238, 238, 238));
        specialInput.setDisabledTextColor(new java.awt.Color(221, 221, 221));
        specialInput.setBorder(BorderFactory.createCompoundBorder(
            specialInput.getBorder(),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    specialInput.setEnabled(false);
    specialInput.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
            specialInputCaretUpdate(evt);
        }
    });
    getContentPane().add(specialInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 160, 30));

    speedInput.setEditable(false);
    speedInput.setBackground(new java.awt.Color(40, 40, 40));
    speedInput.setText("15");
    speedInput.setActionCommand("<Not Set>");
    speedInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    speedInput.setCaretColor(new java.awt.Color(40, 40, 40));
    speedInput.setDisabledTextColor(new java.awt.Color(221, 221, 221));
    speedInput.setEnabled(false);
    speedInput.setFocusable(false);
    speedInput.setPreferredSize(new java.awt.Dimension(19, 19));
    speedInput.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
            speedInputCaretUpdate(evt);
        }
    });
    getContentPane().add(speedInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, 30));
    speedInput.setBorder(BorderFactory.createCompoundBorder(
        speedInput.getBorder(),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

jLabel5.setForeground(new java.awt.Color(255, 255, 255));
jLabel5.setText("Velocidade");
getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

jLabel4.setForeground(new java.awt.Color(255, 255, 255));
jLabel4.setText("Pontos de vida (HP)");
getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

hpInput.setEditable(false);
hpInput.setBackground(new java.awt.Color(40, 40, 40));
hpInput.setText("60");
hpInput.setActionCommand("<Not Set>");
hpInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
hpInput.setCaretColor(new java.awt.Color(40, 40, 40));
hpInput.setBorder(BorderFactory.createCompoundBorder(
    hpInput.getBorder(),
    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    hpInput.setDisabledTextColor(new java.awt.Color(221, 221, 221));
    hpInput.setEnabled(false);
    hpInput.setMargin(new java.awt.Insets(20, 20, 20, 20));
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

    nameInput.setBackground(new java.awt.Color(40, 40, 40));
    nameInput.setForeground(new java.awt.Color(221, 221, 221));
    nameInput.setActionCommand("<Not Set>");
    nameInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    nameInput.setCaretColor(new java.awt.Color(221, 221, 221));
    nameInput.setBorder(BorderFactory.createCompoundBorder(
        nameInput.getBorder(),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
nameInput.addCaretListener(new javax.swing.event.CaretListener() {
    public void caretUpdate(javax.swing.event.CaretEvent evt) {
        nameInputCaretUpdate(evt);
    }
    });
    nameInput.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            nameInputKeyPressed(evt);
        }
    });
    getContentPane().add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 270, 30));

    cbClass.setBackground(new java.awt.Color(40, 40, 40));
    cbClass.setForeground(new java.awt.Color(221, 221, 221));
    cbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arqueiro", "Berserker", "Mago" }));
    cbClass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    cbClass.setOpaque(true);
    cbClass.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbClassActionPerformed(evt);
        }
    });
    getContentPane().add(cbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 30));
    for (int i = 0; i < cbClass.getComponentCount(); i++)
    {
        if (cbClass.getComponent(i) instanceof JComponent) {
            ((JComponent) cbClass.getComponent(i)).setBorder(new EmptyBorder(0, 0,0,0));
        }

        if (cbClass.getComponent(i) instanceof AbstractButton) {
            ((AbstractButton) cbClass.getComponent(i)).setBorderPainted(false);
        }
    }

    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Classe do Personagem");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/concluir.png"))); // NOI18N
    jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 320, 40));

    jPanel1.setBackground(new java.awt.Color(111, 111, 95));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    characterName.setBackground(new java.awt.Color(0, 0, 0));
    characterName.setForeground(new java.awt.Color(255, 255, 255));
    characterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    characterName.setMaximumSize(new java.awt.Dimension(0, 80));
    characterName.setName(""); // NOI18N
    jPanel1.add(characterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, -1));

    characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/archer.gif"))); // NOI18N
    jPanel1.add(characterGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

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

                hpInput.setText("65");
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

                hpInput.setText("60");
                speedInput.setText("10");
                specialInput.setText("5");

                characterGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gifs/mage.gif")));
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_cbClassActionPerformed

    private void create() {
        if (nameInput.getText().length() >= 4) {
            Character p;
            if (cbClass.getSelectedItem().toString().equals("Berserker")) {
                Berserker berserker = new Berserker(nameInput.getText(), 70, 10, 5, 10);
                Context.setSession(berserker);
            } else if (cbClass.getSelectedItem().toString().equals("Mago")) {
                Mage mago = new Mage(nameInput.getText(), 60, 10, 100, 5);
                Context.setSession(mago);
            } else {
                Archer arqueiro = new Archer(nameInput.getText(), 65, 15, 5);
                Context.setSession(arqueiro);
            }
            p = Context.getSession();

            Item armor = List.armors[0];
            Item pants = List.pants[0];
            Item life = List.potions[0];

            Item weapon = List.getWeapons().get(Context.getSession().getClass().getSimpleName())[0];

            Item mana = List.potions[1];

            Item arrow = List.randoms[0];

            p.equip(armor);
            p.equip(pants);
            p.equip(weapon);
            p.setCoins(50);

            JOptionPane.showMessageDialog(this, "Personagem " + p.getName() + " da classe " + cbClass.getSelectedItem().toString() + " foi criado com sucesso!");

            String message = "Você recebeu um kit iniciante para a sua jornada: \n";
            message += "1x " + armor.data.getName() + " (Equipado); \n";
            message += "1x " + pants.data.getName() + " (Equipado); \n";

            Weapon w = (Weapon) weapon.data;

            message += "1x " + weapon.data.getName() + " (" + w.getType() + ") (Equipado); \n";

            for (int i = 0; i < 3; i++) {
                p.putOnInventory(life);
            }

            message += "3x " + life.data.getName() + "; \n";

            if (cbClass.getSelectedItem().toString().equals("Mago")) {
                p.putOnInventory(mana);
                message += "1x " + mana.data.getName() + "; \n";
            }

            if (cbClass.getSelectedItem().toString().equals("Arqueiro")) {
                for (int i = 0; i < 20; i++) {
                    p.putOnInventory(arrow);
                }
                message += "20x " + arrow.data.getName() + ";\n";
            }
            
            message += "50x moedas;";

            JOptionPane.showMessageDialog(this, message);

            dispose();
            Context.getMainWindow().isThereASession();
        } else {
            JOptionPane.showMessageDialog(this, "O nome do personagem precisa ter quatro letras ou mais!");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        create();
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

    private void nameInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameInputKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameInputKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            create();
        }
    }//GEN-LAST:event_formKeyPressed

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
