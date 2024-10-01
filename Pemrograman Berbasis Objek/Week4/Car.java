public class Car {
    private String brand;
    private int cost;

    public Car() {}

    public void setName(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return brand;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int carCostCalculation (int days) {
        return cost * days;
    }
}