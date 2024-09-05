public class RiceCooker {
    int capacity;
    String brand;
    String color;
    int power;

    RiceCooker(int capacity, String brand, String color, int power) {
        this.capacity = capacity;
        this.brand = brand;
        this.color = color;
        this.power = power;
    }

    void cookRice() {
        System.out.println("Cooking rice");
    }

    void keepWarm() {
        System.out.println("Keeping rice warm");
    }

    void displayInfo() {
        System.out.println("RiceCooker = Capacity: " + capacity + "L, Brand: " + brand + ", Color: " + color + ", Power: " + power);
    }
}