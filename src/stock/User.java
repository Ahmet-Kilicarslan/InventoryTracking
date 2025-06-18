
package stock;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="users")
@NamedQueries({
@NamedQuery(name="findAll",query="select u from user u"),
@NamedQuery(name="findById",query="select u from user u where u.id= :id")    


})

public class User implements Serializable{
    /*int User_id;
    String Username;
    String Password;*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer User_id;
    
    @Column(name="Username",nullable = false,unique=true,length = 50)
    private String Username;
    
    @Column(name="Password",nullable=false,length=50)
    private String Password;
    
    
    public User(int User_id,String Username,String Password){
    this.User_id=User_id;    
    this.Username=Username;
    this.Password=Password;
    
    
    }

    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }
    

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
