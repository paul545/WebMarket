
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class CustomerTest {

    private final Vendor v1 = new Vendor("VendorTest");
    private final String goodProductName;
    private final String badProductName;
    private final WebMarket market;
    private final Customer customer;

    public CustomerTest() {
        this.market = new WebMarket("goodMarket");
        this.customer = new Customer(market);
        this.badProductName = "Ferzbee";
        this.goodProductName = "Frisbee";
        market.addVendor(v1);
    }

    /**
     * Test of getMarket method, of class Customer.
     */
    @Test
    public void testGetMarket() {
        System.out.println("getMarket");
        Customer instance = customer;
        WebMarket expResult = market;
        WebMarket result = instance.getMarket();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMarket method, of class Customer.
     */
    @Test
    public void testSetMarket() {
        System.out.println("setMarket");
        WebMarket market2 = new WebMarket("otherMarket");
        Customer instance = customer;
        instance.setMarket(market2);
        assertEquals(instance.getMarket(), market2);
    }

    /**
     * Test of buyProduct method, of class Customer. productName invalid :
     * throws ProductNotFoundException
     *
     * @throws ProductNotFoundException
     */
    @Test(expected = ProductNotFoundException.class)
    public void testBuyProductInvalid() throws ProductNotFoundException {
        System.out.println("buyProduct");
        String productName = badProductName;
        Customer instance = customer;
        instance.buyProduct(productName);
    }

    /**
     * Test of buyProduct method, of class Customer. productName valid : expect
     * nothing
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBuyProductValid() throws Exception {
        System.out.println("buyProduct");
        String productName = goodProductName;
        Customer instance = customer;
        instance.buyProduct(productName);
    }

    /**
     * Test of reorderProduct method, of class Customer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReorderProductValidFound() throws Exception {
        System.out.println("reorderProduct");
        String productName = goodProductName;
        customer.buyProduct(productName);
        customer.reorderProduct(productName);
    }

    /**
     * Test of reorderProduct method, of class Customer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReorderProductValidNotFound() throws Exception {
        System.out.println("reorderProduct");
        String productName = "Yo-Yo";
        Customer instance = customer;
        instance.reorderProduct(productName);
    }

    /**
     * Test of reorderProduct method, of class Customer.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = ProductNotFoundException.class)
    public void testReorderProductInvalid() throws ProductNotFoundException {
        System.out.println("reorderProduct");
        String productName = badProductName;
        Customer instance = customer;
        instance.reorderProduct(productName);
    }

    /**
     * Test of returnProduct method, of class Customer.
     */
    @Test
    public void testReturnProductValidFound() throws Exception {
        System.out.println("returnProduct");
        customer.buyProduct(goodProductName);
        customer.returnProduct(goodProductName);
        Order thisOrder = customer.getOrderByProductName(goodProductName);
        String thisOrderType = thisOrder.getOrderType();
        assertEquals(thisOrderType, "return");
    }

    /**
     * Test of returnProduct method, of class Customer.
     */
    @Test(expected = ProductNotFoundException.class)
    public void testReturnProductValidNotFound() throws Exception {
        System.out.println("returnProduct");
        customer.returnProduct(goodProductName);
    }

    /**
     * Test of returnProduct method, of class Customer.
     */
    @Test(expected = ProductNotFoundException.class)
    public void testReturnProductInvalid() throws ProductNotFoundException {
        System.out.println("returnProduct");
        String productName = badProductName;
        customer.returnProduct(productName);
    }

}
