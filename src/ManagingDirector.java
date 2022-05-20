import java.util.LinkedList;

public class ManagingDirector extends Employee{
    public ManagingDirector(String name) {
        super(name);
    }

    public void ApproveLoan(RequestLoanObj loanRequest, LinkedList<StudentAccount> allStudentsAccounts, LinkedList<SavingAccount> allSavingAccounts, LinkedList<FixedDepositAccount> allFixedDepositAccounts, LinkedList<LoanAccount> allLoanAccounts) {
        String type = loanRequest.getType();
        String name = loanRequest.getName();
        double money = loanRequest.getAmount();


        if(type.equals("Fixed_deposit")){
            for (FixedDepositAccount st: allFixedDepositAccounts){
                if(st.getName().equals(name)){
                    st.setLoan(st.getLoan()+ money);
                    System.out.println("Loan for "+name +" approved ");
                    return;
                }
            }
        }else if(type.equals("Savings")){
            for (SavingAccount st: allSavingAccounts){
                if(st.getName().equals(name)){
                    st.setLoan(st.getLoan()+ money);
                    System.out.println("Loan for "+name +" approved ");
                    return;
                }
            }
        }else if(type.equals("Loan")){
            for (LoanAccount st: allLoanAccounts){
                if(st.getName().equals(name)){
                    st.setLoan(st.getLoan()+ money);
                    System.out.println("Loan for "+name +" approved ");
                    return;
                }
            }
        }else if(type.equals("Student")){
            for (StudentAccount st: allStudentsAccounts){
                if(st.getName().equals(name)){
                    st.setLoan(st.getLoan()+ money);
                    System.out.println("Loan for "+name +" approved ");
                    return;
                }
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
        }

    }

    public void ChangeInterestRate(String accountType, double value, LinkedList<StudentAccount> allStudentsAccounts, LinkedList<SavingAccount> allSavingAccounts, LinkedList<FixedDepositAccount> allFixedDepositAccounts, LinkedList<LoanAccount> allLoanAccounts) {
        if(accountType.equals("Fixed_deposit")){
            for (FixedDepositAccount st: allFixedDepositAccounts){
                st.setIntRateOnDeposit(value);
            }
        }else if(accountType.equals("Savings")){
            for (SavingAccount st: allSavingAccounts){
                st.setIntRateOnDeposit(value);
            }
        }else if(accountType.equals("Loan")){
            System.out.println("No interest rate for this account");
        }else if(accountType.equals("Student")){
            for (StudentAccount st: allStudentsAccounts){
                st.setIntRateOnDeposit(value);
            }
        }else{
            System.out.println("Error!!unknown type(if Fixed deposit give Fixed_deposit)");
        }
    }

    public void SeeInternalFund(double initial_fund) {
        System.out.println("Internal fund of bank is "+ initial_fund+"$");
    }
}
