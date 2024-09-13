public class MemberTask {
  
    private String ktpNumber;
    private String name;
    private int loanLimit;
    private int loanAmount;


    public MemberTask(String ktpNumber, String name, int loanLimit) {
        this.ktpNumber = ktpNumber;
        this.name = name;
        this.loanLimit = loanLimit;
        this.loanAmount = 0; 
    }

    public String getName() {
        return name;
    }

    public int getLoanLimit() {
        return loanLimit;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void borrow(int amount) {
        if (loanAmount + amount <= loanLimit) {
            loanAmount += amount;
            System.out.println("Successfully borrowed " + amount);
        } else {
            System.out.println("Borrowing amount exceeds the loan limit!");
        }
    }

    public void installments(int amount) {
        int minimumInstallment = (int) (loanAmount * 0.1); 
        if (amount < minimumInstallment) {
            System.out.println("Sorry, installments must be at least 10% of the loan amount!");
        } else if (amount <= loanAmount) {
            loanAmount -= amount;
            System.out.println("Successfully paid " + amount);
        } else {
            System.out.println("Installment amount exceeds the current loan amount!");
        }
    }
}
