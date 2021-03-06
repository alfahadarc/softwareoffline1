public class FixedDepositAccount extends  Account{
    double firstDeposit =100000;
    double minimumDeposit = 50000;
    final int minMaturityPeriod = 1;
    final double maxLoan = 100000;
    double intRateOnDeposit = 0.15;
    double serviceCharge = 500;

    public double getIntRateOnDeposit() {
        return intRateOnDeposit;
    }

    public void setIntRateOnDeposit(double intRateOnDeposit) {
        this.intRateOnDeposit = intRateOnDeposit;
    }

    public FixedDepositAccount(String name,String type, double deposit) {
            super(name,type, deposit);
            this.successCreatedMsg("Fixed_deposit");
    }
    public void DepositMoney(double money) {
        this.setDeposit(this.getDeposit()+ money);
        this.successDepositMsg("Fixed_deposit",money);
    }

    @Override
    public void WithdrawMoney(double money) {
        if(this.getYear()>= this.minMaturityPeriod) {
            super.WithdrawMoney(money);
        }else{
            System.out.println("Invalid transaction maturity is not enough");
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
