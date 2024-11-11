public abstract class Zombie implements IDestroyable{
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    public String getZombieInfo() {
        return "Zombie Data =\nHealth = " + health + "\nLevel = " + level;
    }
}