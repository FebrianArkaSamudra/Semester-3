public class InternshipEmployee extends Employee {
    //Attribute
    private int length;

    //InternshipEmployee Parametric Constructor 
    public InternshipEmployee(String name, int length){
        this.length = length;
        this.name = name; 
    }

    // Getter
    public int getLength(){
        return length;
    }

    // Setter
    public void setLength(int length){
        this.length = length;
    }

    @Override
    public String getEmployeeInfo() {
        String info =  super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " +length+" month/s\n";
        return info;
    }
}