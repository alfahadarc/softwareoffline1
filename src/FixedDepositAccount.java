public class FixedDepositAccount extends  Account{
    double firstDeposit =100000;
    double minimumDeposit = 50000;
    final int minMaturityPeriod = 1;
    double maxLoan = 100000;
    double intRateOnDeposit = 0.15;
    double serviceCharge = 500;

    public FixedDepositAccount(String name, double deposit) {
            super(name, deposit);
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
}
