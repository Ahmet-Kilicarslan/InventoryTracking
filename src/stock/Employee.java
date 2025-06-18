
package stock;


import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
})

public class Employee implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String Name;
   
    
    @Column(nullable = false, length = 20)
    private String phone;
    
    @Column(nullable=false,length=10)
    private double salary;
    
    @Column(nullable = false, length = 50)
    private String position;
    
    

    public Employee( String Name, String phone, double salary, String position) {
        
        this.Name = Name;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
    }

    public Employee(Integer id, String Name, String phone, double salary, String position) {
        this.id = id;
        this.Name = Name;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
    }
     public Employee() {
    }
    

    public Integer getId() {
        return id;
    }

    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

   
    
    
    
    
}
