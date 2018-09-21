
import java.util.Scanner;

/**
 * WebMarket CSCI 338 Team Project
 *
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class DriverDemo {

    public static void main(String[] args) throws Exception {

        /*WebMarket - gave this a name parameter, 
        basically just for customer's toString. We can remove if desired nothing else should be effected*/
        WebMarket market = new WebMarket("Online Express");

        //Customer
        Customer Joe = new Customer(market);

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

        //ensure Whole Foods has the cheapest Zipper
        v5.setProductPrice("Zipper", 1.0);

        boolean programLoop = true;
        String choice = "";
        Scanner scan = new Scanner(System.in);

        while (programLoop) {
            if (choice.equalsIgnoreCase("")) {
                //Buy a Zipper
                System.out.println("----------------------------------------------------------");
                System.out.println("Order a new \"Zipper\"");
                System.out.println("----------------------------------------------------------");

                Joe.buyProduct("Zipper");
            }

            if (choice.equalsIgnoreCase("y")) {
                //Buy a Zipper again, without calling reorder()
                System.out.println("----------------------------------------------------------");
                System.out.println("Re Order another \"Zipper\"");
                System.out.println("----------------------------------------------------------");

                Joe.buyProduct("Zipper");
            }

            if (choice.equalsIgnoreCase("yy")) {
                //Buy a Yo-Yo
                System.out.println("----------------------------------------------------------");
                System.out.println("Order a new \"Yo-Yo\"");
                System.out.println("----------------------------------------------------------");

                Joe.buyProduct("Yo-Yo");

            }

            if (choice.equalsIgnoreCase("yyy")) {
                //Return the Yo-Yo
                System.out.println("----------------------------------------------------------");
                System.out.println("Return the \"Yo-Yo\"");
                System.out.println("----------------------------------------------------------");

                Joe.returnProduct("Yo-Yo");

            }

            if (choice.equalsIgnoreCase("yyyy")) {
                //Attemp to Re Order something that has never been ordered before
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Attempt to Re Order something that has never been ordered before -> \"VideoTape\"");
                System.out.println("-----------------------------------------------------------------------------------");

                Joe.reorderProduct("VideoTape");

                System.out.println("Demo Complete");
                System.exit(0);
            }

            // System.out.println("Next Step? ");
            choice += scan.next();

        }//END programLoop

    }

}
