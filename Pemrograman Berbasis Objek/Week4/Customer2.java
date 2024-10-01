import java.util.ArrayList;
import java.util.List;

public class Customer2 {
    private String name;
    private room bookedRoom;
    private List<Service> requestedServices;
    private int stayDuration;

    public Customer2(String name) {
        this.name = name;
        this.requestedServices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(room bookedRoom) {
        if (!bookedRoom.isBooked()) {
            this.bookedRoom = bookedRoom;
            bookedRoom.setBooked(true);
        } else {
            System.out.println("Room is already booked!");
        }
    }

    public List<Service> getRequestedServices() {
        return requestedServices;
    }

    public void requestService(Service service) {
        requestedServices.add(service);
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(int stayDuration) {
        this.stayDuration = stayDuration;
    }

    public double totalCost() {
        
        double roomCost = 100_000 * stayDuration;
        System.out.println("Room Cost: " + stayDuration + " * 100_000 = " + roomCost);
    
        double serviceCost = 0;
        for (Service service : requestedServices) {
            serviceCost += service.getServiceCost();
            System.out.println("Service Cost: " + service.getServiceName() + " = " + service.getServiceCost());
        }
    

        double total = roomCost + serviceCost;
        System.out.println("Total Cost: " + roomCost + " + " + serviceCost + " = " + total);
        return total;
    }

    public double calculateTotalCost() {
        double roomCost = 100_000 * stayDuration;
        double serviceCost = 0;

        for (Service service : requestedServices) {
            serviceCost += service.getServiceCost();
        }

        return roomCost + serviceCost;
    }

    
    public void printDetailedCost() {
        double roomCost = 100_000 * stayDuration;
        System.out.println("Room Cost: " + stayDuration + " * 100_000 = " + roomCost);
        
        double serviceCost = 0;
        for (Service service : requestedServices) {
            serviceCost += service.getServiceCost();
            System.out.println("Service Cost: " + service.getServiceName() + " = " + service.getServiceCost());
        }
        
        double total = roomCost + serviceCost;
        System.out.println("Total Cost: " + roomCost + " + " + serviceCost + " = " + total);
        System.out.println();
    }

    public String info() {
        String info = "Customer: " + name + "\n";
        if (bookedRoom != null) {
            info += "Booked Room: " + bookedRoom.getRoomNumber() + "\n";
        }
        info += "Requested Services:\n";
        for (Service service : requestedServices) {
            info += service.info() + "\n";
        }
        info += "Total Stay Duration: " + stayDuration + " days\n";
        return info;
    }
    
}
