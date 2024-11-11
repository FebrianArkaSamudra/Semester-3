
public class JumpingZombie extends Zombie{
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        if (level == 1) {
            health += health * 0.3; // Heal by 30%
        } else if (level == 2) {
            health += health * 0.4; // Heal by 40%
        } else if (level == 3) {
            health += health * 0.5; // Heal by 50%
        }
    }

    @Override
    public void destroyed() {
        health -= health * 0.1; // Reduce health by 10%
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data =\nHealth = " + health + "\nLevel = " + level;
    }
}
