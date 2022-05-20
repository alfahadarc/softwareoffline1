public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();


        bank.openAccount("Alice", "Student", 10000);
        bank.depositMoney("Alice", "Student", 1000);
//        bank.openAccount("Alice", "Loan", 10000);
//        bank.openAccount("A", "Savings", 10000);
//        bank.openAccount("e", "Fixed_deposit", 10000);
//        bank.openAccount("A", "Student", 10000);
    }
}
