import java.util.Scanner;

public class Handler {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        String command;
        String name;
        String type;
        double amount;
        while(true){
            //search for first command
            command = scanner.next();
            if(command.equals("Create")){//name type amount
                name = scanner.next();
                type = scanner.next();
                amount = Double.parseDouble(scanner.next());
                //create account
                bank.openAccount(name, type, amount);
                while(!command.equals("Close")) {
                    command = scanner.next();//new commands
                    if(command.equals("Deposit")){
                        //deposit
                        amount  = Double.parseDouble(scanner.next());
                        bank.depositMoney(name, type, amount);

                    }else if(command.equals("Withdraw")){
                        //withdraw
                        amount  = Double.parseDouble(scanner.next());
                        bank.withdrawMoney(name, type, amount);
                    }else if(command.equals("Query")){
                        //query
                        bank.query(name,type);

                    }else if(command.equals("Request")){
                        //request loan
                        amount  = Double.parseDouble(scanner.next());
                        bank.requestLoan(name, type, amount);
                    }else if(command.equals("Close")){
                        //close
                        System.out.println("Transaction Closed for : " + name);
                    }else{
                        System.out.println("Command unrecognized");
                    }

                }
            }else if(command.equals("Open")){ //--------------------1st command
                name  = scanner.next(); //name of client //---------------------2nd part

                if(bank.isUser(name)){
                    System.out.println("Welcome back "+name);
                    type = bank.getTypeOfUser(name);
                    /*
                    ---------------same code
                     */
                    while(!command.equals("Close")) { //----------------command after open user

                        command = scanner.next();//new commands
                        if(command.equals("Deposit")){
                            //deposit
                            amount  = Double.parseDouble(scanner.next());
                            bank.depositMoney(name, type, amount);

                        }else if(command.equals("Withdraw")){
                            //withdraw
                            amount  = Double.parseDouble(scanner.next());
                            bank.withdrawMoney(name, type, amount);
                        }else if(command.equals("Query")){
                            //query
                            bank.query(name,type);

                        }else if(command.equals("Request")){
                            //request loan
                            amount  = Double.parseDouble(scanner.next());
                            bank.requestLoan(name, type, amount);
                        }else if(command.equals("Close")){
                            //close
                            System.out.println("Transaction Closed for : " + name);
                        }else{
                            System.out.println("Command unrecognized");
                        }

                    }

                    /*
                    ---------------same code
                     */

                }else if(bank.isEmployee(name)){
                    System.out.print(name+" active");
                    if(name.equals("MD") || name.equals("S1") || name.equals("S2")){
                        //check for pending loan
                        if(bank.chekForLoanRequest(name)){
                            System.out.println(", there are loan approvals pending");
                        }else{
                            System.out.println(", no loan approvals pending");
                        }
                    }else{
                        System.out.println();
                    }
                    //next command loop
                    while(!command.equals("Close")) { //----------------command after open user

                        command = scanner.next();//new commands
                        if(command.equals("Approve")){
                            //Loan approval
                            String loanCommand = scanner.next(); //to discard loan after approve command
                            bank.approveLoanRequest(name);

                        }else if(command.equals("Change")){
                            //change rate
                            type  = scanner.next();
                            amount = Double.parseDouble(scanner.next());
                            bank.changeInterestRate( type, name, amount);

                        }else if(command.equals("Lookup")){
                            //look up
                            String nameUser = scanner.next();
                            bank.lookUp(nameUser, name);

                        }else if(command.equals("See")){
                            //see internal fund
                            bank.seeFund(name);

                        }else if(command.equals("Close")){
                            //close
                            System.out.println("Operations for " + name + " closed " );
                        }else{
                            System.out.println("Command unrecognized");
                        }

                    }
                }
                else{
                    System.out.println("No user found");
                }

            }else if(command.equals("INC")){
                bank.increment1Year();
            }
            else if(command.equals("Stop")){
                return;
            }
            else{
                System.out.println("No valid command");
            }
        }
    }
}
