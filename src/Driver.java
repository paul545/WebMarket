
import java.util.Scanner;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class Driver {

    public static void main(String[] args) throws Exception {
        
        /*WebMarket - gave this a name parameter, 
        basically just for customer's toString. We can remove if desired nothing else should be effected*/
        WebMarket market = new WebMarket("Online Express");

        //Vendors - made up some names here
        Vendor v1 = new Vendor("Wal-Mart");
        Vendor v2 = new Vendor("Target");
        Vendor v3 = new Vendor("K-Mart");
        Vendor v4 = new Vendor("CVS Pharmacy");
        Vendor v5 = new Vendor("Whole Foods");
        //Add Vendors to the market
        market.addVendor(v1);
        market.addVendor(v2);
        market.addVendor(v3);
        market.addVendor(v4);
        market.addVendor(v5);

        //Customer
        Customer Joe = new Customer(market);
        
        //ensure Whole Foods has the cheapest Zipper
        v5.setProductPrice("Zipper", 1.0);

        //Buy a Zipper
        System.out.println("----------------------------------------------------------");
        System.out.println("Order a new \"Zipper\"");
        System.out.println("----------------------------------------------------------");

        Joe.buyProduct("Zipper");
        
        //Buy a Zipper again, without calling reorder()
        System.out.println("----------------------------------------------------------");
        System.out.println("Order a \"Zipper\" again");
        System.out.println("----------------------------------------------------------");

        Joe.buyProduct("Zipper");

        //Buy a Yo-Yo
        System.out.println("----------------------------------------------------------");
        System.out.println("Order a new \"Yo-Yo\"");
        System.out.println("----------------------------------------------------------");

        Joe.buyProduct("Yo-Yo");

        //Re-Order a Zipper
        System.out.println("----------------------------------------------------------");
        System.out.println("Re Order a \"Zipper\"");
        System.out.println("----------------------------------------------------------");

        Joe.reorderProduct("Zipper");
        
        //Return the Yo-Yo
        System.out.println("----------------------------------------------------------");
        System.out.println("Return the \"Yo-Yo\"");
        System.out.println("----------------------------------------------------------");

        Joe.returnProduct("Yo-Yo");
        
        //Attemp to Re Order something that has never been ordered before
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Attempt to Re Order something that has never been ordered before -> \"VideoTape\"");
        System.out.println("---------------------------------------------------------------------");
        
        Joe.reorderProduct("VideoTape");
        Joe.buyProduct("ballooooon");


    }

}
