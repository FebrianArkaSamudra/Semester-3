import java.time.LocalTime;
import java.util.*;

public class Restaurant {
    private String name;
    private int finances;
    private Inventory inventory;
    private double reputation;
    private Queue<Customer> orderQueue;
    private List<Chef> chefs;
    private List<Cashier> cashiers;

    public Restaurant(String name, int finances, Inventory inventory, double reputation) {
        this.name = name;
        this.finances = finances;
        this.inventory = inventory;
        this.reputation = reputation;
        this.orderQueue = new LinkedList<>();
        this.chefs = new ArrayList<>();
        this.cashiers = new ArrayList<>();
    }

    public void addChef(Chef chef) {
        chefs.add(chef);
        System.out.println("-------------------------------------------------------------");
        System.out.println(chef.getName() + " has been added as a chef.");
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
        System.out.println("-------------------------------------------------------------");
        System.out.println(cashier.getName() + " has been added as a cashier.");
        System.out.println("-------------------------------------------------------------");
    }

    public void receiveOrder(Customer customer) {
        customer.setArrivalTime(LocalTime.now());
        orderQueue.add(customer);
        System.out.println("Order from " + customer.getName() + " has been received at " + customer.getArrivalTime());
    }

    public void measureSatisfaction() {
        int totalPatience = 0;
        for (Customer customer : orderQueue) {
            totalPatience += customer.getPatience();
        }
        double satisfaction = orderQueue.isEmpty() ? 0 : (double) totalPatience / orderQueue.size();
        reputation = satisfaction;
        System.out.println("Average customer satisfaction: " + satisfaction);
        System.out.println("\n");
    }

    public void displayMenu() {
        System.out.println("\n\n=======WELCOME TO ARKA RESTAURANT=======\n");
        System.out.println("Menu of Restaurant " + name + ":");
        System.out.println("Foods:");
        System.out.println("1. Food A - 20,000 IDR");
        System.out.println("2. Food B - 15,000 IDR");
        System.out.println("Beverages:");
        System.out.println("1. Beverage A - 5,000 IDR");
        System.out.println("2. Beverage B - 10,000 IDR\n\n");
    }

    public Inventory getInventory() {
        return inventory;
    }
}
