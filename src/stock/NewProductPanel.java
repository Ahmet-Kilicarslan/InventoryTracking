package stock;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import javax.swing.JTable;

public class NewProductPanel extends javax.swing.JPanel {

    private final ProductDao ProductDao;
    private final TransactionsDao TransactionsDao;
    private final TransactionsPanel transactionsPanel;
    DefaultTableModel model = new DefaultTableModel();
    int LowStockLimit = 10;

    public NewProductPanel() {
        initComponents();
        ProductDao = new ProductDao();
        TransactionsDao = new TransactionsDao();
        this.transactionsPanel = new TransactionsPanel();
        ProductTable.setModel(model);
        //Adding all products from database
        model.setColumnIdentifiers(new Object[]{"Product_id", "Productname", "Amount", "Price "});
        for (Product p : ProductDao.getProducts()) {
            model.addRow(new Object[]{p.getProduct_id(), p.getProductname(), p.getAmount(), p.getPrice()});

        }
        ActionBox.addItem("");
        ActionBox.addItem("Sold");
        ActionBox.addItem("Restock");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnamefield = new javax.swing.JTextField();
        Amountfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Pricefield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        NewProductButt = new javax.swing.JButton();
        removeButt = new javax.swing.JButton();
        Searchfield = new javax.swing.JTextField();
        SearchButt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        UpdateButt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ActionBox = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(550, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Product name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Amount");

        Pricefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PricefieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Price per Unit");

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ProductTable);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("In House");

        NewProductButt.setText("Create");
        NewProductButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProductButtActionPerformed(evt);
            }
        });

        removeButt.setText("Remove");
        removeButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtActionPerformed(evt);
            }
        });

        SearchButt.setText("Search");
        SearchButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtActionPerformed(evt);
            }
        });

        jLabel5.setText("Search by Id");

        UpdateButt.setText("Update");
        UpdateButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Action");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(Searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(SearchButt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnamefield)
                            .addComponent(Pricefield)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Amountfield)
                            .addComponent(ActionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewProductButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButt)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NewProductButt, removeButt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButt)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pricefield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Amountfield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ActionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NewProductButt)
                            .addComponent(UpdateButt)
                            .addComponent(removeButt)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NewProductButt, removeButt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ActionBox, Amountfield, Pricefield, pnamefield});

    }// </editor-fold>//GEN-END:initComponents

    //Clearing all textfields after usage
    public void Clearfields() {
        pnamefield.setText("");
        Amountfield.setText("");
        Pricefield.setText("");
        Searchfield.setText("");
        ActionBox.setSelectedIndex(0);
    }

    public JTable getProductTable() {
        return ProductTable;
    }
    

    public void LowStockWarning() {
        for (Product p : ProductDao.getProducts()) {
            if (p.getAmount() < LowStockLimit) {
                JOptionPane.showMessageDialog(null, "Last " + p.getAmount() + p.getProductname()
                        + " remaining.Restock needed!", "Low Stock Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }

    //method for refreshing jtable
    public void refreshtable() {
        model.setRowCount(0);
        for (Product p : ProductDao.getProducts()) {
            model.addRow(new Object[]{p.getProduct_id(), p.getProductname(), p.getAmount(), p.getPrice()});
        }
        LowStockWarning();

    }

    private void PricefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PricefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PricefieldActionPerformed

    //method for creating new product
    private void NewProductButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProductButtActionPerformed
        try {
            int amount = Integer.parseInt(Amountfield.getText());
            double price = Double.parseDouble(Pricefield.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid values!");
        }

        String name = pnamefield.getText();
        int amount = Integer.parseInt(Amountfield.getText());
        double price = Double.parseDouble(Pricefield.getText());

        if (name.isEmpty() || Amountfield.getText().isEmpty() || Pricefield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all data");
            return;
        }
        try{
        Product p = new Product(name, amount, price);

        ProductDao.AddProduct(p);

        Clearfields();

        Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), p.getAmount(), "Added", LocalDateTime.now());
        TransactionsDao.AddTransaction(t);
        transactionsPanel.refreshTable();
        refreshtable();}catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        
        
        }


    }//GEN-LAST:event_NewProductButtActionPerformed

    private void removeButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtActionPerformed
        // TODO add your handling code here:
        int id;
        if (!Searchfield.getText().isEmpty()) {

            id = Integer.parseInt(Searchfield.getText());
        } else {
            id = (Integer) model.getValueAt(ProductTable.getSelectedRow(), 0);
        }
        Product p = ProductDao.GetProductById(id);

        int result = JOptionPane.showConfirmDialog(null, "Are you sure to  remove all stock of " + p.getProductname(),
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            ProductDao.removeProduct(id);
            Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), p.getAmount(), "Removed all", LocalDateTime.now());
            TransactionsDao.AddTransaction(t);
            transactionsPanel.refreshTable();

            refreshtable();
        }
    }//GEN-LAST:event_removeButtActionPerformed

    private void SearchButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(Searchfield.getText());
        if (id != 0) {
            Product p = ProductDao.GetProductById(id);
            model.setRowCount(0);
            model.addRow(new Object[]{p.getProduct_id(), p.getProductname(), p.getAmount(), p.getPrice()});

        } else {
            JOptionPane.showMessageDialog(this, "You must enter id");
        }

    }//GEN-LAST:event_SearchButtActionPerformed

    private void UpdateButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtActionPerformed

        int id;
        if (!Searchfield.getText().isEmpty()) {

            id = Integer.parseInt(Searchfield.getText());
        } else {
            id = (Integer) model.getValueAt(ProductTable.getSelectedRow(), 0);
        }

        Product p = ProductDao.GetProductById(id);

        String name;
        int amount;
        double price;
        String inputAmount = Amountfield.getText();
        //Changing product's name
        if (pnamefield.getText().isEmpty()) {
            name = p.getProductname();

        } else {
            name = pnamefield.getText();
            Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), p.getAmount(), "Rebranding", LocalDateTime.now());
            TransactionsDao.AddTransaction(t);
        }
        //changing amount
        if (!inputAmount.isEmpty()) {
            int input = Integer.parseInt(inputAmount);

            if (ActionBox.getSelectedItem() == "Sold") {
                amount = p.getAmount() - input;
                Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), input, "Sold", LocalDateTime.now());
                TransactionsDao.AddTransaction(t);
                transactionsPanel.refreshTable();

            } else if (ActionBox.getSelectedItem() == "Restock") {
                amount = p.getAmount() + input;
                Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), input, "Restock", LocalDateTime.now());
                TransactionsDao.AddTransaction(t);
                transactionsPanel.refreshTable();
            } else {
                amount = input;
                Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), amount, "Stock Change", LocalDateTime.now());
                TransactionsDao.AddTransaction(t);
                transactionsPanel.refreshTable();
            }

        } else {
            amount = p.getAmount();

        }

        //chnaging price
        if (Pricefield.getText().isEmpty()) {
            price = p.getPrice();
        } else {
            price = Double.parseDouble(Pricefield.getText());
            Transaction t = new Transaction(p.getProductname(), UserSession.getUsername(), p.getAmount(), "Price change", LocalDateTime.now());
            TransactionsDao.AddTransaction(t);
        }

        Product Updated = new Product(id, name, amount, price);
        ProductDao.UpdateProduct(Updated);

        transactionsPanel.refreshTable();
        refreshtable();
        Clearfields();


    }//GEN-LAST:event_UpdateButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ActionBox;
    private javax.swing.JTextField Amountfield;
    private javax.swing.JButton NewProductButt;
    private javax.swing.JTextField Pricefield;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton SearchButt;
    private javax.swing.JTextField Searchfield;
    private javax.swing.JButton UpdateButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pnamefield;
    private javax.swing.JButton removeButt;
    // End of variables declaration//GEN-END:variables
}
