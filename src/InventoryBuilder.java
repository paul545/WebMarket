
import java.util.ArrayList;
import java.util.Random;


/**
 * WebMarket
 * CSCI 338 Team Project
 * @author Paul Bosonetto, Jacob Ballew, Peter Thompson, Dahquan Williams
 * @version May 2018
 */
public class InventoryBuilder {
    /*can be used by the Vendor (or WebMarket?) to create a unique, random
    list of products and prices*/
        
    private Random rand = new Random();
    private String[] productNameArray = {"Band-Aid","Zipper","Jell-O","Yo-Yo","Frisbee","Escalator","Butterscotch","Videotape","Popsicle","Thermos","Kleenex","Scotch-Tape","Vaseline","Ping Pong","Windex","Heroin","Q-Tips","Saran Wrap","Plexiglas(s)","Kool-Aid","Velcro","Bubble Wrap","Cellophane","Kerosene","Aspirin (Bayer)","Dumpster","Styrofoam","Super Heroes","Trampoline","Tupperware","Post-It Note","AstroTurf","Crock-Pot","Ace Bandage","Rollerblade","Murphy Bed","Hacky Sack","Chapstick","Wite-Out","Drano","Nyquil","Realtor","Tarmac","Taser","U-haul","Tabasco","Speedo","Stetson","Dry Ice","Powerpoint","Photoshop","Winnebago","Cuisinart","Formica","Sharpie","Lysol","Zip-loc","Onesies","Dramamine","Cigarette Boat","Skype","Armor-All","Google","Jet Ski","Advil","Dust Buster","Memory Stick","Jacuzzi","Matchbox Cars","Word","Muzak","Jeep","Excel","FedEx","Bengay","Bisquick","Brillo Pad","Britta","Coke","Groupon","Head & Shoulders","Zipcar","JumboTron","Levi’s","Mack Truck","Pepto Bismol","Polaroid","Roto-Rooter","Swiffer","Tums","Tylenol","Xerox","Krazy Glue","Vespa","Walkman","Netbook","Zamboni","Altoids","Shredded Wheat","X-ACTO Knife"};
    private int sizeOfNameArray = productNameArray.length;
    private ArrayList<Product> productList;
    //INVENTORYSIZE is set to 100 to ensure every Vendor has all 100 products
    private final int INVENTORYSIZE = 100;
    
    public InventoryBuilder() {
        productList = generateInventory(INVENTORYSIZE);
    }
    
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    //populates an ArrayList of Products and sets random prices for each Product
    private ArrayList<Product> generateInventory(int size) {
        String[] myProductNames = createCustomProductNameArrayByLength(size);
        ArrayList<Product> myProductList = new ArrayList<>();
        double newPrice;
        for (String name : myProductNames) {
            //sets random price between 2.50 - 20.00 by 0.25 increments
            newPrice = ((double) ((rand.nextInt(70))) + 10) / 4; 
            myProductList.add(new Product(name, newPrice));
        }
        return myProductList;
    }
    
    //used by generateInventory() to randomize the order of the Products in a list
    private String[] createCustomProductNameArrayByLength(int arrayLength) {
        String[] outArray = new String[arrayLength];
        int[] indexArray = randomizeIndexesWithSetLength(arrayLength);
        for (int i = 0; i < arrayLength; i ++) {
            //match random indexes to their corresponding Strings in productNameArray
            outArray[i] = productNameArray[indexArray[i]];
        }
        return outArray;
    }
    
    //used by createCustomProductNameArrayByLength()
    //provides an int[] with randomized, non-repeated index values to randomly select Strings from productNameArray
    private int[] randomizeIndexesWithSetLength(int newArrayLength) {
        int[] randomIndexArray = new int[newArrayLength];
        int namesRemainingInNameArray = sizeOfNameArray;
        int incrementLimit;
        int randomIncrement; //randomly generated using the incrementLimit
        int selectorIndex; //index that will point to String in productNameArray
        selectorIndex = -1; //start at -1 so that 0th element is a possibility
        for (int i = 0; i < randomIndexArray.length; i++) {
            incrementLimit = (namesRemainingInNameArray/newArrayLength);
            randomIncrement = rand.nextInt(incrementLimit) + 1;
            selectorIndex += randomIncrement;
            randomIndexArray[i] = selectorIndex;
            //update number of remaining elements in productNameArray to choose from
            namesRemainingInNameArray -= randomIncrement;
            newArrayLength --;
        }
        return randomIndexArray;
    }
    

}



