
import java.util.ArrayList;
import java.util.List;

/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class Vendor {

    private final List<Product> PRODUCTPRICES;
    private final String NAME;

    public Vendor(String name) {
        NAME = name;
        InventoryBuilder ib = new InventoryBuilder();
        PRODUCTPRICES = ib.getProductList();
    }

    private Product getProductByName(String productName) throws ProductNotFoundException {
        Product productFound = null;
        for (Product p : PRODUCTPRICES) {
            if (p.getName().equalsIgnoreCase(productName)) {
                productFound = p;
            }
        }
        if (productFound == null) {
            throw new ProductNotFoundException("Product " + productName
                    + " not found with Vendor ");
        }
        return productFound;
    }

    /**
     * Used by the WebMarket to query the price of a particular product
     *
     * @param productName name of the product to be searched
     * @return the price of the product specified
     * @throws ProductNotFoundException
     */
    public double getPriceOfProduct(String productName) throws ProductNotFoundException {
        Product myProduct = getProductByName(productName);
        double priceOfMyProduct = myProduct.getPrice();
        return priceOfMyProduct;
    }

    public void processRefund(Order order) {
        System.out.println("VENDOR:     Refund for customer has been issued.");
    }

    public List<Product> getPRODUCTPRICES() {
        return PRODUCTPRICES;
    }

    public String getNAME() {
        return NAME;
    }
    
    //for testing only
    void setProductPrice(String productName, double newPrice) throws ProductNotFoundException {
        Product myProduct = getProductByName(productName);
        myProduct.setPrice(newPrice);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Vendor: ");
        out.append(NAME).append(": ");
        for (Product p : PRODUCTPRICES) {
            out.append("\n\t")
                    .append(p.toString());
        }
        return out.toString();
    }

    public static void main(String[] rgs) {

        Vendor v = new Vendor("Sell-A-Lot");
        System.out.println(v);
    }
}
