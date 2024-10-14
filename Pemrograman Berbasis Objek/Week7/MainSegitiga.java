public class MainSegitiga {
    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();

        int sudut1 = segitiga.totalSudut(60);
        System.out.println("Total sudut with one angle: " + sudut1);  
        System.out.println("Value of sudut field: " + segitiga.getSudut());  

        int sudut2 = segitiga.totalSudut(60, 30);
        System.out.println("Total sudut with two angles: " + sudut2);  
        System.out.println("Value of sudut field: " + segitiga.getSudut());  

        int keliling1 = segitiga.keliling(3, 4, 5);
        System.out.println("Perimeter of the triangle: " + keliling1);  

        double keliling2 = segitiga.keliling(3, 4);
        System.out.println("Hypotenuse: " + keliling2);  
    }
}
