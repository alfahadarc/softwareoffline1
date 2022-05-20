public class StudentAccount extends Account{
    final double maxWithdraw = 10000;
    final double maxLoan = 1000;
    double intRateOnDeposit = 0.05;
    final double serviceCharge = 500;


    public StudentAccount(String name, double deposit) {
        super(name,deposit);
        //successful msg
        this.successCreatedMsg("Student");
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
}
