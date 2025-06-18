
package stock;

import java.time.LocalDateTime;

public class Transaction {

    int Transaction_id;
    String Productname;
    String Username;
    int Amount;
    String Transaction_type;//ENUM('Added', 'Restock', 'Sold', 'Rebranding', 'Price change', 'Removed all')

    LocalDateTime date;

    public Transaction(String Productname, String Username, int Amount, String Transaction_type, LocalDateTime date) {

        this.Productname = Productname;
        this.Username = Username;
        this.Amount = Amount;
        this.Transaction_type = Transaction_type;
        this.date = date;

    }

    public Transaction(int Transaction_id, String Productname, String Username, int Amount, String Transaction_type, LocalDateTime date) {
        this.Transaction_id = Transaction_id;
        this.Productname = Productname;
        this.Username = Username;
        this.Amount = Amount;
        this.Transaction_type = Transaction_type;
        this.date = date;
    }

    public int getTransaction_id() {
        return Transaction_id;
    }

    public void setTransaction_id(int Transaction_id) {
        this.Transaction_id = Transaction_id;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getTransaction_type() {
        return Transaction_type;
    }

    public void setTransaction_type(String Transaction_type) {
        this.Transaction_type = Transaction_type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
