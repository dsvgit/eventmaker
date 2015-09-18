package eventmaker.ui.event;

import eventmaker.data.Category;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.logic.managers.CategoryManager;
import eventmaker.logic.managers.EventManager;
import eventmaker.logic.models.VCompany;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.ui.FOverview;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class FEventCreate extends javax.swing.JFrame {

    private final EventManager _evManager = new EventManager();
    private final CategoryManager _catManager = new CategoryManager();
    private final FOverview _ctx;
    private VCompany _currentCompany;
    
    public FEventCreate(FOverview ctx) {
        _ctx= ctx;
        initComponents();
        start();
    }
    
    private void start() {
        try {
            List<Category> categories = _catManager.getList();
            Category[] categoriesArray = categories.toArray(new Category[categories.size()]);
            DefaultComboBoxModel<Category> categoriesModel = new DefaultComboBoxModel<>(categoriesArray);
            cbCategory.setModel(categoriesModel);
        } catch (RepositoryException | DifferentObjectInIdentityMapException | NotFoundException ex) {
            Logger.getLogger(FEventCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultComboBoxModel<ApproveRule> appRulesModel = new DefaultComboBoxModel<>(ApproveRule.values());
        cbApproveRule.setModel(appRulesModel);
        
        DefaultComboBoxModel<PaymentRule> paymentRulesModel = new DefaultComboBoxModel<>(PaymentRule.values());
        cbPaymentRule.setModel(paymentRulesModel);
        
        DefaultComboBoxModel<Availability> availModel = new DefaultComboBoxModel<>(Availability.values());
        cbAvailability.setModel(availModel);
        
        _currentCompany = _ctx.getCurrentCompany();
        lCompanyValue.setText(_currentCompany.toString());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lCategory = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        lDate = new javax.swing.JLabel();
        dpDate = new org.jdesktop.swingx.JXDatePicker();
        lDesc = new javax.swing.JLabel();
        tfDesc = new javax.swing.JTextField();
        lApproveRule = new javax.swing.JLabel();
        cbApproveRule = new javax.swing.JComboBox();
        lPaymentRule = new javax.swing.JLabel();
        cbPaymentRule = new javax.swing.JComboBox();
        lAvailability = new javax.swing.JLabel();
        cbAvailability = new javax.swing.JComboBox();
        lCost = new javax.swing.JLabel();
        lCompanyText = new javax.swing.JLabel();
        lCompanyValue = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        ftfCost = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lName.setText("Name: ");

        lCategory.setText("Category: ");

        lDate.setText("Date: ");

        lDesc.setText("Description: ");

        lApproveRule.setText("Approve rule: ");

        lPaymentRule.setText("Payment rule: ");

        lAvailability.setText("Availability: ");

        lCost.setText("Cost: ");

        lCompanyText.setText("Company: ");

        lCompanyValue.setText("<company>");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        ftfCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lName)
                            .addComponent(lCategory)
                            .addComponent(lDate)
                            .addComponent(lDesc)
                            .addComponent(lApproveRule)
                            .addComponent(lPaymentRule)
                            .addComponent(lAvailability)
                            .addComponent(lCost)
                            .addComponent(lCompanyText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfName)
                            .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dpDate, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(tfDesc)
                            .addComponent(cbApproveRule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPaymentRule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbAvailability, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lCompanyValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftfCost)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCategory)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDate)
                    .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDesc)
                    .addComponent(tfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lApproveRule)
                    .addComponent(cbApproveRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPaymentRule)
                    .addComponent(cbPaymentRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAvailability)
                    .addComponent(cbAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCost)
                    .addComponent(ftfCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCompanyText)
                    .addComponent(lCompanyValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Category category = (Category) cbCategory.getSelectedItem();
        if (category == null) return;
        Integer categoryId = category.getId();
        
        String costString = ftfCost.getText().replace(",","");
        BigDecimal cost = new BigDecimal(costString);
        
        try {
            _evManager.create(tfName.getText(),
                    categoryId,
                    dpDate.getDate(),
                    tfDesc.getText(), 
                    (ApproveRule) cbApproveRule.getSelectedItem(), 
                    (PaymentRule) cbPaymentRule.getSelectedItem(), 
                    (Availability) cbAvailability.getSelectedItem(),
                    cost,
                    _currentCompany.id);
        } catch (RepositoryException | DifferentObjectInIdentityMapException | NotFoundException ex) {
            Logger.getLogger(FEventCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        _ctx.AfterEventCreate();
    }//GEN-LAST:event_btnCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cbApproveRule;
    private javax.swing.JComboBox cbAvailability;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JComboBox cbPaymentRule;
    private org.jdesktop.swingx.JXDatePicker dpDate;
    private javax.swing.JFormattedTextField ftfCost;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lApproveRule;
    private javax.swing.JLabel lAvailability;
    private javax.swing.JLabel lCategory;
    private javax.swing.JLabel lCompanyText;
    private javax.swing.JLabel lCompanyValue;
    private javax.swing.JLabel lCost;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lDesc;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPaymentRule;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
