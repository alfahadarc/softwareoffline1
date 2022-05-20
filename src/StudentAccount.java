public class StudentAccount extends Account{
    final double maxWithdraw = 10000;
    final double maxLoan = 1000;
    double intRateOnDeposit = 0.05;
    final double serviceCharge = 500;


    public StudentAccount(String name,String type, double deposit) {
        super(name,type,deposit);
        //successful msg
        this.successCreatedMsg("Student");
    }

    public double getIntRateOnDeposit() {
        return intRateOnDeposit;
    }

    public void setIntRateOnDeposit(double intRateOnDeposit) {
        this.intRateOnDeposit = intRateOnDeposit;
    }

    //not first time deposit
    public void DepositMoney(double money) {
        this.setDeposit(this.getDeposit()+ money);
        this.successDepositMsg("Student",money);
    }

    @Override
    public void WithdrawMoney(double money) {
        if(money<= 10000) {
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
