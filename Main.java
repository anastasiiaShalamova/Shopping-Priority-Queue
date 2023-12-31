package shopping_Priority_Queue_2;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
        // creating shoppers with different total purchase values for testing
        Shopper shopper1 = new Shopper("Leah", 5, 130.0);
        Shopper shopper2 = new Shopper("Rivka", 3, 110.0);
        Shopper shopper3 = new Shopper("Esty", 4, 70.0);

        // creating a priority queue
        CustomPriorityQueue priorityQueue = new CustomPriorityQueue();

        // adding shoppers to the priority queue
        priorityQueue.addShopper(shopper1);
        priorityQueue.addShopper(shopper2);
        priorityQueue.addShopper(shopper3);

        // displaying the initial priority queue
        priorityQueue.displayPriorityQueue(priorityQueue.checkoutAndGetList(), "Initial Priority Queue");

        // displaying the updated priority queue
        priorityQueue.displayPriorityQueue(priorityQueue.checkoutAndGetList(), "Updated Priority Queue");

        // simulating the checkout process
        priorityQueue.checkout();

        // simulating the checkout process and get a list of shoppers
        List<Shopper> checkoutList = priorityQueue.checkoutAndGetList();

        // distribute coupons to shoppers above a certain threshold
        priorityQueue.distributeCoupons(checkoutList, 100.0);
    }
}

