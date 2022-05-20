public class SavingAccount extends Account{
    double maxLoan= 10000;
    double intRateOnDeposit = 0.1;
    double serviceCharge = 500;

    public SavingAccount(String name, double deposit) {
        super(name, deposit);
        this.successCreatedMsg("Savings");
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
}
