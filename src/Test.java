public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();


        bank.openAccount("Alice", "Student", 10000);
        bank.requestLoan("Alice", "Student", 1000);

        bank.openAccount("dunk", "Loan", 10000);
//        bank.requestLoan("dunk", "Loan", 475);
//
        bank.openAccount("A", "Savings", 10000);
//        bank.requestLoan("A", "Savings", 10000);

        bank.openAccount("e", "Fixed_deposit", 100000);
//        bank.requestLoan("e", "Fixed_deposit", 500);

//        bank.openAccount("dunk", "Loan", 10000);
//        bank.depositMoney("dunk", "Loan", 500);
//        bank.withdrawMoney("dunk", "Loan", 9000);
//        bank.lookUp("Alice", "MD");
//        bank.lookUp("dunk", "C2");
//        bank.lookUp("Alice", "S1");


//        System.out.println( bank.chekForLoanRequest("MD"));
//        System.out.println(bank.chekForLoanRequest("S1"));
//        System.out.println(bank.chekForLoanRequest("C2"));


//        bank.query("e", "Fixed_deposit");
//
        if(bank.chekForLoanRequest("S1")){
            bank.approveLoanRequest("S1");
        }
//        bank.query("e", "Fixed_deposit");


//        System.out.println();
//        bank.seeInterestRateOnDeposit("Student");
//        bank.seeInterestRateOnDeposit("Savings");
//        bank.seeInterestRateOnDeposit("Fixed_deposit");
//
//        bank.changeInterestRate( "Savings", "MD", 7.50);
//        bank.changeInterestRate( "Student", "MD", 7.50);
//        bank.changeInterestRate( "Fixed_deposit", "MD", 7.50);
//        System.out.println();
//
//       bank.seeInterestRateOnDeposit("Student");
//        bank.seeInterestRateOnDeposit("Savings");
//       bank.seeInterestRateOnDeposit("Fixed_deposit");

        //bank.seeFund("MD");


//        bank.openAccount("e", "Fixed_deposit", 100000);
//        bank.withdrawMoney("e", "Fixed_deposit", 50000);
//        bank.query("e", "Fixed_deposit");
        System.out.println();
        bank.query("Alice", "Student");
//        bank.query("dunk", "Loan");
//        bank.query("A", "Savings");
//        bank.query("e", "Fixed_deposit");

        //bank.changeInterestRate( "Student", "MD", 7.50);
        bank.increment1Year();

//        bank.withdrawMoney("e", "Fixed_deposit", 50000);
//        bank.query("e", "Fixed_deposit");

        System.out.println();
        bank.query("Alice", "Student");
//        bank.query("dunk", "Loan");
//        bank.query("A", "Savings");
//        bank.query("e", "Fixed_deposit");

    }
}
