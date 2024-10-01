import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<room> rooms;
    private List<Service> services;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public List<room> getRooms() {
        return rooms;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addRoom(room room) {
        rooms.add(room);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public String info() {
        String info = "Hotel: " + name + "\n";
        info += "Rooms:\n";
        if (rooms.isEmpty()) {
            info += "No rooms available\n";
        } else {
            for (room room : rooms) {
                info += room.info() + "\n";  
            }
        }

        info += "Services:\n";
        if (services.isEmpty()) {
            info += "No services available\n";
        } else {
            for (Service service : services) {
                info += service.info() + "\n";  
            }
        }

        return info;

    }
}
