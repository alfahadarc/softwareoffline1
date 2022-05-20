public abstract class Account {
    String name;
    final double loanIntRate = 0.1;//taken loan's interest
    double deposit;//current balance
    double loan;

    public Account() {
        this.deposit = 0;
        this.loan = 0;
    }

    public Account(String name,double deposit) {
        this.deposit = deposit;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }
    //account success created msg
    public void successCreatedMsg(String type){
        if(type.equals("Loan")){
            System.out.println(type +" account for "+ this.name + " Created; initial loan "+this.loan+"$");
        }else{
            System.out.println(type +" account for "+ this.name + " Created; initial balance "+this.deposit+"$");
        }
    }
    //deposit success msg
    public void successDepositMsg(String type, double amount){
        if(type.equals("Loan")){
            System.out.println(amount + "$ deposited; current loan "+this.getLoan()+"$");
        }else{
            System.out.println(amount + "$ deposited; current balance "+this.getDeposit() +"$");

        }
    }
    public abstract void DepositMoney(double money);
}
