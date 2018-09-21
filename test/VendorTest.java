import org.junit.Test;
import static org.junit.Assert.*;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class VendorTest {
    
    private final Vendor vendr;
    private final String goodProductName;
    private final String badProductName;
    
    public VendorTest() {
        vendr = new Vendor("VendorTest");
        this.badProductName = "Ferzbee";
        this.goodProductName = "Frisbee";
    }

    /**
     * Test of getPriceOfProduct method, of class Vendor.
     */
    @Test
    public void testGetPriceOfProductValid() throws ProductNotFoundException {
        System.out.println("getPriceOfProduct");
        String productName = goodProductName;
        Vendor instance = vendr;
        double expResult = 2.5;
        vendr.setProductPrice(goodProductName, expResult);
        double result = instance.getPriceOfProduct(productName);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPriceOfProduct method, of class Vendor.
     */
    @Test(expected = ProductNotFoundException.class)
    public void testGetPriceOfProductInvalid() throws ProductNotFoundException {
        System.out.println("getPriceOfProduct");
        double result = vendr.getPriceOfProduct(badProductName);
    }

    /**
     * Test of processRefund method, of class Vendor.
     */
    @Test
    public void testProcessRefund() {
        System.out.println("processRefund");
        Order order = null;
        vendr.processRefund(order);
    }
    
}
