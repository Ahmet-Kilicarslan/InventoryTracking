
package stock;


public class UserSession {
 
   private static String Username;

    public static void setCurrentUser( String name) {
      
       Username = name;
    }
 
   
    public static void Clear(){
    Username=null;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        UserSession.Username = Username;
    }
  
}
