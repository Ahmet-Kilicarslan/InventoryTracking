package stock;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class TransactionsDao {
    
    public ArrayList<Transaction> getAllTransactions() {
        String sql = "select *from transactions";
        ArrayList<Transaction> records = new ArrayList<>();

        try (Connection conn = DBC.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                records.add(new Transaction(
                        rs.getInt("Transaction_id"),
                        rs.getString("Productname"), 
                        rs.getString("Username"),
                        rs.getInt("Amount"),
                        rs.getString("Transaction_type"),                      
                        rs.getTimestamp("date").toLocalDateTime()
                ));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return records;

    }

    public boolean AddTransaction(Transaction t) {
        String sql = "insert into transactions(Productname,Username,Amount,Transaction_type,date)"
                + "values(?,?,?,?,?)";
        try (Connection conn = DBC.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
           
            pst.setString(1, t.getProductname());
            pst.setString(2, t.getUsername());
            pst.setInt(3, t.getAmount());
            pst.setString(4, t.getTransaction_type());
            pst.setTimestamp(5,Timestamp.valueOf(t.getDate()) );

            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
