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
}
