package interfaces;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author shayne
 */
public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
        jLabel1.grabFocus();
        pnl_register.setVisible(false);
    }

    private void login() {
        String myPass = new String(login_pass.getPassword());
        String myUname = new String(login_uname.getText());
        try {
            ResultSet rs = classes.mysql.sql().executeQuery("SELECT * FROM mems WHERE uname='" + login_uname.getText() + "'");
            if (rs.next()) {
                String un = rs.getString("uname");
                String pass = rs.getString("pass");
                if (myUname.equals(un) && myPass.equals(pass)) {
                    new SChat().setVisible(true);
                    login.this.dispose();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_login = new javax.swing.JPanel();
        pnl_register = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_bday = new javax.swing.JTextField();
        txt_mobile = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_uname = new javax.swing.JTextField();
        combo_sex = new javax.swing.JComboBox();
        txt_pass = new javax.swing.JPasswordField();
        txt_pass2 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        btn_browse = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        pnl_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_footer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        login_uname = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        login_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_forgot = new javax.swing.JLabel();
        btn_regMe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(700, 150, 300, 300));
        setResizable(false);

        panel_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Register for free");

        jLabel7.setText("Name :");

        jLabel8.setText("Birthday :");

        jLabel9.setText("Sex :");

        jLabel10.setText("Mobile :");

        jLabel11.setText("Email :");

        jLabel12.setText("Username :");

        jLabel13.setText("Password :");

        jLabel14.setText("Confirm Password :");

        txt_mail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mailFocusLost(evt);
            }
        });

        txt_uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_unameKeyReleased(evt);
            }
        });

        combo_sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose yours...", "Male", "Female" }));

        jLabel17.setText("Image :");

        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        btn_register.setText("Register >");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        btn_back.setText("< Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_registerLayout = new javax.swing.GroupLayout(pnl_register);
        pnl_register.setLayout(pnl_registerLayout);
        pnl_registerLayout.setHorizontalGroup(
            pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_registerLayout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_register))
                    .addGroup(pnl_registerLayout.createSequentialGroup()
                        .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name)
                            .addComponent(txt_bday)
                            .addComponent(combo_sex, 0, 203, Short.MAX_VALUE)
                            .addComponent(txt_mobile)
                            .addComponent(txt_mail)
                            .addComponent(txt_uname)
                            .addComponent(txt_pass)
                            .addComponent(txt_pass2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_registerLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btn_browse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnl_registerLayout.setVerticalGroup(
            pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_bday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_registerLayout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(pnl_registerLayout.createSequentialGroup()
                        .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(btn_browse))
                        .addGap(54, 54, 54)))
                .addGroup(pnl_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register)
                    .addComponent(btn_back))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        panel_login.add(pnl_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 385, 560));

        pnl_header.setBackground(new java.awt.Color(102, 102, 102));
        pnl_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chat");
        pnl_header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("S");
        pnl_header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panel_login.add(pnl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 60));

        pnl_footer.setBackground(new java.awt.Color(102, 102, 102));
        pnl_footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CLICK.me inc.");
        pnl_footer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("V 2.0.1");
        pnl_footer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 5, -1, -1));

        panel_login.add(pnl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 390, 30));

        login_uname.setText("Username");
        login_uname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                login_unameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                login_unameFocusLost(evt);
            }
        });
        login_uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                login_unameKeyPressed(evt);
            }
        });
        panel_login.add(login_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 190, -1));
        panel_login.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, 20));

        login_pass.setText("Password");
        login_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                login_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                login_passFocusLost(evt);
            }
        });
        login_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                login_passKeyPressed(evt);
            }
        });
        panel_login.add(login_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, -1));

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panel_login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 260, -1, -1));

        btn_forgot.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_forgot.setForeground(new java.awt.Color(0, 0, 255));
        btn_forgot.setText("forgot password?");
        btn_forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_forgotMouseReleased(evt);
            }
        });
        panel_login.add(btn_forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 263, -1, -1));

        btn_regMe.setBackground(new java.awt.Color(204, 204, 0));
        btn_regMe.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btn_regMe.setText("Register for free");
        btn_regMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regMeActionPerformed(evt);
            }
        });
        panel_login.add(btn_regMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_unameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_unameFocusGained
        if (login_uname.getText().equals("Username")) {
            login_uname.setText("");
        }
    }//GEN-LAST:event_login_unameFocusGained

    private void login_unameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_unameFocusLost
        if (login_uname.getText().equals("")) {
            login_uname.setText("Username");
        }
    }//GEN-LAST:event_login_unameFocusLost

    private void login_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_passFocusGained
        String pass = new String(login_pass.getPassword());
        if (pass.equals("Password")) {
            login_pass.setText("");
        }
    }//GEN-LAST:event_login_passFocusGained

    private void login_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_passFocusLost
        String pass = new String(login_pass.getPassword());
        if (pass.equals("")) {
            login_pass.setText("Password");
        }
    }//GEN-LAST:event_login_passFocusLost

    private void btn_forgotMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_forgotMouseReleased
        try {
            URI web = new URI("file:///C:/Users/shayn/Documents/NetBeansProjects/SChat2/src/Web/forgot.html"); //WebSite
            Desktop dt = Desktop.getDesktop();
            dt.browse(web);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_forgotMouseReleased

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        JFileChooser jf = new JFileChooser();
        int i = jf.showOpenDialog(this);
        File file = jf.getSelectedFile();
        try {
            BufferedImage bf = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(bf.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), bf.SCALE_SMOOTH));
            lbl_image.setText(null);
            lbl_image.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_regMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regMeActionPerformed
        pnl_register.setVisible(true);
    }//GEN-LAST:event_btn_regMeActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        pnl_register.setVisible(false);
        jLabel1.grabFocus();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        String idString = Objects.toString(System.currentTimeMillis()).substring(9);
        int id = Integer.parseInt(idString);
        String sex = combo_sex.getSelectedItem().toString();
        String pass = new String(txt_pass.getPassword());
        try {
            classes.mysql.sql().executeUpdate("INSERT INTO mems VALUES ('" + id + "','" + txt_name.getText() + "','" + txt_bday.getText() + "','" + sex + "','" + txt_mobile.getText() + "','" + txt_mail.getText() + "','" + txt_uname.getText() + "','" + pass + "') ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(rootPane, "You Have been registered to SChat successfully.", "Registration Success!", WIDTH);
        pnl_register.setVisible(false);
        txt_name.setText(null);
        txt_bday.setText(null);
        combo_sex.setSelectedIndex(0);
        txt_mobile.setText(null);
        txt_mail.setText(null);
        txt_uname.setText(null);
        txt_pass.setText(null);
        txt_pass2.setText(null);
        lbl_image.setIcon(null);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void txt_mailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mailFocusLost
        String mail;
        try {
            ResultSet rs = classes.mysql.sql().executeQuery("SELECT* FROM mems");
            while (rs.next()) {
                mail = rs.getString("mail");
                if (txt_mail.getText().equals(mail)) {
                    txt_mail.setBackground(Color.red);
                } else {
                    txt_mail.setBackground(Color.white);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txt_mailFocusLost

    private void txt_unameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unameKeyReleased
        String uname;
        try {
            ResultSet rs = classes.mysql.sql().executeQuery("SELECT* FROM mems");
            while (rs.next()) {
                uname = rs.getString("uname");
                if (txt_uname.getText().equals(uname)) {
                    txt_uname.setBackground(Color.red);
                } else {
                    txt_uname.setBackground(Color.white);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_unameKeyReleased

    private void txt_mailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mailFocusGained
        txt_mail.setBackground(Color.white);
    }//GEN-LAST:event_txt_mailFocusGained

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        login();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void login_unameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_unameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_pass.grabFocus();
        }
    }//GEN-LAST:event_login_unameKeyPressed

    private void login_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_login_passKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_browse;
    private javax.swing.JLabel btn_forgot;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_regMe;
    private javax.swing.JButton btn_register;
    private javax.swing.JComboBox combo_sex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JPasswordField login_pass;
    private javax.swing.JTextField login_uname;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPanel pnl_footer;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_register;
    private javax.swing.JTextField txt_bday;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_mobile;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_pass2;
    private javax.swing.JTextField txt_uname;
    // End of variables declaration//GEN-END:variables
}
