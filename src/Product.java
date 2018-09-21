
import java.text.NumberFormat;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class Product {
    //changed both name and price to private
    private String name;
    private double price; //changed this from int to double
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    @Override
    public String toString() {
        String priceFormatted = formatter.format(price);
        String out = name + ": " + priceFormatted;
        return out;
    }
}

