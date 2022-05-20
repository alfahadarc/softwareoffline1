public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();


        //bank.openAccount("Alice", "Student", 10000);
        //bank.depositMoney("Alice", "Student", 1000);
        //bank.withdrawMoney("Alice", "Student", 10000);
        //bank.withdrawMoney("Alice", "Student", 9000);

       //bank.openAccount("Alice", "Loan", 10000);
       //bank.depositMoney("Alice", "Loan", 11500);
        //bank.withdrawMoney("Alice", "Loan", 9000);

        bank.openAccount("A", "Savings", 10000);
        bank.depositMoney("A", "Savings", 10000);
        bank.withdrawMoney("A", "Savings", 10000);
        bank.withdrawMoney("A", "Savings", 9000);
        bank.withdrawMoney("A", "Savings", 1000);

//        bank.openAccount("e", "Fixed_deposit", 100000); //check after inc year
//        bank.depositMoney("e", "Fixed_deposit", 50000);
//        bank.withdrawMoney("e", "Fixed_deposit", 50000);

        //bank.openAccount("Alice", "Student", 10000);
        //bank.depositMoney("Alice", "Student", 1000);

    }
}
