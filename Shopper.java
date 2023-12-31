package shopping_Priority_Queue_2;

/** shopper class represents a customer in the shopping system
 * each shopper has a unique name, items purchased, total purchase value, and insertion order */
class Shopper {
    // counter to assign unique insertion orders 
    private static int counter = 0;

    // name of the shopper 
    private String name;

    // number of items purchased by the shopper 
    private int itemsPurchased;

    // total purchase value by the shopper
    private double totalPurchase;

    // order in which the shopper was inserted into the system
    private int insertionOrder;

    /** constructor to create a new shopper with the specified name, items purchased, and total purchase value
     * @param name , name of the shopper
     * @param itemsPurchased , number of items purchased by the shopper
     * @param totalPurchase ,  total purchase value by the shopper */
    public Shopper(String name, int itemsPurchased, double totalPurchase) {
        this.name = name;
        this.itemsPurchased = itemsPurchased;
        this.totalPurchase = totalPurchase;
        this.insertionOrder = counter++;
    }

    /** gets the name of the shopper
     * @return name of the shopper */
    public String getName() {
        return name;
    }

    /** gets the number of items purchased by the shopper
     * @return The number of items purchased */
    public int getItemsPurchased() {
        return itemsPurchased;
    }

    /** gets the total purchase value by the shoppe
     * @return The total purchase value */
    public double getTotalPurchase() {
        return totalPurchase;
    }

    /** sets the total purchase value by the shopper
     * @param totalPurchase The new total purchase value */
    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    /** gets the insertion order of the shopper
     * @return The insertion order */
    public int getInsertionOrder() {
        return insertionOrder;
    }

    /** overrides the toString() method to provide a string representation of the shopper
     * @return A string representation of the shopper */
    @Override
    public String toString() {
        return "Shopper{" +
                "name='" + name + '\'' +
                ", itemsPurchased=" + itemsPurchased +
                ", totalPurchase=" + totalPurchase +
                ", insertionOrder=" + insertionOrder +
                '}';
    }
}
