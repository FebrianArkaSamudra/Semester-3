public class Barrier implements IDestroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        strength -= strength * 0.1; // Reduce strength by 10%
    }

    public String getBarrierInfo() {
        return "Barrier Strength = " + strength;
    }
}