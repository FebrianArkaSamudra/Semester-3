public class TestKoperasi {
    public static void main(String[] args) {
       
        MemberTask donny = new MemberTask("111333444", "Donny", 5000000);

        System.out.println("Member name: " + donny.getName());
        System.out.println("Loan Limit: " + donny.getLoanLimit());

        System.out.println("\nBorrow money 4.000.000...");
        donny.borrow(4000000);
        System.out.println("Current loan amount: " + donny.getLoanAmount());

        System.out.println("\nPay installments 300.000 (less than 10%)");
        donny.installments(300000);
        System.out.println("Current loan amount: " + donny.getLoanAmount());

        System.out.println("\nPay installments 400.000 (10% or more)");
        donny.installments(400000);
        System.out.println("Current loan amount: " + donny.getLoanAmount());

        System.out.println("\nPay installments 5.000.000 (exceeds loan amount)");
        donny.installments(5000000);
        System.out.println("Current loan amount: " + donny.getLoanAmount());
    }
}
