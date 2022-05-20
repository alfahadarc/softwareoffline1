import java.util.LinkedList;

public class Bank {
    LinkedList<String> usersName;
    LinkedList<SavingAccount> allSavingAccounts;
    LinkedList<StudentAccount> allStudentsAccounts;
    LinkedList<FixedDepositAccount> allFixedDepositAccounts;
    LinkedList<LoanAccount> allLoanAccounts;
    LinkedList<RequestLoanObj> pendingLoans;

    public Bank() {
        this.usersName = new LinkedList<>();
        this.allStudentsAccounts = new LinkedList<>();
        this.allFixedDepositAccounts = new LinkedList<>();
        this.allLoanAccounts = new LinkedList<>();
        this.allSavingAccounts = new LinkedList<>();
        this.pendingLoans = new LinkedList<>();
    }

    //create account
    void openAccount(String name, String type, double deposit){

        if(this.usersName.contains(name)){
            System.out.println("Error!! User with this name exists");
            return;
        }else{
            this.usersName.add(name);//save the name
        }

        //type checking
        if(type.equals("Student")){
            StudentAccount newAccount = new StudentAccount(name, deposit);
            this.allStudentsAccounts.add(newAccount);

        }else if(type.equals("Loan")){
            LoanAccount newAccount = new LoanAccount(name , deposit);
            this.allLoanAccounts.add(newAccount);

        }else if(type.equals("Savings")){
            SavingAccount newAccount = new SavingAccount(name, deposit);
            this.allSavingAccounts.add(newAccount);
        }else if(type.equals("Fixed_deposit")){
            if(deposit >= 100000){
                FixedDepositAccount newAccount = new FixedDepositAccount(name , deposit);
                this.allFixedDepositAccounts.add(newAccount);
            }else{
                System.out.println("For this account first deposit must not be less than 100,000$");
                return;
            }

        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
        }


    }
    //find account
    private StudentAccount findInStudentAccount(String name){ //as name is primary
        for(StudentAccount st : allStudentsAccounts){
            if(st.getName().equals(name)){
                return st;
            }
        }
        return null;
    }
    private SavingAccount findInSavingAccount(String name){ //as name is primary
        for(SavingAccount account : allSavingAccounts){
            if(account.getName().equals(name)){
                return account;
            }
        }
        return null;
    }
    private FixedDepositAccount findInFixedDepositAccount(String name){
        for(FixedDepositAccount account: allFixedDepositAccounts){
            if(account.getName().equals(name)){
                return account;
            }
        }
        return null;
    }
    private LoanAccount findInLoanAccount(String name){
        for(LoanAccount account: allLoanAccounts){
            if(account.getName().equals(name)){
                return account;
            }
        }
        return null;
    }
    //deposit money
    public void depositMoney(String name, String type, double money) {
        if(type.equals("Fixed_deposit")){
            FixedDepositAccount fixedDepositAccount = findInFixedDepositAccount(name);
            if(fixedDepositAccount != null){
                if(money >= 50000){
                    //deposit it
                    fixedDepositAccount.DepositMoney(money);
                }else{
                    System.out.println("For this account deposit amount must not be less than 50,000$");
                    return;
                }

            }


        }else if(type.equals("Savings")){
            SavingAccount savingAccount = findInSavingAccount(name);
            if(savingAccount != null){
                savingAccount.DepositMoney(money);
            }
        }else if(type.equals("Loan")){
            LoanAccount loanAccount  = findInLoanAccount(name);
            if(loanAccount != null){
                loanAccount.DepositMoney(money);
            }
        }else if(type.equals("Student")){
            StudentAccount studentAccount = findInStudentAccount(name);
            if(studentAccount != null){
                studentAccount.DepositMoney(money);
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
            return;
        }

    }

    //withdraw money
    public void withdrawMoney(String name, String type, double money) {
        if(type.equals("Fixed_deposit")){
            FixedDepositAccount fixedDepositAccount = findInFixedDepositAccount(name);
            if(fixedDepositAccount != null){
                fixedDepositAccount.WithdrawMoney(money);
            }

        }else if(type.equals("Savings")){
            SavingAccount savingAccount = findInSavingAccount(name);
            if(savingAccount != null){
                savingAccount.WithdrawMoney(money);
            }
        }else if(type.equals("Loan")){
            LoanAccount loanAccount  = findInLoanAccount(name);
            if(loanAccount != null){
                System.out.println("Can not withdraw in this account");
                return;
            }


        }else if(type.equals("Student")){
            StudentAccount studentAccount = findInStudentAccount(name);
            if(studentAccount != null){
                studentAccount.WithdrawMoney(money);
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
            return;
        }
    }

    //query loan and deposit
    public void query(String name, String type){
        if(type.equals("Fixed_deposit")){
            FixedDepositAccount fixedDepositAccount = findInFixedDepositAccount(name);
            if(fixedDepositAccount != null){
                fixedDepositAccount.Query();
            }
        }else if(type.equals("Savings")){
            SavingAccount savingAccount = findInSavingAccount(name);
            if(savingAccount != null){
                savingAccount.Query();
            }
        }else if(type.equals("Loan")){
            LoanAccount loanAccount  = findInLoanAccount(name);
            if(loanAccount != null){
                loanAccount.Query();
            }
        }else if(type.equals("Student")){
            StudentAccount studentAccount = findInStudentAccount(name);
            if(studentAccount != null){
                studentAccount.Query();
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
            return;
        }
    }

    public void requestLoan(String name, String type, double amount) {
        //check validity
        //msg is shown if request is not accepted
        if(type.equals("Fixed_deposit")){
            FixedDepositAccount fixedDepositAccount = findInFixedDepositAccount(name);
            if(fixedDepositAccount != null && fixedDepositAccount.RequestLoanValidity(amount)){
                this.createRequestLoan(name, type, amount, false);
            }
            if(fixedDepositAccount != null && !fixedDepositAccount.RequestLoanValidity(amount)) {
                this.unsuccessfulRequestLoanMsg();
            }
        }else if(type.equals("Savings")){
            SavingAccount savingAccount = findInSavingAccount(name);
            if(savingAccount != null && savingAccount.RequestLoanValidity(amount)){
                this.createRequestLoan(name,type, amount,false);
            }
            if(savingAccount != null && !savingAccount.RequestLoanValidity(amount)) {
                this.unsuccessfulRequestLoanMsg();
            }
        }else if(type.equals("Loan")){
            LoanAccount loanAccount  = findInLoanAccount(name);
            if(loanAccount != null && loanAccount.RequestLoanValidity(amount)){
                this.createRequestLoan(name,type, amount,false);
            }
            if(loanAccount != null && !loanAccount.RequestLoanValidity(amount)) {
                this.unsuccessfulRequestLoanMsg();
            }
        }else if(type.equals("Student")){
            StudentAccount studentAccount = findInStudentAccount(name);
            if(studentAccount != null && studentAccount.RequestLoanValidity(amount)){
                this.createRequestLoan(name,type, amount,false);
            }
            if(studentAccount != null &&  !studentAccount.RequestLoanValidity(amount)) {
                this.unsuccessfulRequestLoanMsg();
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
            return;
        }

    }

    //create approval request list
    private void createRequestLoan(String name, String type, double amount, boolean status){
        RequestLoanObj requestLoanObj = new RequestLoanObj(name, type, amount, status);
        this.pendingLoans.add(requestLoanObj);
        System.out.println("Loan request successful, sent for approval");
    }
    //msg
    private void unsuccessfulRequestLoanMsg(){
            System.out.println("Loan amount can not be granted");
        }
    //printing all pending loan request
    public void printPendingLoanRequest(){
        System.out.println();
        for(RequestLoanObj r: pendingLoans){
            System.out.println(r.getName()+" "+r.getType()+" "+r.getAmount()+" "+r.isStatus());
        }
    }
    /*
    ------------------------------------------------------------------------------------------------
    Employee codes start here
    ------------------------------------------------------------------------------------------------
     */
}
