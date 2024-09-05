public class Vehicle {
    String color;
    String engineType;

    Vehicle(String color, String engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    void startEngine() {
        System.out.println("Engine started.");
    }

    void stopEngine() {
        System.out.println("Engine stopped.");
    }

    void displayInfo() {
        System.out.println("Vehicle = Color: " + color + ", Engine Type: " + engineType);
    }
}

