public class Motor {

    public int speed=0;
    public boolean motorOn=false;

    public void statusPrint () {
        if (motorOn==true) {
            System.out.println("Motor Cycle On");
        }
        else{
            System.out.println("Motor Cycle Off");
        }
        System.out.println("Speed: " +speed+"\n");
    }
}