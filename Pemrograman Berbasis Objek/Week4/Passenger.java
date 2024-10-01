public class Passenger {
    private String identityCard;
    private String name;

    public Passenger(String identityCard, String name) {
        this.identityCard = identityCard;
        this.name = name;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String info() {
        String info = "";
        info += "Identity Card: " + identityCard + "\n";
        info += "Name: " + name + "\n";
        return info;
    }
}