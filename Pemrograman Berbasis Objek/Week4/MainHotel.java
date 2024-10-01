public class MainHotel {
    public static void main(String[] args) {
        
        Hotel sahidmontana = new Hotel("Sahid Montana");
        Service breakfast = new Service("Breakfast", 100_000);
        Service swimmingpool = new Service("Swimming pool", 30_000);
        Service doublebed = new Service("Double bed", 100_000);
       
        room standard = new room(01);
        room deluxe = new room(02);
        room suite = new room(03);
        
        sahidmontana.addRoom(standard);
        sahidmontana.addRoom(deluxe);
        sahidmontana.addRoom(suite);
        
        sahidmontana.addService(doublebed);
        sahidmontana.addService(swimmingpool);
        sahidmontana.addService(breakfast);
              
        System.out.println(sahidmontana.info());

        Customer2 cust1 = new Customer2("Arka");
        cust1.setBookedRoom(suite);
        cust1.requestService(breakfast);
        cust1.setStayDuration(2);
        System.out.println(cust1.info());
        cust1.printDetailedCost();

        System.out.println(sahidmontana.info());
        
    }
}
