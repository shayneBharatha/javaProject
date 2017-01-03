package interfaces;

import javax.swing.JFileChooser;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author shayne
 */
public class SChat extends javax.swing.JFrame {
    
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port;
    Boolean isConnected;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    
    boolean isVisible = false;
    
    public void listenThread() {
        Thread incommingReader = new Thread(new incommingReader());
        incommingReader.start();
    }
    
    public void userAdd(String data) {
        users.add(data);
    }
    
    public void userRemove(String data) {
        ta_chat.append(data + "is now offline.\n");
    }
    
    public void writeUser() {
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);
        for (String token : tempList) {
//            users.append(token++"\n");
        }
    }
    
    public void sendDisconnect() {
        String bye = (username + ": :Disconnect");
        try {
            writer.println(bye);
            writer.flush();
        } catch (Exception e) {
            ta_chat.append("Could not send Disconnect message.\n");
        }
    }
    
    public void Discoonect() {
        try {
            ta_chat.append("Disconnected.\n");
            sock.close();
        } catch (Exception e) {
            ta_chat.append("Failed to disconnect.\n");
        }
        isConnected = false;
//        tf_username.setEditable(true);
    }
    
    public SChat() {
        initComponents();
        pnl_config.setVisible(false);
        pnl_config2.setVisible(false);
        String uname[] = tf_username.getText().split(", ");
        username = uname[1];
    }
    
    public class incommingReader implements Runnable {
        
        @Override
        public void run() {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";
            try {
                while ((stream = reader.readLine()) != null) {
                    data = stream.split(":");
                    if (data[2].equals(chat)) {
                        ta_chat.append(data[0] + ": " + data[1] + "\n");
                        ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
                    } else if (data[2].equals(connect)) {
                        ta_chat.removeAll();
                        userAdd(data[0]);
                    } else if (data[2].equals(disconnect)) {
                        userRemove(data[0]);
                    } else if (data[2].equals(done)) {
                        writeUser();
                        users.clear();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_footer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_message = new javax.swing.JPanel();
        tf_chat = new javax.swing.JTextField();
        b_send = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        btn_config = new javax.swing.JButton();
        pnl_config = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_port = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        pnl_connect = new javax.swing.JPanel();
        tf_username = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        b_connect = new javax.swing.JButton();
        b_disconnect = new javax.swing.JButton();
        b_anonymous = new javax.swing.JButton();
        pnl_config2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnl_config1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 150, 150, 150));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(pnl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 60));

        pnl_footer.setBackground(new java.awt.Color(102, 102, 102));
        pnl_footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CLICK.me inc.");
        pnl_footer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("V 2.0.1");
        pnl_footer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 5, -1, -1));

        jPanel1.add(pnl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 880, 30));

        pnl_message.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_message.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_chat.setText("Type a message...");
        tf_chat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_chatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_chatFocusLost(evt);
            }
        });
        pnl_message.add(tf_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 500, 440, 50));

        b_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/send.png"))); // NOI18N
        b_send.setBorderPainted(false);
        b_send.setContentAreaFilled(false);
        b_send.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/send_click.png"))); // NOI18N
        b_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sendActionPerformed(evt);
            }
        });
        pnl_message.add(b_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 490, 66, 63));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Attach.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Attach_click.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnl_message.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 496, 50, -1));

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        pnl_message.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 550, 440));

        jPanel1.add(pnl_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 570, 560));

        btn_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/config.png"))); // NOI18N
        btn_config.setBorderPainted(false);
        btn_config.setContentAreaFilled(false);
        btn_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configActionPerformed(evt);
            }
        });
        jPanel1.add(btn_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 50, 50));

        pnl_config.setBackground(new java.awt.Color(102, 102, 102));
        pnl_config.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Port :");

        tf_port.setText("2222");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address :");

        tf_address.setText("localhost");

        javax.swing.GroupLayout pnl_configLayout = new javax.swing.GroupLayout(pnl_config);
        pnl_config.setLayout(pnl_configLayout);
        pnl_configLayout.setHorizontalGroup(
            pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_configLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_configLayout.createSequentialGroup()
                        .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(tf_address))
                .addContainerGap())
        );
        pnl_configLayout.setVerticalGroup(
            pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_configLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 280, 100));

        pnl_connect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tf_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_username.setText("Hello, Member");

        jLabel8.setText("Welcome to SChat");

        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        b_disconnect.setText("Disconnect");
        b_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_disconnectActionPerformed(evt);
            }
        });

        b_anonymous.setText("anon");
        b_anonymous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_anonymousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_connectLayout = new javax.swing.GroupLayout(pnl_connect);
        pnl_connect.setLayout(pnl_connectLayout);
        pnl_connectLayout.setHorizontalGroup(
            pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_connectLayout.createSequentialGroup()
                .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_connectLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnl_connectLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_username)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)))
                .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_anonymous)
                    .addComponent(b_disconnect))
                .addContainerGap())
        );
        pnl_connectLayout.setVerticalGroup(
            pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_connectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_username)
                    .addComponent(b_anonymous))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_connect)
                    .addComponent(b_disconnect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, 100));

        pnl_config2.setBackground(new java.awt.Color(102, 102, 102));
        pnl_config2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_config2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dna.gif"))); // NOI18N
        jLabel10.setText("jLabel10");
        pnl_config2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 320));

        jPanel1.add(pnl_config2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 280, 340));

        pnl_config1.setBackground(new java.awt.Color(102, 102, 102));
        pnl_config1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SChat Configurations >");

        javax.swing.GroupLayout pnl_config1Layout = new javax.swing.GroupLayout(pnl_config1);
        pnl_config1.setLayout(pnl_config1Layout);
        pnl_config1Layout.setHorizontalGroup(
            pnl_config1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_config1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        pnl_config1Layout.setVerticalGroup(
            pnl_config1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_config1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 280, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_chatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_chatFocusGained
        if (tf_chat.getText().equals("Type a message...")) {
            tf_chat.setText(null);
        }
    }//GEN-LAST:event_tf_chatFocusGained

    private void tf_chatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_chatFocusLost
        if (tf_chat.getText().equals("")) {
            tf_chat.setText("Type a message...");
        }
    }//GEN-LAST:event_tf_chatFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser jf = new JFileChooser();
        int i = jf.showOpenDialog(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void b_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sendActionPerformed
//        String now = jTextArea1.getText();
//        String msg = jTextField1.getText();
//        jTextArea1.setText(now + "\n\n" + msg);
//        jTextField1.setText("Type a message...");

        String nothing = "Type a message...";
        if ((tf_chat.getText()).equals(nothing) || tf_chat.getText().equals("")) {
//            tf_chat.setText("");
            tf_chat.requestFocus();
        } else {
            try {
                writer.println(username + ":" + tf_chat.getText() + ":" + "Chat");
                writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                ta_chat.append("Message was not sent. \n");
            }
//            tf_chat.setText("");
            tf_chat.requestFocus();
        }

//        tf_chat.setText("");
        tf_chat.requestFocus();
    }//GEN-LAST:event_b_sendActionPerformed

    private void btn_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configActionPerformed
        if (isVisible == false) {
            pnl_config.setVisible(true);
            pnl_config2.setVisible(true);
            isVisible = true;
        } else {
            pnl_config.setVisible(false);
            pnl_config2.setVisible(false);
            isVisible = false;
        }

    }//GEN-LAST:event_btn_configActionPerformed

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        if (isConnected == false) {
            try {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect");
                writer.flush();
                isConnected = true;
            } catch (Exception e) {
                ta_chat.append("Connot connect! Try Again. \n");
            }
            listenThread();
        } else if (isConnected == true) {
            ta_chat.append("You are already connected. \n");
        }
    }//GEN-LAST:event_b_connectActionPerformed

    private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
        sendDisconnect();
        Discoonect();
    }//GEN-LAST:event_b_disconnectActionPerformed

    private void b_anonymousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_anonymousActionPerformed
        username = "";
        if (isConnected == false) {
            String anon = "anon";
            Random generator = new Random();
            int i = generator.nextInt(999) + 1;
            String is = String.valueOf(i);
            anon = anon.concat(is);
            username = anon;
            
            try {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(anon + ":has connected.:Connect");
                writer.flush();
                isConnected = true;
            } catch (Exception e) {
                ta_chat.append("Cannot connect! Try again. \n");
            }
            listenThread();
        } else if (isConnected == true) {
            ta_chat.append("You are already connected. \n");
        }
    }//GEN-LAST:event_b_anonymousActionPerformed

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
            java.util.logging.Logger.getLogger(SChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_anonymous;
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_disconnect;
    private javax.swing.JButton b_send;
    private javax.swing.JButton btn_config;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_config;
    private javax.swing.JPanel pnl_config1;
    private javax.swing.JPanel pnl_config2;
    private javax.swing.JPanel pnl_connect;
    private javax.swing.JPanel pnl_footer;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_message;
    private javax.swing.JTextArea ta_chat;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_chat;
    private javax.swing.JTextField tf_port;
    private javax.swing.JLabel tf_username;
    // End of variables declaration//GEN-END:variables
}
