public class Percobaan3 {
    public static void main(String[] args) {
        Tabung tabung = new Tabung();
        tabung.setSuperPhi(3.14);
        tabung.setSuperR(10);
        tabung.setT(3);


        System.out.println("Using phi: " +tabung.getSuperPhi());
        System.out.println("With Radius : " +tabung.getSuperR());
        System.out.println("Height : " +tabung.getT());
        tabung.volume();
    }
}
