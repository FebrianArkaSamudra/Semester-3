public class PermanentEmployee extends Employee implements IPayable {
    private int salary;

    // Parametric Constructor
    public PermanentEmployee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    // Getter Salary
    public int getSalary(){
        return salary;
    }

    // Setter Salary
    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public int getPaymentAmount() {
        return (int) (salary+0.05*salary);
    }

    @Override
    public String getEmployeeInfo() {
        String info =  super.getEmployeeInfo() + "\n";
        info += "Registered as permanent employee with salary " +salary+"\n";
        return info;
    }
}