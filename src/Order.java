
/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class Order {

    private Vendor vendor;
    private Customer customer;
    private String productName;
    private String orderType;
    private String orderStatus;

    public Order(Vendor vendor, Customer customer, String productName, String orderType, String orderStatus) {
        this.vendor = vendor;
        this.customer = customer;
        this.productName = productName;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    //this constructor does not include vendor, vendor is not usually known at order creation time
    //for buyOrders
    public Order(Customer customer, String product, String orderType, String orderStatus) {
        this.customer = customer;
        this.productName = product;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProductName() {
        return productName;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setOrderType(String orderType) {
        if (!(this.orderType.equalsIgnoreCase("buy") || this.orderType.equals("return") || this.orderType.equals("reorder"))) {
            System.out.println("Unable to change order type. Check usage.\n");
            System.out.println("Type should be either: buy or return or reorder\n");
        }
        this.orderType = orderType;
    }

    public void setOrderStatus(String orderStatus) {
        if (!orderStatus.equals("pending") && !orderStatus.equals("complete")) {
            System.out.println("Unable to change order status. Check usage.\n");
            System.out.println("Status should be either: pending or complete\n");
            System.exit(-1);
        }

        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        String ret = " Order{" + " vendor" + vendor + " customer: " + customer + "orderType:" + orderType + "orderStatus" + orderStatus;
        ret += "}";

        return ret;
    }

}
