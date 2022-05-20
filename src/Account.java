public abstract class Account {
    String name;
    final double loanIntRate = 0.1;//taken loan's interest
    double deposit;//current balance
    double loan;
    int year;
    String type;

    public Account() {
        this.deposit = 0;
        this.loan = 0;
        this.year = 0;
    }

    public double getLoanIntRate() {
        return loanIntRate;
    }

    public Account(String name,String type, double deposit) {
        this.deposit = deposit;
        this.name = name;
        this.year = 0;
        this.loan = 0;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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


    //abstract ass all must have it
    public abstract void DepositMoney(double money);
    //not abstract as all doesn't have it
    public void WithdrawMoney(double money){
        if(this.getDeposit() - money >=0) {
            this.setDeposit(this.getDeposit() - money);
            //withdraw success msg
            System.out.println("withdraw " + money + "$; current balance " + this.deposit+"$");
        }else{
            System.out.println("Invalid transaction; current balance "+this.getDeposit()+"$");
        }
    }
    //same for all
    public void Query(){
        System.out.println("Current balance "+this.deposit+"$; Loan "+this.loan+"$");
    }
    //check validity for request loan
    public abstract boolean RequestLoanValidity(double amount);
}
