import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Food friedRiceA = new Food("Fried Rice Egg", 15000, Arrays.asList("rice", "egg", "soy sauce"), 5);
        Food friedRiceB = new Food("Fried Rice Chicken", 17000, Arrays.asList("rice", "chicken", "soy sauce"), 3);
        Beverages icedTea = new Beverages("Iced Tea", 5000, Arrays.asList("water", "tea", "sugar"));
        Beverages orangeJuice = new Beverages("Orange Juice", 7000, Arrays.asList("orange", "water"));

        Inventory inventory = new Inventory();
        inventory.addStock("rice", 20);
        inventory.addStock("egg", 20);
        inventory.addStock("soy sauce", 20);
        inventory.addStock("chicken", 20);
        inventory.addStock("water", 20);
        inventory.addStock("sugar", 20);
        inventory.addStock("tea", 20);
        inventory.addStock("orange", 20);

        Restaurant restaurant = new Restaurant("Fried Rice Shop", 100000, inventory, 5.0);

        Chef chef1 = new Chef("Adzin", 3);
        Cashier cashier1 = new Cashier("Kevin", 2);
        restaurant.addChef(chef1);
        restaurant.addCashier(cashier1);

        restaurant.displayMenu();

        List<Customer> customerList = Arrays.asList(
                new Customer("Seno", Arrays.asList(friedRiceA, icedTea), 10),
                new Customer("Majid", Arrays.asList(friedRiceB, orangeJuice), 10),
                new Customer("Baihaqi", Arrays.asList(friedRiceA, friedRiceB), 10),
                new Customer("Xavier", Arrays.asList(icedTea), 8)
        );

        Random random = new Random();

        for (Customer customer : customerList) {
            try {
                int arrivalTime = random.nextInt(3000) + 1000;
                Thread.sleep(arrivalTime);

                restaurant.receiveOrder(customer);
                Order order = new Order(customer, customer.getFoodPreferences());
                order.displayOrder();

                for (Menu menu : customer.getFoodPreferences()) {
                    if (menu instanceof Food) {
                        chef1.cook((Food) menu);
                        for (String ingredient : ((Food) menu).getIngredients()) {
                            restaurant.getInventory().reduceStock(ingredient, 1);
                        }
                    }
                }

                int totalPrice = customer.getFoodPreferences().stream().mapToInt(Menu::getPrice).sum();

                cashier1.acceptPayment(totalPrice);

                restaurant.measureSatisfaction();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        restaurant.getInventory().displayStock();
    }
}
