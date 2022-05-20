public class SavingAccount extends Account{
    final double maxLoan= 10000;
    double intRateOnDeposit = 0.1;
    double serviceCharge = 500;

    public SavingAccount(String name, double deposit) {
        super(name, deposit);
        this.successCreatedMsg("Savings");
    }


    public double getIntRateOnDeposit() {
        return intRateOnDeposit;
    }

    public void setIntRateOnDeposit(double intRateOnDeposit) {
        this.intRateOnDeposit = intRateOnDeposit;
    }

    public void DepositMoney(double money) {
        this.setDeposit(this.getDeposit()+ money);
        this.successDepositMsg("Savings",money);
    }

    @Override
    public void WithdrawMoney(double money) {
        if(this.getDeposit() - money >= 1000) {
            super.WithdrawMoney(money);
        }else{
            System.out.println("Invalid transaction; current balance "+this.getDeposit()+"$");
            return;
        }
    }

    @Override
    public boolean RequestLoanValidity(double amount) {
        if(amount <= this.maxLoan){
            return true;
        }else{
            return false;
        }

    }

    public void InterestOnDeposit() {
        this.setDeposit(this.getDeposit() + this.getDeposit() * this.intRateOnDeposit);
    }

    public void deducedForLoan() {
        this.setDeposit(this.getDeposit() - this.getLoan()*this.getLoanIntRate());
    }
}
