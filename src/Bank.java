import java.util.LinkedList;

public class Bank {
    LinkedList<String> usersName;
    LinkedList<SavingAccount> allSavingAccounts;
    LinkedList<StudentAccount> allStudentsAccounts;
    LinkedList<FixedDepositAccount> allFixedDepositAccounts;
    LinkedList<LoanAccount> allLoanAccounts;

    public Bank() {
        this.usersName = new LinkedList<>();
        this.allStudentsAccounts = new LinkedList<>();
        this.allFixedDepositAccounts = new LinkedList<>();
        this.allLoanAccounts = new LinkedList<>();
        this.allSavingAccounts = new LinkedList<>();
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
            System.out.println("Can not withdraw in this account");
            return;
        }else if(type.equals("Student")){
            StudentAccount studentAccount = findInStudentAccount(name);
            if(studentAccount != null){
                //studentAccount.DepositMoney(money);
                studentAccount.WithdrawMoney(money);
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
            return;
        }
    }

}
