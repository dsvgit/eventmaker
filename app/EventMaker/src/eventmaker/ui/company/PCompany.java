package eventmaker.ui.company;

import eventmaker.logic.models.VCompany;

public class PCompany extends javax.swing.JPanel {

    private VCompany model;
    
    public PCompany() {
        initComponents();
    }
    
    public void setModel(VCompany company) {
        model = company;
        start();
    }
    
    private void start() {
        lNameValue.setText(model.name);
        lDescValue.setText(model.description);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNameText = new javax.swing.JLabel();
        lNameValue = new javax.swing.JLabel();
        lDescText = new javax.swing.JLabel();
        lDescValue = new javax.swing.JLabel();

        lNameText.setText("Company name: ");

        lNameValue.setText("<cmp nam>");

        lDescText.setText("Description: ");

        lDescValue.setText("<desc>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNameText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lNameValue))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lDescText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lDescValue)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameText)
                    .addComponent(lNameValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDescText)
                    .addComponent(lDescValue))
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lDescText;
    private javax.swing.JLabel lDescValue;
    private javax.swing.JLabel lNameText;
    private javax.swing.JLabel lNameValue;
    // End of variables declaration//GEN-END:variables
}
