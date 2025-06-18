/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock;
import jakarta.persistence.*;
/**
 *
 * @author Ahmet
 */
public class testbean {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("Connected successfully!");
        em.close();
        emf.close();
    }
    
}
