import java.util.List;

public class Beverages extends Menu {
    private List<String> ingredients;

    public Beverages(String name, int price, List<String> ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}