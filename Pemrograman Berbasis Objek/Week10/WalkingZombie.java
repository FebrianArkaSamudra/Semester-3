public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        if (level == 1) {
            health += health * 0.1; // Heal by 10%
        } else if (level == 2) {
            health += health * 0.3; // Heal by 30%
        } else if (level == 3) {
            health += health * 0.4; // Heal by 40%
        }
    }

    @Override
    public void destroyed() {
        health -= health * 0.2; // Reduce health by 20%
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data =\nHealth = " + health + "\nLevel = " + level;
    }
}