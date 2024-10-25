import java.util.List;

public class Order {
    private Customer customer;
    private List<Menu> orderedItems;
    private int totalPrice;

    public Order(Customer customer, List<Menu> orderedItems) {
        this.customer = customer;
        this.orderedItems = orderedItems;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice() {
        int total = 0;
        for (Menu item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Menu> getOrderedItems() {
        return orderedItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void displayOrder() {
        System.out.println("Order Details for " + customer.getName() + ":");
        for (Menu item : orderedItems) {
            System.out.println("- " + item.getName() + " (" + item.getPrice() + " IDR)");
        }
        System.out.println("Total Price: " + totalPrice + " IDR");
    }
}
