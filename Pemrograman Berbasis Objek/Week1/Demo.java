public class Demo {
    public static void main(String[] args) {
        
        MotorCycle mc= new MotorCycle("Black", "Twin Tak", "Bennelli", "Pentagonian Eagle");
        Car Car = new Car("SilverBlack", "Diesel", "Toyota","Vios");
        RiceCooker rc = new RiceCooker(1, "Sanken", "Black", 500);
        Dispenser dispenser = new Dispenser("Miyako", 1, "Hot-Cold", "White");

        mc.startEngine();
        mc.displayInfo();
        mc.stopEngine();

        Car.startEngine();
        Car.displayInfo();
        Car.stopEngine();

        rc.cookRice();
        rc.displayInfo();
        rc.keepWarm();

        dispenser.dispenseHotWater();
        dispenser.displayInfo();
        dispenser.dispenseColdWater();
    }
}