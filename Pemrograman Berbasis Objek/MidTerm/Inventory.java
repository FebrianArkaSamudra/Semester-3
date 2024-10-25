import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> ingredientStock;

    public Inventory() {
        ingredientStock = new HashMap<>();
    }

    public void addStock(String ingredient, int quantity) {
        ingredientStock.put(ingredient, ingredientStock.getOrDefault(ingredient, 0) + quantity);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Stock of " + ingredient + " has been added. New amount: " + ingredientStock.get(ingredient));
    }

    public void reduceStock(String ingredient, int quantity) {
        if (ingredientStock.getOrDefault(ingredient, 0) >= quantity) {
            ingredientStock.put(ingredient, ingredientStock.get(ingredient) - quantity);
            System.out.println("-------------------------------------------------------------");
            System.out.println("Stock of " + ingredient + " has been reduced. New amount: " + ingredientStock.get(ingredient));
        } else {
            System.out.println("Not enough stock of " + ingredient + " to reduce.");
        }
    }

    public void displayStock() {
        System.out.println("Current Ingredient Stock:");
        for (Map.Entry<String, Integer> entry : ingredientStock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}