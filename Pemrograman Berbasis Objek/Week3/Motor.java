public class Motor {

    private int speed=0;
    private boolean motorOn=false;

    public void startEngine () {
        motorOn=true;
    }
    public void turnOffEngine () {
        motorOn=false;
        speed=0;
    }
    public void increaseEngine () {
        if (motorOn==true) {
            speed+=5;
        }
        else {
            System.out.println("Motor Cycle Off");
        }
    }
    public void reduceEngine () {
        if (motorOn==true) {
            speed+=5;
        }
        else {
            System.out.println("Motor Cycle Off");
        }
    }
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