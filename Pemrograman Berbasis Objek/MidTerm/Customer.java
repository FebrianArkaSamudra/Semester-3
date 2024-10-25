import java.time.LocalTime;
import java.util.List;

public class Customer {
    private String name;
    private List<Menu> foodPreferences;
    private int patience;
    private LocalTime arrivalTime;

    public Customer(String name, List<Menu> foodPreferences, int patience) {
        this.name = name;
        this.foodPreferences = foodPreferences;
        this.patience = patience;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getFoodPreferences() {
        return foodPreferences;
    }

    public int getPatience() {
        return patience;
    }
}