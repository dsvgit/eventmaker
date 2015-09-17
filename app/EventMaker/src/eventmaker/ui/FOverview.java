package eventmaker.ui;

import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.logic.managers.CompanyManager;
import eventmaker.logic.models.VCompany;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FOverview extends javax.swing.JFrame {
    
    private final CompanyManager _cmpManager = new CompanyManager();

    public FOverview() {
        initComponents();
        
        try {
            List<VCompany> companies = _cmpManager.getList();
            
            List<String> companiesStrings = companies
                    .stream()
                    .map(x -> x.name)
                    .collect(Collectors.toList());
            
            listCompanies.setModel(new javax.swing.AbstractListModel() {
                String[] strings;
                {
                    this.strings = companiesStrings.toArray(new String[companiesStrings.size()]);
                }
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
        } catch (RepositoryException | NotFoundException | DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spMainRegion = new javax.swing.JSplitPane();
        jpSidebar = new javax.swing.JScrollPane();
        listSidebar = new javax.swing.JList();
        jpCompanies = new javax.swing.JScrollPane();
        listCompanies = new javax.swing.JList();
        mbMain = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listSidebar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Companies", "Events" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSidebar.setMaximumSize(new java.awt.Dimension(300, 48));
        listSidebar.setMinimumSize(new java.awt.Dimension(100, 48));
        jpSidebar.setViewportView(listSidebar);

        spMainRegion.setLeftComponent(jpSidebar);

        jpCompanies.setViewportView(listCompanies);

        spMainRegion.setRightComponent(jpCompanies);

        mFile.setText("File");

        miExit.setText("Exit");
        miExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miExitMouseClicked(evt);
            }
        });
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mFile.add(miExit);

        mbMain.add(mFile);

        mExit.setText("Exit");
        mExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mExitMouseClicked(evt);
            }
        });
        mbMain.add(mExit);

        setJMenuBar(mbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMainRegion, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMainRegion, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mExitMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_mExitMouseClicked

    private void miExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miExitMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_miExitMouseClicked

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jpCompanies;
    private javax.swing.JScrollPane jpSidebar;
    private javax.swing.JList listCompanies;
    private javax.swing.JList listSidebar;
    private javax.swing.JMenu mExit;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuBar mbMain;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JSplitPane spMainRegion;
    // End of variables declaration//GEN-END:variables
}
