public class Demo {
    public static void main(String[] args) {
        Member member1 = new Member();
        member1.setName("iwan");
        member1.setAddress("malang");
        member1.deposit(1000000);
        System.out.println("Deposito " + member1.getName() + "Rp. " + member1.getDeposit());

        member1.loan(500000);
        System.out.println("Deposito " + member1.getName() + "Rp. " + member1.getDeposit());
    }
}
