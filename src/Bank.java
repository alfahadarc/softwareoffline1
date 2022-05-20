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
            }

        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
        }


    }
    //find account
    private StudentAccount findInStudentAccount(String name){ //as name is primary
        if(this.allStudentsAccounts.con)
    }
    //deposit money
    public void depositMoney(String name, String type, double money) {
        if(type.equals("Fixed_deposit")){
            if(money >= 50000){
                //deposit it
            }else{
                System.out.println("For this account deposit amount must not be less than 50,000$");
            }

        }else{

        }

    }



}
