public class Tester3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "A-1");
        // The Class implement Employee
        Employee e[] = {pEmp, iEmp};
        // The Class implement Interface IPayable
        IPayable p[] = {pEmp, eBill};
        // It Occur error because Electricity Bill doesn't implement or use the employee class
        Employee e2[] = {pEmp, iEmp, eBill};
    }
}