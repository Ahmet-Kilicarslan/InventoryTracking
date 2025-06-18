package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.IOException;
import java.util.List;

public class UserDao {

    /*
    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("StockPU"); 
    
    public static final EntityManager  getEntityManager() {
        return emf.createEntityManager();
    }
    public static void close(){
    emf.close();
    }
    
     */

    public void addUser(User user) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(user);
            tr.commit();
        } catch (Exception ex) {
            if (tr.isActive()) {
                tr.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();

        }

    }

    public void updateUser(int id, String Username, String Password) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            User u = em.find(User.class, id);
            tr.begin();
            u.setUsername(Username);
            u.setPassword(Password);
            em.merge(u);
            tr.commit();
        } catch (Exception ex) {
            if (tr.isActive()) {
                tr.rollback();
            }
            ex.printStackTrace();

        } finally {
            em.close();
        }

    }
    
    public ArrayList<User> getUserEntity(){
    EntityManager em=JPAUtil.getEntityManager();
    EntityTransaction tr=em.getTransaction();
        tr.begin();
        List<User> userlist=em.createQuery("select u from User u",User.class).getResultList();
        tr.commit();
        return  new ArrayList<>(userlist);
    
    }

    public boolean removeUser(int User_id) {

        String sql = "delete from Users where User_id=?";

        try (Connection conn = DBC.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, User_id);

            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean EditUser(User u) {
        String sql = "update Users set Username=?,Password=?" + "Where User_id=?";

        try (Connection conn = DBC.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getUser_id());
            pst.execute();

            return true;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<User> getUsers() {
        String sql = "select * from users";
        ArrayList<User> Users = new ArrayList<>();

        try (Connection conn = DBC.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Users.add(new User(
                        rs.getInt("User_id"),
                        rs.getString("Username"),
                        rs.getString("Password")
                ));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return Users;

    }

    public User GetUserById(int id) {
        String sql = "Select *from Users where User_id=?";

        try (Connection conn = DBC.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getInt("User_id"),
                        rs.getString("Username"),
                        rs.getString("Password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

}
