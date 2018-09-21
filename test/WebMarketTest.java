import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class WebMarketTest {
    
    private final Vendor v1;
    private final String productName;
    private final String orderType;
    private final String orderStatus;
    private final WebMarket market;
    private Order newOrder;
    private final Customer customer;
    private Order oldOrder;
    
    public WebMarketTest() {
        this.v1 = new Vendor("VendorTest");
        this.market = new WebMarket("goodMarket");
        this.customer = new Customer(market);
        this.orderType = "buy";
        this.orderStatus = "pending";
        this.productName = "Frisbee";
    }

    /**
     * Test of addVendor method, of class WebMarket.
     */
    @Test
    public void testAddVendor() {
        System.out.println("addVendor");
        market.addVendor(v1);
    }

    /**
     * Test of placeNewOrder method, of class WebMarket.
     */
    @Test
    public void testPlaceNewOrderWithBuyType() throws Exception {
        System.out.println("placeNewOrder");
        market.addVendor(v1);
        newOrder = new Order(customer, productName, "buy", orderStatus);
        market.placeNewOrder(newOrder);
        String newOrderStatus = newOrder.getOrderStatus();
        String expectedStatus = "complete";
        assertEquals(newOrderStatus, expectedStatus);
        assertEquals(newOrder.getOrderType(), "buy");
    }

    /**
     * Test of placeNewOrder method, of class WebMarket.
     */
    @Test
    public void testPlaceNewOrderWithReorderType() throws Exception {
        System.out.println("placeNewOrder");
        market.addVendor(v1);
        newOrder = new Order(v1, customer, productName, "reorder", orderStatus);
        market.placeNewOrder(newOrder);
        String newOrderStatus = newOrder.getOrderStatus();
        String expectedStatus = "complete";
        assertEquals(newOrderStatus, expectedStatus);
        assertEquals(newOrder.getOrderType(), "reorder");
    }

    /**
     * Test of placeNewOrder method, of class WebMarket.
     */
    @Test
    public void testPlaceNewOrderWithReturnType() throws Exception {
        System.out.println("placeNewOrder");
        market.addVendor(v1);
        newOrder = new Order(v1, customer, productName, "return", orderStatus);
        market.placeNewOrder(newOrder);
        String newOrderStatus = newOrder.getOrderStatus();
        String expectedStatus = "complete";
        assertEquals(newOrderStatus, expectedStatus);
        assertEquals(newOrder.getOrderType(), "return");
    }

    /**
     * Test of placeNewReturnOrder method, of class WebMarket.
     */
    @Test
    public void testPlaceNewReturnOrder() throws Exception {
        System.out.println("placeNewReturnOrder");
        market.addVendor(v1);
        newOrder = new Order(v1, customer, productName, "return", orderStatus);
        market.placeNewReturnOrder(newOrder);
        String newOrderStatus = newOrder.getOrderStatus();
        String expectedStatus = "complete";
        assertEquals(newOrderStatus, expectedStatus);
        assertEquals(newOrder.getOrderType(), "return");
    }

    /**
     * Test of placeNewReorderOrder method, of class WebMarket.
     */
    @Test
    public void testPlaceNewReorderOrderValid() throws Exception {
        System.out.println("placeNewReorderOrder");
        market.addVendor(v1);
        newOrder = new Order(v1, customer, productName, "reorder", orderStatus);
        market.placeNewReorderOrder(newOrder);
        String newOrderStatus = newOrder.getOrderStatus();
        String expectedStatus = "complete";
        assertEquals(newOrderStatus, expectedStatus);
        assertEquals(newOrder.getOrderType(), "reorder");
    }
    
}
