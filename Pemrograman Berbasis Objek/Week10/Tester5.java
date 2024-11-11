public class Tester5 {
    public static void main(String[] args) {
        // Initialize the objects
        WalkingZombie wz = new WalkingZombie(120, 1);
        JumpingZombie jz = new JumpingZombie(150, 3);
        Barrier b = new Barrier(80);
        Plant p = new Plant();

        // Display initial info
        System.out.println("Initial State:");
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
        System.out.println("---------------------------");

        // Destroy objects with varied frequencies
        for (int i = 0; i < 2; i++) { // Destroy each object twice
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }

        // Display intermediate state
        System.out.println("After 2 times destruction:");
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
        System.out.println("---------------------------");

        for (int i = 0; i < 3; i++) { // Destroy each object 3 more times
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }

        // Display final state
        System.out.println("After 5 total times destruction:");
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
    }
}
 
