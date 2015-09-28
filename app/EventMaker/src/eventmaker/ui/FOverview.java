package eventmaker.ui;

import eventmaker.service.RegistrationService;
import eventmaker.data.Event;
import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.service.CompanyService;
import eventmaker.service.EventService;
import eventmaker.service.UserService;
import eventmaker.logic.models.VCompany;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.ui.company.FCompanyCreate;
import eventmaker.ui.event.EventTableModel;
import eventmaker.ui.event.FEventCreate;
import eventmaker.ui.registrations.RegistrationTableModel;
import eventmaker.ui.registrations.UserTableModel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

public class FOverview extends javax.swing.JFrame {
    
    private final CompanyService _cmpManager = new CompanyService();
    private final EventService _evManager = new EventService();
    private final UserService _userManager = new UserService();
    private final RegistrationService _regManager = new RegistrationService();
    
    private UserTableModel _userTableModel;
    private EventTableModel _openedEventsTableModel;
    private RegistrationTableModel _regsInOwnedEventsTableModel;
    private RegistrationTableModel _regsWhereIGoTableModel;

    public FOverview() {
        init();
        initComponents();
        start();
    }
    
    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void start() {
        spCompanies.setRightComponent(companyView);
        
        RerenderCompanies();
        RerenderEvents();
        RerenderUsers();
        RerenderRegistrations();
        RerenderWhereIGo();
        
        listCompanies.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            VCompany c = (VCompany) listCompanies.getSelectedValue();
            if (c == null) return;
            companyView.setModel(c);
        });
        
        CompanyCbListener cbListener = new CompanyCbListener();
        cbCompanies.addItemListener(cbListener);
        
        EventsCbListener evListener = new EventsCbListener();
        cbEvents.addItemListener(evListener);
    }
    
    class CompanyCbListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evt) {
            JComboBox cb = (JComboBox) evt.getSource();

            Object item = evt.getItem();

            if (evt.getStateChange() == ItemEvent.SELECTED) {
                RerenderEvents();
            } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                // Item is no longer selected
            }
        }
    }
    
    class EventsCbListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evt) {
            JComboBox cb = (JComboBox) evt.getSource();

            Object item = evt.getItem();

            if (evt.getStateChange() == ItemEvent.SELECTED) {
                RerenderRegistrations();
            } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                // Item is no longer selected
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMainArea = new javax.swing.JTabbedPane();
        panelCompanies = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCreateCompany = new javax.swing.JButton();
        btnDeleteCompany = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        spCompanies = new javax.swing.JSplitPane();
        spCompaniesSidebar = new javax.swing.JScrollPane();
        listCompanies = new javax.swing.JList();
        panelRigth = new javax.swing.JPanel();
        panelOverview = new javax.swing.JPanel();
        companyView = new eventmaker.ui.company.PCompany();
        panelCategories = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCompanies = new javax.swing.JComboBox();
        btnCreateEvent = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEvents = new javax.swing.JTable();
        panelUsers = new javax.swing.JPanel();
        spUsers = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbEvents = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegs = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        btnApprovePayment = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnRegisterUser = new javax.swing.JButton();
        cbCompaniesInRegs = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableWhereIGo = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnUserApprove = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnClaim = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableOpenedEvents = new javax.swing.JTable();
        mbMain = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCreateCompany.setText("Create");
        btnCreateCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCompanyActionPerformed(evt);
            }
        });

        btnDeleteCompany.setText("Delete");
        btnDeleteCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreateCompany)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteCompany)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateCompany)
                    .addComponent(btnDeleteCompany))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spCompaniesSidebar.setViewportView(listCompanies);

        spCompanies.setLeftComponent(spCompaniesSidebar);

        javax.swing.GroupLayout panelOverviewLayout = new javax.swing.GroupLayout(panelOverview);
        panelOverview.setLayout(panelOverviewLayout);
        panelOverviewLayout.setHorizontalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(companyView, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );
        panelOverviewLayout.setVerticalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(companyView, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRigthLayout = new javax.swing.GroupLayout(panelRigth);
        panelRigth.setLayout(panelRigthLayout);
        panelRigthLayout.setHorizontalGroup(
            panelRigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRigthLayout.setVerticalGroup(
            panelRigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        spCompanies.setRightComponent(panelRigth);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(spCompanies)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(spCompanies, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout panelCompaniesLayout = new javax.swing.GroupLayout(panelCompanies);
        panelCompanies.setLayout(panelCompaniesLayout);
        panelCompaniesLayout.setHorizontalGroup(
            panelCompaniesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCompaniesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCompaniesLayout.setVerticalGroup(
            panelCompaniesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompaniesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMainArea.addTab("My companies", panelCompanies);

        jLabel1.setText("Company: ");

        btnCreateEvent.setText("Create");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateEvent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateEvent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category", "Date", "Description", "Approve rule", "Payment rule", "Availability", "Cost", "Company"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEvents);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCategoriesLayout = new javax.swing.GroupLayout(panelCategories);
        panelCategories.setLayout(panelCategoriesLayout);
        panelCategoriesLayout.setHorizontalGroup(
            panelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCategoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCategoriesLayout.setVerticalGroup(
            panelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMainArea.addTab("My events", panelCategories);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(200, 200));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Full Name", "Info"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableUsers);

        spUsers.setLeftComponent(jScrollPane3);

        jLabel2.setText("Event");

        cbEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEventsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbEvents, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableRegs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableRegs);

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDecline.setText("Decline");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        btnApprovePayment.setText("Approve payment");
        btnApprovePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovePaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDecline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApprovePayment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnDecline)
                    .addComponent(btnApprovePayment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        spUsers.setRightComponent(jPanel8);

        btnRegisterUser.setText("Add user");
        btnRegisterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterUserActionPerformed(evt);
            }
        });

        cbCompaniesInRegs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCompaniesInRegsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegisterUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCompaniesInRegs, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegisterUser)
                    .addComponent(cbCompaniesInRegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUsersLayout = new javax.swing.GroupLayout(panelUsers);
        panelUsers.setLayout(panelUsersLayout);
        panelUsersLayout.setHorizontalGroup(
            panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelUsersLayout.setVerticalGroup(
            panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMainArea.addTab("Registrations", panelUsers);

        tableWhereIGo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableWhereIGo);

        btnUserApprove.setText("Approve");
        btnUserApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserApproveActionPerformed(evt);
            }
        });

        btnPay.setText("Pay it");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUserApprove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserApprove)
                    .addComponent(btnPay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMainArea.addTab("Where i go", jPanel7);

        btnClaim.setText("Claim");
        btnClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClaim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClaim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableOpenedEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableOpenedEvents);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMainArea.addTab("Find events", jPanel12);

        mFile.setText("File");

        miExit.setText("Exit");
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
            .addComponent(tpMainArea)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMainArea, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void mExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mExitMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_mExitMouseClicked

    private void btnCreateCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCompanyActionPerformed
        JFrame fCompanyCreate = new FCompanyCreate(this);
        fCompanyCreate.setLocationRelativeTo(null);
        fCompanyCreate.setVisible(true);
    }//GEN-LAST:event_btnCreateCompanyActionPerformed

    private void btnDeleteCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCompanyActionPerformed
        VCompany cmp = (VCompany)listCompanies.getSelectedValue();
        if (cmp == null) return;
        Integer id = cmp.id;
        try {
            _cmpManager.delete(id);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderCompanies();
    }//GEN-LAST:event_btnDeleteCompanyActionPerformed

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        JFrame fEventCreate = new FEventCreate(this);
        fEventCreate.setLocationRelativeTo(null);
        fEventCreate.setVisible(true);
        RerenderEvents();
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void btnRegisterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterUserActionPerformed
        Event event = (Event) cbEvents.getSelectedItem();
        if (event == null) return;
        User user = _userTableModel.getByIndex(tableUsers.getSelectedRow());
        try {
            _regManager.inviteUser(user.getId(), event.getId());
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
    }//GEN-LAST:event_btnRegisterUserActionPerformed

    private void btnUserApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserApproveActionPerformed
        Registration reg = _regsWhereIGoTableModel.getByIndex(tableWhereIGo.getSelectedRow());
        try {
            _regManager.UserApprove(reg);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
    }//GEN-LAST:event_btnUserApproveActionPerformed

    private void btnClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimActionPerformed
        Event event = _openedEventsTableModel.getByIndex(tableOpenedEvents.getSelectedRow());
        try {
            _regManager.claimCurrentUser(event.getId());
        } catch (RepositoryException | UserAuthorizationException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
    }//GEN-LAST:event_btnClaimActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        Registration reg = _regsInOwnedEventsTableModel.getByIndex(tableRegs.getSelectedRow());
        try {
            _regManager.confirmRegistration(reg);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
        RerenderEvents();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        Registration reg = _regsInOwnedEventsTableModel.getByIndex(tableRegs.getSelectedRow());
        try {
            _regManager.declineRegistration(reg);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
        RerenderEvents();
    }//GEN-LAST:event_btnDeclineActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        Registration reg = _regsWhereIGoTableModel.getByIndex(tableWhereIGo.getSelectedRow());
        try {
            _regManager.userPayEvent(reg);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
        RerenderEvents();
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnApprovePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovePaymentActionPerformed
        Registration reg = _regsInOwnedEventsTableModel.getByIndex(tableRegs.getSelectedRow());
        try {
            _regManager.organizerConfirm(reg);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        RerenderRegistrations();
        RerenderWhereIGo();
        RerenderEvents();
    }//GEN-LAST:event_btnApprovePaymentActionPerformed

    private void cbEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEventsActionPerformed

    private void cbCompaniesInRegsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCompaniesInRegsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCompaniesInRegsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprovePayment;
    private javax.swing.JButton btnClaim;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnCreateCompany;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnDeleteCompany;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnRegisterUser;
    private javax.swing.JButton btnUserApprove;
    private javax.swing.JComboBox cbCompanies;
    private javax.swing.JComboBox cbCompaniesInRegs;
    private javax.swing.JComboBox cbEvents;
    private eventmaker.ui.company.PCompany companyView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listCompanies;
    private javax.swing.JMenu mExit;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuBar mbMain;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JPanel panelCategories;
    private javax.swing.JPanel panelCompanies;
    private javax.swing.JPanel panelOverview;
    private javax.swing.JPanel panelRigth;
    private javax.swing.JPanel panelUsers;
    private javax.swing.JSplitPane spCompanies;
    private javax.swing.JScrollPane spCompaniesSidebar;
    private javax.swing.JSplitPane spUsers;
    private javax.swing.JTable tableEvents;
    private javax.swing.JTable tableOpenedEvents;
    private javax.swing.JTable tableRegs;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTable tableWhereIGo;
    private javax.swing.JTabbedPane tpMainArea;
    // End of variables declaration//GEN-END:variables

    public VCompany getCurrentCompany() {
        return (VCompany) cbCompanies.getSelectedItem();
    }

    class CompaniesListModel extends AbstractListModel<VCompany> {
        
        private List<VCompany> _companies = new ArrayList();

        public CompaniesListModel(List<VCompany> companies) {
            setCompanies(companies);
        }
        
        public void setCompanies(List<VCompany> companies) {
            _companies = companies;
        }

        @Override
        public int getSize() {
            return _companies.size();
        }

        @Override
        public VCompany getElementAt(int index) {
            return _companies.get(index);
        }
    }
    
    public void AfterCompanyCreate() {
        RerenderCompanies();
    }
    
    public void AfterEventCreate() {
        RerenderEvents();
    }
    
    private void RerenderWhereIGo() {
        List<Registration> regs;
        try {
            regs = _regManager.getByCurrentUser();
            _regsWhereIGoTableModel = new RegistrationTableModel((ArrayList<Registration>) regs);
            tableWhereIGo.setModel(_regsWhereIGoTableModel);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void RerenderRegistrations() {
        Event event = (Event) cbEvents.getSelectedItem();
        if (event == null) return;
        List<Registration> regs;
        try {
            regs = _regManager.getListByEvent(event.getId());
            _regsInOwnedEventsTableModel = new RegistrationTableModel((ArrayList<Registration>) regs);
            tableRegs.setModel(_regsInOwnedEventsTableModel);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void RerenderUsers() {
        List<User> users;
        try {
            users = _userManager.getList();
            _userTableModel = new UserTableModel((ArrayList<User>) users);
            tableUsers.setModel(_userTableModel);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void RerenderEvents() {
        VCompany cmp = (VCompany) cbCompanies.getSelectedItem();
        VCompany cmpInRegs = (VCompany) cbCompaniesInRegs.getSelectedItem();
        if (cmp == null) return;
        List<Event> myEvents;
        List<Event> ownedEvents;
        List<Event> openedEvents;
        try {
            openedEvents = _evManager.getListOpened();
            _openedEventsTableModel = new EventTableModel((ArrayList<Event>) openedEvents);
            tableOpenedEvents.setModel(_openedEventsTableModel);
            
            myEvents = _evManager.getListByCompany(cmp.id);
            tableEvents.setModel(new EventTableModel((ArrayList<Event>) myEvents));
            
            ownedEvents = _evManager.getListByCompany(cmpInRegs.id);
            Event[] allEventsArray = ownedEvents.toArray(new Event[ownedEvents.size()]);
            DefaultComboBoxModel<Event> eventComboboxModel = new DefaultComboBoxModel<>(allEventsArray);
            cbEvents.setModel(eventComboboxModel);
        } catch (RepositoryException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void RerenderCompanies() {
        try {
            List<VCompany> companies = _cmpManager.getListCurrent();
            CompaniesListModel companiesListModel = new CompaniesListModel(companies);
            listCompanies.setModel(companiesListModel);
            
            VCompany[] companiesArray = companies.toArray(new VCompany[companies.size()]);
            DefaultComboBoxModel<VCompany> comboboxModel = new DefaultComboBoxModel<>(companiesArray);
            cbCompanies.setModel(comboboxModel);
            cbCompaniesInRegs.setModel(comboboxModel);
        } catch (RepositoryException | UserAuthorizationException ex) {
            Logger.getLogger(FOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
