
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class WebMarket {

    private final List<Order> ORDERS;
    private final List<Vendor> VENDORS;
    private String name;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    //Constructor
    public WebMarket(String name) {
        this.name = name;
        ORDERS = new ArrayList();
        VENDORS = new ArrayList();
    }

    public void placeNewOrder(Order order) throws ProductNotFoundException {
        //Acknowledge Statment
        System.out.println("WEB MARKET: Order for " + order.getProductName() + " was received and will be processed.");

        //This catch doesnt currently work, atleast I haven't gotten it too
        if (order.getOrderType().equalsIgnoreCase("reorder")) {
            System.out.println("You are eligible to reorder this product");
            System.out.println("Calling reorder() on this order");
            placeNewReorderOrder(order);

        } else {

            order.setVendor(findCheapestVendor(order));
            ORDERS.add(order);
            sendPaymentToVendor(order.getVendor());

            //Information to display
            String s = "WEB MARKET: ";

            s += order.getProductName() + " was sold from " + order.getVendor().getNAME();
            s += " for " + formatter.format(order.getVendor().getPriceOfProduct(order.getProductName()));
            System.out.println(s);

            deliverProductToCustomer(order);

        }
    }

    public void placeNewReturnOrder(Order order) {
        order.setOrderType("return");
        System.out.println("WEB MARKET: RETURN Order for " + order.getProductName() + " was received and will be processed.");
        returnProductToVendor(order);
        requestRefundFromVendor(order);
        returnPaymentToCustomer(order);
    }

    public void placeNewReorderOrder(Order order) throws ProductNotFoundException {
        order.setOrderType("reorder");
        System.out.println("WEB MARKET: Re Order for " + order.getProductName() + " was received and will be processed.");
        sendPaymentToVendor(order.getVendor());

        String s = "WEB MARKET: ";

        s += order.getProductName() + " was sold from " + order.getVendor().getNAME();
        s += " for " + formatter.format(order.getVendor().getPriceOfProduct(order.getProductName()));
        System.out.println(s);

        deliverProductToCustomer(order);
    }

    private Vendor findCheapestVendor(Order order) throws ProductNotFoundException {

        Vendor cheapestVendor = VENDORS.get(0);
        for (Vendor v : VENDORS) {
            if (v.getPriceOfProduct(order.getProductName()) < cheapestVendor.getPriceOfProduct(order.getProductName())) {
                cheapestVendor = v;
            }
        }
        return cheapestVendor;
    }

    private void sendPaymentToVendor(Vendor vendor) {
        //Blank payment method for implementation/expansion
        //later on
        System.out.println("WEB MARKET: Payment sent to Vendor - " + vendor.getNAME());
    }

    private void deliverProductToCustomer(Order order) {
        order.setOrderStatus("complete");
        System.out.println("WEB MARKET: Order delivered to customer.\n"
                + "WEB MARKET: Status - " + order.getOrderStatus());
    }

    private void requestRefundFromVendor(Order order) {
        System.out.println("WEB MARKET: Request for refund from " + order.getVendor().getNAME() + " has been issued");
        order.getVendor().processRefund(order);

    }

    private void returnPaymentToCustomer(Order order) {
        order.setOrderStatus("complete");
        System.out.println("WEB MARKET: Refund received from " + order.getVendor().getNAME() + " and paid too customer");
    }

    public List<Order> getORDERS() {
        return ORDERS;
    }

    public List<Vendor> getVENDORS() {
        return VENDORS;
    }

    public void addVendor(Vendor vendor) {
        VENDORS.add(vendor);
    }

    private void returnProductToVendor(Order order) {
        System.out.println("WEB MARKET: " + order.getProductName() + " was returned to " + order.getVendor().getNAME());
    }

    @Override
    public String toString() {
        String ret = " WebMarket{" + " Orders" + ORDERS.toString() + " Vendors: " + VENDORS.toString();
        ret += "}";
        return ret;
    }

    public String getName() {
        return name;
    }

}
