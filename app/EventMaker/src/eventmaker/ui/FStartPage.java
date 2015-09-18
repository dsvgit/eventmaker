package eventmaker.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FStartPage extends JFrame {
    
    public FStartPage() throws HeadlessException {
        initialize();
    }

    public FStartPage(String title) throws HeadlessException {
        super(title);
        initialize();
    }
    
    private void initialize() {
        setSize(320, 240);
        setLocationRelativeTo(null);
        
        panelMain = new JPanel();
        labelLogin = new JLabel();
        labelPassword = new JLabel();
        tfLogin = new JTextField();
        tfPassword = new JTextField();
        
        labelLogin.setText("Login");
        labelLogin.setVerticalTextPosition(JLabel.BOTTOM);
        labelLogin.setHorizontalTextPosition(JLabel.LEFT);
        labelPassword.setText("Password");
        
        labelPassword.setVerticalTextPosition(JLabel.BOTTOM);
        labelPassword.setHorizontalTextPosition(JLabel.LEFT);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogin)
                    .addComponent(labelPassword)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        
        panelMain.add(labelLogin);
        panelMain.add(labelPassword);
        add(panelMain);
    }
    
    private JPanel panelMain;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JTextField tfLogin;
    private JTextField tfPassword;
    
}
