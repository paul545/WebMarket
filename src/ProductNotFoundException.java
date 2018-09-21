/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */

//Exception to throw when a Product is not found with the Vendor
public class ProductNotFoundException extends Exception{
    
       public ProductNotFoundException() {
           super();
       }
       public ProductNotFoundException(String msg) {
        super(msg);
    }
}


