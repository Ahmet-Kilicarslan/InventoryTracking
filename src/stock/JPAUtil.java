
package stock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    //creating entity manager for using in other classes
    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("StockPU"); 
    
    public static final EntityManager  getEntityManager() {
        return emf.createEntityManager();
    }
    public static void close(){
    emf.close();
    }
}
