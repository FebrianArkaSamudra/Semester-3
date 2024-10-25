public class Cashier extends Employee {
    public Cashier(String name, int skillLevel) {
        super(name, skillLevel);
    }

    public void acceptPayment(int totalPrice) {
        System.out.println(getName() + " accepted payment of: " + totalPrice + " IDR");
    }
}