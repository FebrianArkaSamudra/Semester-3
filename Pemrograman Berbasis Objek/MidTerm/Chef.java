public class Chef extends Employee {
    public Chef(String name, int skillLevel) {
        super(name, skillLevel);
    }

    public void cook(Food food) {
        System.out.println(getName() + " is cooking " + food.getName());
        food.cook();
        System.out.println("\n");
    }
}