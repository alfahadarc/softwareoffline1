import java.util.LinkedList;

public class Employee { //no need to extend
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    //for lookup
    public  void lookUp(String name, LinkedList<StudentAccount> allStudentsAccounts, LinkedList<SavingAccount> allSavingAccounts, LinkedList<FixedDepositAccount> allFixedDepositAccounts, LinkedList<LoanAccount> allLoanAccounts){
       // students

        for (StudentAccount st: allStudentsAccounts){
            if(st.getName().equals(name)){
                this.printAccountData(st.getName(), st.getDeposit());
                return;
            }
        }

        //savings
        for (SavingAccount st: allSavingAccounts){
            if(st.getName().equals(name)){
                this.printAccountData(st.getName(), st.getDeposit());
                return;
            }
        }
        //fixed
        for (FixedDepositAccount st: allFixedDepositAccounts){
            if(st.getName().equals(name)){
                this.printAccountData(st.getName(), st.getDeposit());
                return;
            }
        }
        //loan
        for (LoanAccount st: allLoanAccounts){
            if(st.getName().equals(name)){
                this.printAccountData(st.getName(), st.getDeposit());
                return;
            }
        }
    }

    private void printAccountData(String name, double money){
        System.out.println(name+"'s current balance "+money+" $");
    }

}
