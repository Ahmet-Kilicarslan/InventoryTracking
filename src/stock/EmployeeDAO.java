package stock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EmployeeDAO {
    
  

    //employeee cruds
    public void AddEmployee(Employee employee) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(employee);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();

        }

    }

    public Employee getEmployeeById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }

    }

    public void updateEmployee(Employee employee) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.merge(employee);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    public void fireEmployee(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Employee emp = em.find(Employee.class, id);
            if (emp != null) {
                em.remove(emp);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    public ArrayList<Employee> getAllEmployees() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        List<Employee> list = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        tr.commit();
        return new ArrayList<>(list); // Converts List to ArrayList

    }

    public void saveEmployeeInfo(JTable table, File file) throws IOException {
           
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
            for (int col = 0; col < table.getColumnCount(); col++) {
                buff.write(table.getColumnName(col) + ": "
                        + table.getValueAt(table.getSelectedRow(), col).toString());
                buff.newLine();

            }
        }catch(IOException ex){
        JOptionPane.showMessageDialog(null, 
                "Error exporting: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);  
        
        
        }
        

    }
}
