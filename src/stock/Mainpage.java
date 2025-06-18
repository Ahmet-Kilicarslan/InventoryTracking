package stock;

import java.awt.CardLayout;
import javax.swing.JOptionPane;

public class Mainpage extends javax.swing.JFrame {

    private TransactionsPanel transactionsPanel;

    public Mainpage() {
        initComponents();
        this.setLocationRelativeTo(null);
        transactionsPanel = new TransactionsPanel();
        MainPanel.add(new TransactionsPanel(), "Transactions");
        MainPanel.add(new DashboardPanel(), "Dashboard");
        MainPanel.add(new NewProductPanel(), "NewProduct");
        MainPanel.add(new UsersPanel(), "Users");
        MainPanel.add(new EmployeesPanel(),"Employees");
      
        showPanel("Dashboard");
    }

    private void showPanel(String name) {
        CardLayout c = (CardLayout) MainPanel.getLayout();
        c.show(MainPanel, name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        HomieButt = new javax.swing.JButton();
        newProductButt = new javax.swing.JButton();
        HistoryButt = new javax.swing.JButton();
        UsersButt = new javax.swing.JButton();
        EmployeeButt = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(100, 300), new java.awt.Dimension(0, 32767));
        LogOutButt = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenuItem8.setText("jMenuItem8");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Managment");
        setMinimumSize(new java.awt.Dimension(700, 500));

        MainPanel.setMinimumSize(new java.awt.Dimension(550, 500));
        MainPanel.setPreferredSize(new java.awt.Dimension(550, 500));
        MainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(MainPanel, java.awt.BorderLayout.LINE_END);

        Sidebar.setBackground(new java.awt.Color(153, 153, 255));
        Sidebar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Sidebar.setForeground(new java.awt.Color(255, 255, 255));
        Sidebar.setToolTipText("");
        Sidebar.setMaximumSize(new java.awt.Dimension(150, 500));
        Sidebar.setMinimumSize(new java.awt.Dimension(150, 500));
        Sidebar.setPreferredSize(new java.awt.Dimension(150, 500));

        HomieButt.setText("Home");
        HomieButt.setPreferredSize(new java.awt.Dimension(110, 20));
        HomieButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomieButtActionPerformed(evt);
            }
        });
        Sidebar.add(HomieButt);

        newProductButt.setText("Update/Create");
        newProductButt.setPreferredSize(new java.awt.Dimension(110, 20));
        newProductButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductButtActionPerformed(evt);
            }
        });
        Sidebar.add(newProductButt);

        HistoryButt.setText("History");
        HistoryButt.setPreferredSize(new java.awt.Dimension(110, 20));
        HistoryButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryButtActionPerformed(evt);
            }
        });
        Sidebar.add(HistoryButt);

        UsersButt.setText("Users");
        UsersButt.setPreferredSize(new java.awt.Dimension(110, 20));
        UsersButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersButtActionPerformed(evt);
            }
        });
        Sidebar.add(UsersButt);

        EmployeeButt.setText("Employees");
        EmployeeButt.setPreferredSize(new java.awt.Dimension(110, 20));
        EmployeeButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeButtActionPerformed(evt);
            }
        });
        Sidebar.add(EmployeeButt);
        Sidebar.add(filler1);

        LogOutButt.setText("LogOut");
        LogOutButt.setPreferredSize(new java.awt.Dimension(110, 20));
        LogOutButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtActionPerformed(evt);
            }
        });
        Sidebar.add(LogOutButt);

        getContentPane().add(Sidebar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HistoryButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryButtActionPerformed
        // TODO add your handling code here:
        showPanel("Transactions");
        transactionsPanel.refreshTable();
        

    }//GEN-LAST:event_HistoryButtActionPerformed

    private void UsersButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersButtActionPerformed
        // TODO add your handling code here:
        showPanel("Users");
    }//GEN-LAST:event_UsersButtActionPerformed

    private void HomieButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomieButtActionPerformed
        // TODO add your handling code here:
        showPanel("Dashboard");
    }//GEN-LAST:event_HomieButtActionPerformed

    private void newProductButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductButtActionPerformed
        // TODO add your handling code here:
        showPanel("NewProduct");
    }//GEN-LAST:event_newProductButtActionPerformed

    private void LogOutButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "LogOut", "Logout", JOptionPane.YES_NO_OPTION);

        if (result == 0) {
            UserSession.setCurrentUser(null);
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        } else
            return;
    }//GEN-LAST:event_LogOutButtActionPerformed

    private void EmployeeButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeButtActionPerformed
        // TODO add your handling code here:
        showPanel("Employees");
    }//GEN-LAST:event_EmployeeButtActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EmployeeButt;
    private javax.swing.JButton HistoryButt;
    private javax.swing.JButton HomieButt;
    private javax.swing.JButton LogOutButt;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton UsersButt;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JButton newProductButt;
    // End of variables declaration//GEN-END:variables
}
