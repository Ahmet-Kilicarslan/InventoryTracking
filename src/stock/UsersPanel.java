/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package stock;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class UsersPanel extends javax.swing.JPanel {

    private UserDao UserDao;
    DefaultTableModel model = new DefaultTableModel();

    public UsersPanel() {
        initComponents();
        UserDao = new UserDao();
        UsersTable.setModel(model);
        model.setColumnIdentifiers(new Object[]{"User id", "Username", "Password"});
        for (User u : UserDao.getUsers()) {
            model.addRow(new Object[]{u.getUser_id(), u.getUsername(), u.getPassword()});

        }
    }

    public void refreshTable() {

        model.setRowCount(0);
        for (User u : UserDao.getUsers()) {
            model.addRow(new Object[]{u.getUser_id(), u.getUsername(), u.getPassword()});

        }

    }

    public JTable getUsersTable() {
        return UsersTable;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        EditUserButt = new javax.swing.JButton();
        RemoveUserButt = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 500));

        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(UsersTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registered Users");

        EditUserButt.setText("Edit User");
        EditUserButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserButtActionPerformed(evt);
            }
        });

        RemoveUserButt.setText("Remove User");
        RemoveUserButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(EditUserButt)
                        .addGap(46, 46, 46)
                        .addComponent(RemoveUserButt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditUserButt)
                    .addComponent(RemoveUserButt))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RemoveUserButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserButtActionPerformed
        // TODO add your handling code here:
        int id = ((Number) model.getValueAt(UsersTable.getSelectedRow(), 0)).intValue();
        int response = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to remove this user?", 
                "Confirmation", 
                JOptionPane.YES_NO_OPTION);
       if(response==JOptionPane.YES_OPTION){
           model.removeRow(UsersTable.getSelectedRow());
        UserDao.removeUser(id);
        refreshTable();
       JOptionPane.showMessageDialog(null,"Succsesfully removed user.","Information", JOptionPane.INFORMATION_MESSAGE);
       
       }else {
        JOptionPane.showMessageDialog(null,"Cancelled removel.","Information", JOptionPane.INFORMATION_MESSAGE);
       
       }
    }//GEN-LAST:event_RemoveUserButtActionPerformed

    private void EditUserButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditUserButtActionPerformed
        // TODO add your handling code here:
        int selectedRow = UsersTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int userid = ((Number) UsersTable.getValueAt(selectedRow, 0)).intValue();
            String Uname = UsersTable.getValueAt(selectedRow, 1).toString();
            String Pass = UsersTable.getValueAt(selectedRow, 2).toString();

            User oldUser = UserDao.GetUserById(userid);
            if (oldUser == null) {
                JOptionPane.showMessageDialog(this, "User not found");
                return;
            }
            User Updateduser = new User(
                    oldUser.getUser_id(),
                    Uname,
                    Pass
            );
            if (UserDao.EditUser(Updateduser)) {

                JOptionPane.showMessageDialog(null, "User Succsesfully Updated.");

            }

            refreshTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        }


    }//GEN-LAST:event_EditUserButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditUserButt;
    private javax.swing.JButton RemoveUserButt;
    private javax.swing.JTable UsersTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
