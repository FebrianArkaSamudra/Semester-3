public class room {
    private int roomNumber;
    private boolean isBooked;

    public room (int roomNumber){
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public boolean isBooked(){
        return isBooked;
    }

    public void setBooked(boolean isBooked){
        this.isBooked = isBooked;
    }

    public String info(){
        return "Room Number: " + roomNumber + ", Is Booked: " + (isBooked ? "Yes" : "No");
    }
}
