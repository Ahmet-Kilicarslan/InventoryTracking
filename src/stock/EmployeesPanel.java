package stock;

import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EmployeesPanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private EmployeeDAO employeeDao;

    public EmployeesPanel() {
        initComponents();
        model.setColumnIdentifiers(new String[]{"Id", "Name", "Phone", "Salary", "Position"});
        EmployeeTable.setModel(model);
        employeeDao = new EmployeeDAO();
        positionBox.addItem("Depot Manager");
        positionBox.addItem("Warehouseman");
        positionBox.addItem("Certified Forklifter");
        refreshEmployeeTable();

    }

    private void refreshEmployeeTable() {
        model.setRowCount(0);
        for (Employee emp : employeeDao.getAllEmployees()) {
            model.addRow(new Object[]{emp.getId(), emp.getName(), emp.getPhone(), emp.getSalary(), emp.getPosition()});

        }

    }
    
    public JTable getEmployeesTable(){
    return EmployeeTable;
    
    }

    private void ClearFields() {
        namefield.setText("");
        phonefield.setText("");
        salaryfield.setText("");
        positionBox.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        salaryfield = new javax.swing.JTextField();
        phonefield = new javax.swing.JTextField();
        HireButt = new javax.swing.JButton();
        FireBUtt = new javax.swing.JButton();
        EditButt = new javax.swing.JButton();
        positionBox = new javax.swing.JComboBox<>();
        SaveButt = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 500));

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(EmployeeTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Phone");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Salary");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Position");

        HireButt.setText("Hire");
        HireButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireButtActionPerformed(evt);
            }
        });

        FireBUtt.setText("Fire");
        FireBUtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireBUttActionPerformed(evt);
            }
        });

        EditButt.setText("Edit  Employee");
        EditButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtActionPerformed(evt);
            }
        });

        positionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        SaveButt.setText("Save Employee info");
        SaveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SaveButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(HireButt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namefield)
                            .addComponent(salaryfield, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(phonefield)
                            .addComponent(positionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FireBUtt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {namefield, phonefield, positionBox, salaryfield});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FireBUtt, HireButt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(phonefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(salaryfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(positionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HireButt)
                            .addComponent(FireBUtt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(EditButt)
                        .addGap(18, 18, 18)
                        .addComponent(SaveButt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {FireBUtt, HireButt});

    }// </editor-fold>//GEN-END:initComponents

    private void HireButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireButtActionPerformed

        String name = namefield.getText();
        String phone = phonefield.getText();
        Double salary = Double.valueOf(salaryfield.getText());
        if(salary<=0){
         JOptionPane.showMessageDialog(this, "Invalid input.");
         return;
        }
        String position = positionBox.getSelectedItem().toString();

        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter all necessery information");
            return;
        }
        try {

            Employee emp = new Employee(name, phone, salary, position);
            employeeDao.AddEmployee(emp);
            refreshEmployeeTable();
            ClearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
            e.printStackTrace();
        }

    }//GEN-LAST:event_HireButtActionPerformed

    private void FireBUttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireBUttActionPerformed

        int GonerEmplooyeid = Integer.parseInt(model.getValueAt(EmployeeTable.getSelectedRow(), 0).toString());
        String name = employeeDao.getEmployeeById(GonerEmplooyeid).getName();
        try {
            int jop = JOptionPane.showConfirmDialog(null, "Are you sure you want to fire " + name,
                    "Think about hungry kids.", JOptionPane.YES_NO_OPTION);
            if (jop == JOptionPane.YES_OPTION) {
                employeeDao.fireEmployee(GonerEmplooyeid);
                JOptionPane.showMessageDialog(this, "Succsesfully starved working classes' kids");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Couldn't fire him.Union is on our neck");
        }
        refreshEmployeeTable();


    }//GEN-LAST:event_FireBUttActionPerformed

    private void EditButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtActionPerformed
        int selecterLosersid = Integer.parseInt(model.getValueAt(EmployeeTable.getSelectedRow(), 0).toString());
        String name = namefield.getText();
        String phone = phonefield.getText();
        String salaryText = salaryfield.getText().trim();
        Double salary = null;
        if (!salaryText.isEmpty()) {
            salary = Double.valueOf(salaryText);
        }
        String position = positionBox.getSelectedItem().toString();
        Employee Veteran = employeeDao.getEmployeeById(selecterLosersid);

        try {
            // Only update if not empty
            if (!name.isEmpty()) {
                Veteran.setName(name);
            }

            if (!phone.isEmpty()) {
                Veteran.setPhone(phone);
            }

            if (salary != null && salary != Veteran.getSalary()) {
                Veteran.setSalary(salary);
            }

            if (!position.equals(positionBox.getItemAt(0)) && !position.equals(Veteran.getPosition())) {
                Veteran.setPosition(position);
            }
            ClearFields();
            employeeDao.updateEmployee(Veteran);
            refreshEmployeeTable();
            ClearFields();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "no one getting raise!! From Bossman sincereley");
        }

    }//GEN-LAST:event_EditButtActionPerformed

    private void SaveButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtActionPerformed
        // TODO add your handling code here:
        
        try{
        int EmpId=(int)EmployeeTable.getValueAt(EmployeeTable.getSelectedRow(),0);
        Employee selectedEmp=employeeDao.getEmployeeById(EmpId);
        
        JFileChooser filechooser=new JFileChooser();
        filechooser.setDialogTitle("Save Employee info");
        filechooser.setSelectedFile(new File(selectedEmp.getName()+".txt"));
        
        int option=filechooser.showSaveDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            try {
                employeeDao.saveEmployeeInfo(EmployeeTable, filechooser.getSelectedFile());
                JOptionPane.showMessageDialog(null, "Succsesfully saved "+filechooser.getSelectedFile().getName()+
                        " to "+filechooser.getSelectedFile().getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                "Error exporting: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        
        }}catch(Exception ex){
        
         JOptionPane.showMessageDialog(this, 
                "Error exporting: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_SaveButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButt;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JButton FireBUtt;
    private javax.swing.JButton HireButt;
    private javax.swing.JButton SaveButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namefield;
    private javax.swing.JTextField phonefield;
    private javax.swing.JComboBox<String> positionBox;
    private javax.swing.JTextField salaryfield;
    // End of variables declaration//GEN-END:variables
}
