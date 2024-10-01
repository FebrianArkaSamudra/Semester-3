public class Main1 {
    public static void main(String[] args) {
        Processor p = new Processor("Intel i5", 3);
        Computer L = new Computer("Thinkpad", p);

        L.info();

        Processor p1 = new Processor(null, 0);
        p1.setBrand("Intel i5");
        p1.setCache(4);

        Computer c1 = new Computer(null, p);
        c1.setBrand("Thinkpad"); 
        c1.setProc(p1); 
        c1.info(); 

    }
}