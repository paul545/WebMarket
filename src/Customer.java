
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class Customer {

    Scanner scan = new Scanner(System.in);
    private List<Order> orderHistory;
    private WebMarket market;

    /**
     * Customer constructor
     * @param market market to be used
     */
    public Customer(WebMarket market) {
        orderHistory = new ArrayList();
        this.market = market;
    }

    //Pay the WebMarket who would then pay the Vendor
    private void pay() {
        System.out.println("Customer sent payment");
    }

    //Return the WebMarket being used
    public WebMarket getMarket() {
        return market;
    }

    //Set the WebMarket to be used
    public void setMarket(WebMarket market) {
        this.market = market;
    }

    /**
     * Customer places a new order with a WebMarket using a Product name
     * @param productName String representation of product to be purchased.
     * @throws ProductNotFoundException when the product name is not found
     */
    public void buyProduct(String productName) throws ProductNotFoundException {

        if (doesRecentOrderExist(productName)) {
            reorderProduct(productName);
        } else {
        //Create a new order to be given to the WebMarket
        Order newOrder = new Order(this, productName, "buy", "pending");

        //Acknowlegement print statment
        System.out.println("CUSTOMER:   Request NEW purchase of - " + newOrder.getProductName());

        //Send the order to WebMarket via placeNewOrder()
        market.placeNewOrder(newOrder);

        //Add this order to the customers personel list of orders
        orderHistory.add(newOrder);
        }
    }

    /**
     * Customer re-orders a previously ordered Product with a WebMarket using a Product name
     * @param productName String representation of product to be re-ordered.
     * @throws ProductNotFoundException when the product name is not found
     */
    public void reorderProduct(String productName) throws ProductNotFoundException {

        //Check to see if the customer has ordered this product before
        if (doesRecentOrderExist(productName)) {
            System.out.println("CUSTOMER:   Request RE ORDER purchase for - " + productName);
            //Place a RE ORDER request
            market.placeNewReorderOrder(findRecentOrder(productName));
        } else {
            //If no previous order was found to re order, ask if they'd like to place a new order
            //This handles throwing an Order/Product not found exception
            if (promptNewOrder(productName)) {
                buyProduct(productName);
            }
        }
    }

    /**
     * Customer returns a previously ordered Product with a WebMarket using a Product name
     * @param productName String representation of product to be returned.
     * @throws ProductNotFoundException when the product name is not found
     */
    public void returnProduct(String productName) throws ProductNotFoundException {
        //If they have this product to return
        if (doesRecentOrderExist(productName)) {
            market.placeNewReturnOrder(findRecentOrder(productName));
        } else {
            //If not let them know, we quit here.
            throw new ProductNotFoundException(productName + " was never previously purchased. Can not be returned");
        }
    }

    @Override
    public String toString() {
        String s = "";

        s += "Customer Using WebMarket: " + market.getName() + " \n";
        s += "Order History: \n";
        for (int i = 0; i < orderHistory.size(); i++) {
            s += orderHistory.get(i).getProductName() + " from ";
            s += orderHistory.get(i).getVendor().getNAME() + " for ";
            try {
                s += "$" + orderHistory.get(i).getVendor().getPriceOfProduct(orderHistory.get(i).getProductName()) + " \n";
            } catch (ProductNotFoundException e) {
                System.out.println("Customer toString: ProductNotFoundException!");
            };
        }
        return s;
    }

    //used by several local methods to determine if a specific Product has been purchased previously
    private Order findRecentOrder(String productName) {
        for (int i = 0; i < orderHistory.size(); i++) {
            if (orderHistory.get(i).getProductName().equalsIgnoreCase(productName)) {
                return orderHistory.get(i);
            }
        }
        return null;
    }

    /**
     * doesRecentOrderExist
     *
     * @param productName product to check for
     * @return true if the product was found in the order history.
     * @return false if the product was not found.
     */
    private boolean doesRecentOrderExist(String productName) {
        for (int i = 0; i < orderHistory.size(); i++) {
            if (orderHistory.get(i).getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * promptNewOrder
     * Used by the buyProduct() method when the customer places an order for
     * a product that they have not already purchased in the past
     * @param productName string of order to be placed
     * @return true if customer chooses "Yes" to place a new order
     */
    private boolean promptNewOrder(String productName) {
        System.out.println("It doesn't look like you've placed this order before. "
                + "Would you like to place a new order for - " + productName + "?\n"
                + "ENTER \"YES\" to Place a New Order  or  \"NO\" to continue.");
        boolean responseIsYes;
        try {
            responseIsYes = scan.next().equalsIgnoreCase("yes");
        } 
        //if the user does not type anything, default to "Yes"
        catch(java.util.NoSuchElementException e){
            responseIsYes = true;
        }
        if (responseIsYes) {
            System.out.println("Thank you! A new Order will be placed.\n"
                    + "----------------------------------------------------------");
            return true;
        }
        System.out.println("Thank you! This order has been cancelled.\n"
                    + "----------------------------------------------------------");
            return false;
    }
    
    //for testing only
    Order getOrderByProductName(String productName) throws ProductNotFoundException {
        Order orderUp;
        orderUp = findRecentOrder(productName);
        if (orderUp == null) {
            throw new ProductNotFoundException(productName + " not found by Customer.getOrderByProductName()");
        }
        return orderUp;
    }

}
