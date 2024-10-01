import java.util.Scanner;

public class TestKoperasi {
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);

        MemberTask donny = new MemberTask("111333444", "Donny", 5000000);

        System.out.println("Member name: " + donny.getName());
        System.out.println("Loan Limit: " + donny.getLoanLimit());

        System.out.print("\nEnter amount to borrow: ");
        int borrowAmount = scanner.nextInt();
        donny.borrow(borrowAmount);
        System.out.println("Current loan amount: " + donny.getLoanAmount());

        System.out.print("\nEnter installment amount to pay: ");
        int installmentAmount = scanner.nextInt();
        donny.installments(installmentAmount);
        System.out.println("Current loan amount: " + donny.getLoanAmount());

        while (true) {
            System.out.println("\nDo you want to (1) Borrow or (2) Pay Installment or (3) Exit?");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter amount to borrow: ");
                borrowAmount = scanner.nextInt();
                donny.borrow(borrowAmount);
                System.out.println("Current loan amount: " + donny.getLoanAmount());
            } else if (choice == 2) {
                System.out.print("Enter installment amount to pay: ");
                installmentAmount = scanner.nextInt();
                donny.installments(installmentAmount);
                System.out.println("Current loan amount: " + donny.getLoanAmount());
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
