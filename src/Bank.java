import java.util.LinkedList;

public class Bank {
    final double initial_fund = 1000000;
    private LinkedList<String> usersName;
    private LinkedList<SavingAccount> allSavingAccounts;
    private LinkedList<StudentAccount> allStudentsAccounts;
    private LinkedList<FixedDepositAccount> allFixedDepositAccounts;
    private LinkedList<LoanAccount> allLoanAccounts;
    private LinkedList<RequestLoanObj> pendingLoans;
    private LinkedList<String> employees;

    //employees
    ManagingDirector MD;
    Officer S1 ;
    Officer S2;
    Cashier C1 ;
    Cashier C2 ;
    Cashier C3 ;
    Cashier C4 ;
    Cashier C5 ;

    public Bank() {
        this.usersName = new LinkedList<>();
        this.allStudentsAccounts = new LinkedList<>();
        this.allFixedDepositAccounts = new LinkedList<>();
        this.allLoanAccounts = new LinkedList<>();
        this.allSavingAccounts = new LinkedList<>();
        this.pendingLoans = new LinkedList<>();
        this.employees = new LinkedList<>();



        //create employee
         MD = new ManagingDirector("MD");
        this.employees.add("MD");
         S1 = new Officer("S1");
        this.employees.add("S1");
        S2 = new Officer("S2");
        this.employees.add("S2");
         C1 = new Cashier("C1");
        this.employees.add("C1");
         C2 = new Cashier("C2");
        this.employees.add("C2");
         C3 = new Cashier("C3");
        this.employees.add("C3");
         C4 = new Cashier("C4");
        this.employees.add("C4");
         C5 = new Cashier("C5");
        this.employees.add("C5");

        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
    }

    public double getInitial_fund() {
        return initial_fund;
    }

    public LinkedList<String> getUsersName() {
        return usersName;
    }

    public LinkedList<SavingAccount> getAllSavingAccounts() {
        return allSavingAccounts;
    }

    public LinkedList<StudentAccount> getAllStudentsAccounts() {
        return allStudentsAccounts;
    }

    public LinkedList<FixedDepositAccount> getAllFixedDepositAccounts() {
        return allFixedDepositAccounts;
    }

    public LinkedList<LoanAccount> getAllLoanAccounts() {
        return allLoanAccounts;
    }

    public LinkedList<RequestLoanObj> getPendingLoans() {
        return pendingLoans;
    }

    //create account
    void openAccount(String name, String type, double deposit){

        if(this.usersName.contains(name)){
            System.out.println("Error!! User with this name exists");
            return;
        }else{
            this.usersName.add(name);//save the name
            //System.out.println(this.usersName.getFirst());
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

    //for lookup
    public void lookUp(String name, String employee){
        if(!this.usersName.contains(name)){
            System.out.println("No user with this name");
            return;
        }else{
            if(this.employees.contains(employee)) {
                if(employee.equals("MD")) {
                    this.MD.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("S1")){
                    this.S1.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("S2")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("C1")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("C2")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("C3")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("C4")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }else if(employee.equals("C5")){
                    this.S2.lookUp(name, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
                }
            }else{
                System.out.println("Not an employee");
            }
        }

    }


    //for loan approval
    public boolean chekForLoanRequest(String employeeType) {
        if(employeeType.equals("MD") || employeeType.equals("S1") || employeeType.equals("S2")){
            if(this.pendingLoans.size() !=0){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("You don’t have permission for this operation");
            return false;
        }
    }

    public void approveLoanRequest(String employeeType) {
        if(employeeType.equals("MD") || employeeType.equals("S1") || employeeType.equals("S2")){
           RequestLoanObj loanRequest = this.getPendingLoans().pollLast(); //pending list empty
           //set user loan; first find the user
            if(employeeType.equals("MD")){
                this.MD.ApproveLoan(loanRequest, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
            }else if(employeeType.equals("S1")){
                this.S1.ApproveLoan(loanRequest, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
            }else {
                this.S2.ApproveLoan(loanRequest, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
            }

        }else{
            System.out.println("You don’t have permission for this operation");

        }
    }


    public void changeInterestRate(String accountType, String employeeType, double value) {
        if(employeeType.equals("MD")){
            this.MD.ChangeInterestRate(accountType, value, this.allStudentsAccounts, this.allSavingAccounts, this.allFixedDepositAccounts, this.allLoanAccounts);
        }else{
            System.out.println("You don’t have permission for this operation");

        }
    }
    //see changed rate
    public void seeInterestRateOnDeposit(String type){
        if(type.equals("Student")){
            for(StudentAccount st: this.allStudentsAccounts){
                System.out.println("student accounts int rate "+st.getIntRateOnDeposit());
            }
        }else if(type.equals("Savings")){
            for(SavingAccount st: this.allSavingAccounts){
                System.out.println("savings accounts int rate "+st.getIntRateOnDeposit());
            }
        }else if(type.equals("Fixed_deposit")){
            for(FixedDepositAccount st: this.allFixedDepositAccounts){
                System.out.println("fixed accounts int rate "+st.getIntRateOnDeposit());
            }
        }
    }

    //see internal fund
    public void seeFund(String employeeType) {
        if(employeeType.equals("MD")){
            this.MD.SeeInternalFund(this.initial_fund);
        }else{
            System.out.println("You don’t have permission for this operation");

        }
    }


    /*
    -----------------------------------------------------------------------------------------------
    increment 1 year
    -----------------------------------------------------------------------------------------------

     */
    public void increment1Year() {
        for(StudentAccount st: this.allStudentsAccounts){
            st.setYear(st.getYear()+1);
            //Interest rates on deposit
            st.InterestOnDeposit();
            //deduce service charge
            st.setDeposit(st.getDeposit() - 500);
            //deduce for loan if exists
            if(st.getLoan() != 0){
                st.deducedForLoan();
            }
        }
        for(SavingAccount st:this.allSavingAccounts){
            st.setYear(st.getYear()+1);
            //Interest rates on deposit
            st.InterestOnDeposit();
            //deduce service charge
            st.setDeposit(st.getDeposit() - 500);
            //deduce for loan if exists
            if(st.getLoan() != 0){
                st.deducedForLoan();
            }

        }
        for(FixedDepositAccount st: this.allFixedDepositAccounts){
            st.setYear(st.getYear()+1);
            //Interest rates on deposit
            st.InterestOnDeposit();
            //deduce service charge
            st.setDeposit(st.getDeposit() - 500);
            //deduce for loan if exists
            if(st.getLoan() != 0){
                st.deducedForLoan();
            }
        }
        for(LoanAccount st: this.allLoanAccounts){
            st.setYear(st.getYear()+1);
            //no service charge
        }
        System.out.println("1 year passed");
    }
}
