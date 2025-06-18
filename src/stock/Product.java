
package stock;


public class Product {
    int Product_id;
    String Productname;
    int Amount;
    double Price;

    public Product( String Productname, int Amount, double Price) {
      
        this.Productname = Productname;
        this.Amount = Amount;
        this.Price = Price;
    }

    public Product(int Product_id, String Productname, int Amount, double Price) {
        this.Product_id = Product_id;
        this.Productname = Productname;
        this.Amount = Amount;
        this.Price = Price;
    }
    

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int Product_id) {
        this.Product_id = Product_id;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
           
    
    
}
