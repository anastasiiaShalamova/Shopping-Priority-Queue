package shopping_Priority_Queue_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** CustomPriorityQueue class represents a priority queue for managing shoppers based on their total purchase value
 * shoppers with a higher total purchase value have higher priority */
public class CustomPriorityQueue {

    /** priority queue implemented as a linked list */
    private List<Shopper> priorityQueue;

    /** constructor to initialize the priority queue as a linked list */
    public CustomPriorityQueue() {
        this.priorityQueue = new LinkedList<>();
    }

    /** sdds a shopper to the priority queue while maintaining the order based on total purchase value
     * @param shopper The shopper to be added. */
    public void addShopper(Shopper shopper) {
        int index = 0;
        while (index < priorityQueue.size() && compare(shopper, priorityQueue.get(index)) <= 0) {
            index++;
        }
        priorityQueue.add(index, shopper);
    }

    /** updates the total purchase value of a shopper, removing and re-adding to maintain order
     * @param shopper to update
     * @param newTotalPurchase, new total purchase value */
    public void updateTotalPurchase(Shopper shopper, double newTotalPurchase) {
        priorityQueue.remove(shopper);
        shopper.setTotalPurchase(newTotalPurchase);
        addShopper(shopper);
    }

    /** simulates the checkout process, displaying shoppers from highest to lowest total purchase value */
    public void checkout() {
        System.out.println("\nCheckout Process:");

        // Reverse the order of shoppers before printing
        List<Shopper> reversedCheckoutList = new LinkedList<>(priorityQueue);
        Collections.reverse(reversedCheckoutList);

        for (Shopper shopper : reversedCheckoutList) {
            System.out.printf("Checking out: %-20s (Total Purchase: $%.2f)%n",
                    shopper.getName(), shopper.getTotalPurchase());
        }
    }

    /** returns a copy of the priority queue as a list
     * @return list representing the current state of the priority queue */
    public List<Shopper> checkoutAndGetList() {
        return new LinkedList<>(priorityQueue);
    }

    /** distributes coupons to shoppers above a certain threshold and displays the changes in total purchase value
     * @param shoppers  , list of shoppers to check for coupon distribution
     * @param threshold , threshold for coupon distribution  */
    public void distributeCoupons(List<Shopper> shoppers, double threshold) {
        System.out.println("\nCoupon Distribution:");
        for (Shopper shopper : shoppers) {
            if (shopper.getTotalPurchase() > threshold) {
                double originalTotalPurchase = shopper.getTotalPurchase();

                // Apply the coupon and update the total purchase value
                shopper.setTotalPurchase(originalTotalPurchase - 100.0);

                System.out.printf("Coupon distributed to %-20s " +
                                "(Original Total Purchase: $%.2f), Updated Total Purchase: $%.2f%n",
                        shopper.getName(), originalTotalPurchase, shopper.getTotalPurchase());
            }
        }
    }

    /** displays the priority queue in a formatted and user-friendly way
     * @param shoppers , list of shoppers in the priority queue
     * @param title , header for the display */
    public void displayPriorityQueue(List<Shopper> shoppers, String title) {
        System.out.println("\n" + title + ":");

        if (shoppers.isEmpty()) {
            System.out.println("No shoppers in the queue.");
            return;
        }

        System.out.printf("%-20s %-15s %-15s %-15s%n", "Shopper Name", "Items Purchased", "Total Purchase", "Insertion Order");
        System.out.println("---------------------------------------------------------------------------");

        for (Shopper shopper : shoppers) {
            System.out.printf("%-20s %-15d %-15.2f %-15d%n",
                    shopper.getName(), shopper.getItemsPurchased(), shopper.getTotalPurchase(), shopper.getInsertionOrder());
        }
    }

    /** compares two shoppers based on total purchase value and insertion order
     * @param shopper1 
     * @param shopper2 
     * @return , a negative, zero, or positive integer if the first shopper is less than, equal to, or greater than 
     * the second shopper, respectively  */
    private int compare(Shopper shopper1, Shopper shopper2) {
        int totalPurchaseComparison = Double.compare(shopper2.getTotalPurchase(), shopper1.getTotalPurchase());
        if (totalPurchaseComparison == 0) {
            return Integer.compare(shopper1.getInsertionOrder(), shopper2.getInsertionOrder());
        }
        return totalPurchaseComparison;
    }
}
