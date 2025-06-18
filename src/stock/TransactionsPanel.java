package stock;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransactionsPanel extends javax.swing.JPanel {

    private TransactionsDao TransactionsDao;
    DefaultTableModel model = new DefaultTableModel();

    public TransactionsPanel() {
        initComponents();
        TransactionTable.setModel(model);
        model.setColumnIdentifiers(new String[]{"Id", "Product", "User", "Amount", "Action", "date"});
        TransactionsDao = new TransactionsDao();
        for (Transaction t : TransactionsDao.getAllTransactions()) {
            model.addRow(new Object[]{t.getTransaction_id(), t.getProductname(),
                t.getUsername(), t.getAmount(), t.getTransaction_type(), t.getDate()});

        }
    }

    public JTable getTransactionTable() {
        return TransactionTable;
    }
    
    
    public void refreshTable(){
    model.setRowCount(0);
     for (Transaction t : TransactionsDao.getAllTransactions()) {
            model.addRow(new Object[]{t.getTransaction_id(), t.getProductname(),
                t.getUsername(), t.getAmount(), t.getTransaction_type(), t.getDate()});

        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TransactionTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Transaction History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TransactionTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
