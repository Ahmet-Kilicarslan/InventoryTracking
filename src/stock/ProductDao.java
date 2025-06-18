
package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// Data access class for product
public class ProductDao {
    
    public ArrayList<Product> getProducts() {
        
        String sql = "select * from products";
        ArrayList<Product> Products = new ArrayList<>();
        try (Connection conn = DBC.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Products.add(new Product(
                        rs.getInt("Product_id"),
                        rs.getString("Productname"),
                        rs.getInt("Amount"),
                        rs.getDouble("Price")
                ));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return Products;
        
    }
    
    public boolean checkForDuplicate(String pname)throws SQLException{
        String sql="select count(*) from products where Productname=?";
        
        try (Connection conn=DBC.getConnection()){
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, pname);
            try{
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            int count=rs.getInt(1);
            return count>0;
            
            }}catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            
            
            }
                

            
        } 
    return false;
    }
    
    public void AddProduct(Product p)throws SQLException{
        String sql = "insert into products(Productname,Amount,Price)" + "values(?,?,?)";
        String name=p.getProductname();
        
        if(checkForDuplicate(name)){
            JOptionPane.showMessageDialog(null,"This product  already exists","Duplicate entry",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try (Connection conn = DBC.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1,name);
            pst.setInt(2, p.getAmount());
            pst.setDouble(3, p.getPrice());
            pst.execute();
         
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
           
        }
        
    }

    public void UpdateProduct(Product p) {
        
        String sql = "update Products set Productname=?, Amount=?, Price=? where Product_id=?";
               
        
        try (Connection conn = DBC.getConnection()) {
            
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, p.getProductname());
            pst.setInt(2, p.getAmount());
            pst.setDouble(3, p.getPrice());
            pst.setInt(4, p.getProduct_id());
            pst.execute();
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            
            
        }
        
    }
    
    public  Product GetProductById(int id) {
        String sql = "Select *from Products where Product_id=?";
        Product p = null;
        try (Connection conn = DBC.getConnection()) {
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             p = new Product(
                        rs.getInt("Product_id"),
                        rs.getString("Productname"),
                        rs.getInt("Amount"),
                        rs.getDouble("Price")
                );
               
            }
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            
        }
        return p;
    }
    
    public void removeProduct(int id){
        String sql="delete from Products where Product_id=?";
        try (Connection conn=DBC.getConnection()){
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            pst.execute();
            
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    
    
    
    
    
    }
    
}
