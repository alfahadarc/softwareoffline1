public class LoanAccount extends Account{
    double initialLoan;

    //max loan is 5% of first
    public LoanAccount(String name, double deposit) {
        super(name, 0);
        this.setLoan(deposit);
        this.initialLoan = deposit;
        this.successCreatedMsg("Loan");
    }
    //different from others as loan decrease
    public void DepositMoney(double money) {
        if(this.getLoan() - money >= 0) {
            this.setLoan(this.getLoan() - money);
            this.successDepositMsg("Loan",money);
        }else {
            System.out.println("Deposit amount is greater then loan");
        }
    }
    @Override
    public boolean RequestLoanValidity(double amount) {
        double maxLoan = this.getLoan() * 0.05;
        if(amount <= maxLoan){
            return true;
        }else{
            return false;
        }

    }
}
