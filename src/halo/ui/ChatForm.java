package halo.ui;

import halo.ui.call.RequestCallForm;
import halo.file.FileSender;
import halo.Halo;
import halo.Listener;
import halo.TextSender;
import halo.voice.VoiceClient;
import halo.models.User;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Phan Hieu
 */
public class ChatForm extends javax.swing.JFrame {
    
    private User user;
    private ImageIcon defaultUserIcon;
    private ArrayList<JLabel> myMessage;
    private ArrayList<JLabel> yourMessage;
    
    private final int MESSAGE_MARGIN = 3;
    private int MESSAGE_CURRENT_Y_POSTION = 0;
    
    public User getUser() {
        return user;
    }

    /**
     * Creates new form ChatForm
     */
    public ChatForm() {
        this.user = new User();
        Init();
    }
    
    public ChatForm(User user) {
        this.user = user;
        Init();
    }
    
    private void Init() {
        initComponents();
        Listener.addUserChatting(this);
        this.myMessage = new ArrayList<>();
        this.yourMessage = new ArrayList<>();
        this.getContentPane().setBackground(Color.WHITE);
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResource("/halo/resources/no-user-image-square.jpg"));
            Image newimg = bufferedImage.getScaledInstance(myAvatar.getWidth(), myAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH);
            defaultUserIcon = new ImageIcon(newimg);
        } catch (IOException ex) {
            defaultUserIcon = new ImageIcon();
        }
        
        this.setTitle(this.user.getUserName());

        //set your avatar
        try {
            if (this.user.getAvatar() != null && this.user.getAvatar().length > 0) {
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(this.user.getAvatar()));
                Image newimg = bufferedImage.getScaledInstance(yourAvatar.getWidth(), yourAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH);
                yourAvatar.setIcon(new ImageIcon(newimg));
            } else {
                yourAvatar.setIcon(defaultUserIcon);
            }
        } catch (IOException ex) {
            yourAvatar.setIcon(defaultUserIcon);
        }

        //set my avatar
        try {
            if (Halo.user.getAvatar() != null && Halo.user.getAvatar().length > 0) {
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Halo.user.getAvatar()));
                Image newimg = bufferedImage.getScaledInstance(myAvatar.getWidth(), myAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH);
                myAvatar.setIcon(new ImageIcon(newimg));
            } else {
                myAvatar.setIcon(defaultUserIcon);
            }
        } catch (IOException ex) {
            myAvatar.setIcon(defaultUserIcon);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSendText = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtMessage = new javax.swing.JTextField();
        btnCall = new javax.swing.JButton();
        btnSendFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelChat = new javax.swing.JPanel();
        yourAvatar = new javax.swing.JLabel();
        myAvatar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnSendText.setBackground(new java.awt.Color(210, 82, 127));
        btnSendText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSendText.setForeground(new java.awt.Color(255, 255, 255));
        btnSendText.setText("Gửi");
        btnSendText.setBorder(null);
        btnSendText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendTextActionPerformed(evt);
            }
        });

        txtMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMessage.setBorder(null);
        txtMessage.setOpaque(false);
        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/halo/resources/microphone.png"))); // NOI18N
        btnCall.setToolTipText("Call");
        btnCall.setBorder(null);
        btnCall.setBorderPainted(false);
        btnCall.setContentAreaFilled(false);
        btnCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallActionPerformed(evt);
            }
        });

        btnSendFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/halo/resources/attach-file.png"))); // NOI18N
        btnSendFile.setToolTipText("Gửi file");
        btnSendFile.setBorder(null);
        btnSendFile.setBorderPainted(false);
        btnSendFile.setContentAreaFilled(false);
        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFileActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelChat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanelChatComponentResized(evt);
            }
        });
        jPanelChat.setLayout(null);
        jScrollPane1.setViewportView(jPanelChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSendFile))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendText, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yourAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCall, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSendFile, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSendText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yourAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(myAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Listener.removeUserChatting(this);
        Listener.removeUserChattingName(this.getUser().getUserName());
    }//GEN-LAST:event_formWindowClosed

    private void btnSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFileActionPerformed
        JFileChooser jfc = new JFileChooser();
        int dialog_value = jfc.showOpenDialog(null);
        if (dialog_value == JFileChooser.APPROVE_OPTION) {
            DisplayMyMessage("Gửi file: " + jfc.getSelectedFile().getName());
            try {
                new FileSender(user.getAddrListening(), user.getPortListening(), jfc.getSelectedFile()).run();
            } catch (IOException ex) {
                Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSendFileActionPerformed

    private void btnCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallActionPerformed
        try {
            Halo.isCalling = true;
            RequestCallForm requestCallingForm = new RequestCallForm(user);
            requestCallingForm.setVisible(true);
            new VoiceClient(this.user.getAddrListening(), this.user.getPortListening(), requestCallingForm).start();
        } catch (IOException ex) {
            Halo.isCalling = false;
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCallActionPerformed

    private void btnSendTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendTextActionPerformed
        new TextSender(user.getAddrListening(), user.getPortListening(), txtMessage.getText()).start();
        DisplayMyMessage(txtMessage.getText());
        txtMessage.setText("");
    }//GEN-LAST:event_btnSendTextActionPerformed

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        new TextSender(user.getAddrListening(), user.getPortListening(), txtMessage.getText()).start();
        DisplayMyMessage(txtMessage.getText());
        txtMessage.setText("");
    }//GEN-LAST:event_txtMessageActionPerformed

    private void jPanelChatComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelChatComponentResized
        UpdateRightPostion();
    }//GEN-LAST:event_jPanelChatComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCall;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JButton btnSendText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelChat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myAvatar;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JLabel yourAvatar;
    // End of variables declaration//GEN-END:variables

    public void receiveNewMessage(String message) {
        DisplayYourMessage(message);
    }
    
    private void DisplayYourMessage(String message) {
        //init
        javax.swing.JLabel jLabelMessage = new javax.swing.JLabel(message);
        jLabelMessage.setBackground(new java.awt.Color(52, 152, 219));
        jLabelMessage.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMessage.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabelMessage.setOpaque(true);
        jLabelMessage.setBorder(new EmptyBorder(10, 10, 10, 10));
        jLabelMessage.setSize((int) jLabelMessage.getPreferredSize().getWidth(), (int) jLabelMessage.getPreferredSize().getHeight());
        jLabelMessage.setLocation(MESSAGE_MARGIN, MESSAGE_CURRENT_Y_POSTION + MESSAGE_MARGIN);

        //store
        yourMessage.add(jLabelMessage);

        //display
        //jPanelChat.add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(MESSAGE_MARGIN, MESSAGE_CURRENT_Y_POSTION + MESSAGE_MARGIN, -1, -1));
        jPanelChat.add(jLabelMessage);
        jPanelChat.revalidate();
        jPanelChat.repaint();
        MESSAGE_CURRENT_Y_POSTION += jLabelMessage.getPreferredSize().getHeight() + MESSAGE_MARGIN;
    }
    
    private void DisplayMyMessage(String message) {
        //init
        javax.swing.JLabel jLabelMessage = new javax.swing.JLabel(message);
        jLabelMessage.setBackground(new java.awt.Color(210, 82, 127));
        jLabelMessage.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMessage.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabelMessage.setOpaque(true);
        jLabelMessage.setBorder(new EmptyBorder(10, 10, 10, 10));
        jLabelMessage.setSize((int) jLabelMessage.getPreferredSize().getWidth(), (int) jLabelMessage.getPreferredSize().getHeight());
        jLabelMessage.setLocation(jPanelChat.getWidth() - (int) jLabelMessage.getPreferredSize().getWidth() - MESSAGE_MARGIN, MESSAGE_CURRENT_Y_POSTION + MESSAGE_MARGIN);

        //store
        myMessage.add(jLabelMessage);

        //display
        //jPanelChat.add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(jPanelChat.getWidth() - (int) jLabelMessage.getPreferredSize().getWidth() - MESSAGE_MARGIN, MESSAGE_CURRENT_Y_POSTION + MESSAGE_MARGIN, -1, -1));
        jPanelChat.add(jLabelMessage);
        jPanelChat.revalidate();
        jPanelChat.repaint();
        MESSAGE_CURRENT_Y_POSTION += jLabelMessage.getPreferredSize().getHeight() + MESSAGE_MARGIN;
    }
    
    private void UpdateRightPostion() {
        for (JLabel jLabel : myMessage) {
            jLabel.setLocation(jPanelChat.getWidth() - (int) jLabel.getPreferredSize().getWidth() - MESSAGE_MARGIN, jLabel.getLocation().y);
        }
    }
}
