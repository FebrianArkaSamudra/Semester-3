public class Rental {
    private int id;
    private String memberName;
    private String gameName;
    private int price;

    public void displayData() {
        System.out.println("transaction id : " + id);
        System.out.println("Member name : " + memberName);
        System.out.println("Game name   : " + gameName);
        System.out.println("Price  : " + price);
    }

    public int AmountPay(int rentDuration) {
        return rentDuration * price;
    }
}