package eventmaker.ui;

import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.managers.AuthorizationManager;
import eventmaker.repository.exceptions.RepositoryException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class FLogin extends javax.swing.JFrame {
    
    private final AuthorizationManager _authManager = new AuthorizationManager();

    public FLogin(String title) {
        super(title);
        init();
        initComponents();
        start();
    }
    
    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void start() {
        lErrorMessage.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfLogin = new javax.swing.JTextField();
        pfPass = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();
        lErrorMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEnter.setText("Log in");
        btnEnter.setToolTipText("");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        lErrorMessage.setText("<error_message>");

        jLabel2.setText("Password");

        jLabel3.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lErrorMessage)
                    .addComponent(jLabel2)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {
            _authManager.Login(tfLogin.getText(), Arrays.toString(pfPass.getPassword()));
        } catch (RepositoryException ex) {
            Logger.getLogger(FLogin.class.getName()).log(Level.SEVERE, null, ex);
            lErrorMessage.setText("can't connect to db");
        } catch (UserAuthorizationException ex) {
            lErrorMessage.setText("user not found");
            return;
        }
        dispose();
        JFrame fOverview = new FOverview();
        fOverview.setLocationRelativeTo(null);
        fOverview.setVisible(true);
    }//GEN-LAST:event_btnEnterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lErrorMessage;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables

    

}
