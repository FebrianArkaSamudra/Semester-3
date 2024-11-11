public class ElectricityBill implements IPayable{
    // Attribute 
    private int kwh;
    private String category;

    // Parametric Constructor ElectricityBill
    public ElectricityBill(int kwh, String category){
        this.kwh = kwh;
        this.category = category;
    }

    // Getter Kwh
    public int getKwh(){
        return kwh;
    }

    // Setter kwh 
    public void setKwh(int kwh){
        this.kwh = kwh;
    }

    // Getter Category
    public String getCategory(){
        return category;
    }

    // Setter Category 
    public void setCategory(String category){
        this.category = category;
    }

    // Method Get Base Price
    public int getBasePrice(){
        int bPrice = 0;
        switch(category){
            case "R-1" : bPrice = 100;break;
            case "R-2" : bPrice = 200;break;
        }
        return bPrice;
    }

    // Method Get Bill Info 
    public String getBillInfo(){
        return "KWH = " +kwh+"\n"+"Category = "+category+"("+getBasePrice()+"per KWH)\n";
    }

    // Implements Interface IPayable
    @Override
    public int getPaymentAmount() {
        return kwh*getBasePrice();
    }
}