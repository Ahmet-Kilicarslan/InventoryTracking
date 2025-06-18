package stock;

import java.util.ArrayList;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class DashboardPanel extends javax.swing.JPanel {

    private final ProductDao ProductDao;
    private final TransactionsPanel tp;
    private final NewProductPanel np;
    private final UsersPanel up;
    private final EmployeesPanel ep;
    
    public DashboardPanel() {
        initComponents();
        ProductDao = new ProductDao();
        welcomeLabel.setText("welcome " + UserSession.getUsername());
        String total = String.valueOf(ProductDao.getProducts().size());
        TotalProducts.setText(total);
        lowestlabel.setText(getMin());
        ReportBox.addItem("Products");
        ReportBox.addItem("Users");
        ReportBox.addItem("Transactions");
        ReportBox.addItem("Employees");
         tp = new TransactionsPanel();
        np = new NewProductPanel();
        up = new UsersPanel();
        ep=new EmployeesPanel();

    }

    public String getMin() {
        ArrayList<Product> list = ProductDao.getProducts();

        Product min = list.get(0);

        for (Product p : list) {
            if (p.getAmount() < min.getAmount()) {
                min = p;
            }
        }

        String result = "Last " + min.getAmount() + " of " + min.getProductname() + " remaining!";
        return result;
    }
    
    private void writeAsTxt(JTable t,File f){
         try (BufferedWriter bfwriter = new BufferedWriter(new FileWriter(f))) {
            
            //finding optimal space length for table data
            int[] columnWidht=new int[t.getColumnCount()];
            
            for(int i=0;i<t.getColumnCount();i++){
                columnWidht[i]=t.getColumnName(i).length();
                for(int row=0;row<t.getRowCount();row++){
                    Object value=t.getValueAt(row, i);
                    int len=(value!=null? value.toString().length():"no data".length());
                if(len>columnWidht[i]){
                columnWidht[i]=len;
                }
                
                }
            }
            //write headers
            for (int i = 0; i < t.getColumnCount(); i++) {
                String header=t.getColumnName(i);
                bfwriter.write(String.format("%-"+(columnWidht[i]+2)+"s", header));               
            }
            bfwriter.newLine();

            // Write data
            for (int row = 0; row < t.getRowCount(); row++) {
                for (int col = 0; col < t.getColumnCount(); col++) {
                    Object value = t.getValueAt(row, col);
                    //checking if value is null.If so write "no data" instead 
                    String text=value!=null? value.toString():"no data";
                   bfwriter.write(String.format("%-"+(columnWidht[col]+2)+"s", text));
                  
                  
                } bfwriter.newLine();
            }
           

        } catch (IOException e) {
              JOptionPane.showMessageDialog(this, "Error saving file:\n" + e.getMessage());
        }
    
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalProducts = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lowestlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        saveButt = new javax.swing.JButton();
        ReportBox = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(550, 500));

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome User");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Total Products:");

        TotalProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TotalProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalProducts.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(TotalProducts)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Lowest Stock:");

        lowestlabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lowestlabel.setText("Remaining");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lowestlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lowestlabel)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        saveButt.setText("Save");
        saveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(ReportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(saveButt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButt)
                    .addComponent(ReportBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtActionPerformed
        // TODO add your handling code here:
         String selected = (String) ReportBox.getSelectedItem();
        JTable selectedTable = null;

        if (selected.equals("Transactions")) {
            selectedTable = tp.getTransactionTable();
        } else if (selected.equals("Products")) {
            selectedTable = np.getProductTable();

        } 
        else if(selected.equals("Employees")){
            selectedTable=ep.getEmployeesTable();
        }
        else {
            selectedTable = up.getUsersTable();
        }

        if (selectedTable == null) {
            JOptionPane.showMessageDialog(null, "Please select a valid repport type");
        }

        JFileChooser filechooser = new JFileChooser();
        filechooser.setSelectedFile(new File(selected + "_report.txt"));
        filechooser.setDialogTitle("Save report as ");
        
        int option=filechooser.showSaveDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            writeAsTxt(selectedTable, filechooser.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Succsesfully saved "+filechooser.getSelectedFile().getName());
        }


    }//GEN-LAST:event_saveButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ReportBox;
    private javax.swing.JLabel TotalProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lowestlabel;
    private javax.swing.JButton saveButt;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
