public class Car extends Vehicle {
    String brand;
    String model;

    Car(String color, String engineType, String brand, String model) {
        super(color, engineType);
        this.brand = brand;
        this.model = model;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Car = Brand: " + brand + ", Model: " + model);
    }

    void startEngine() {
        System.out.println("Engine started.");
    }

    void stopEngine() {
        System.out.println("Engine stopped.");
    }
}