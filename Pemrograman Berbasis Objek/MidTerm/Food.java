import java.util.List;

public class Food extends Menu {
    private List<String> ingredients;
    private int cookingTime;

    public Food(String name, int price, List<String> ingredients, int cookingTime) {
        super(name, price);
        this.ingredients = ingredients;
        this.cookingTime = cookingTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void cook() {
        System.out.println(getName() + " is being cooked... (cooking time: " + cookingTime + " seconds)");
    }
}