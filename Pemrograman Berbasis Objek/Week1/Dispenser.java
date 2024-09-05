public class Dispenser {
    String brand;
    int capacity;
    String type;
    String color;

    Dispenser(String brand, int capacity, String type, String color) {
        this.brand = brand;
        this.capacity = capacity;
        this.type = type;
        this.color = color;
    }

    void dispenseHotWater() {
        System.out.println("Dispensing hot water");
    }

    void dispenseColdWater() {
        System.out.println("Dispensing cold water");
    }

    void displayInfo() {
        System.out.println("Dispenser = Brand: " + brand + ", Capacity: " + capacity + "L, Type: " + type + ", Color: " + color);
    }
}
