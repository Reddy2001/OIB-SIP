import java.util.*;
class Account
{
    String Name;
    String User_name;
    String Password;
    String Account;
    float balance = 0.0f;
    int transactions = 0;

    public Account(String m, String n, String o, String p) //parameterized constructor for registering the account of the customer
    {
        Name = m;
        User_name = n;
        Password = o;
        Account  = p;
        System.out.println("Account Created Successfully\n");
    }
    public boolean signin()
     {
         boolean isLogin = false;
         Scanner sc = new Scanner(System.in);
             System.out.print("\nEnter Your Username - ");
             String Username = sc.nextLine();
             if ( Username.equals(User_name) ) {
                     System.out.print("\nEnter Your Password - ");
                     String pass = sc.nextLine();
                     if ( pass.equals(pass) ) {
                         System.out.print("\n!!Logined successful!!");
                         isLogin = true;
                     }
                     else {
                         System.out.println("\n@Incorrect Password@");
                     }

             }
             else {
                 System.out.println("Username not found\n");

         }
         return isLogin;

    }
    public void deposit()
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter amount to deposit:\n");
        float money = sc.nextFloat();
        if(money <= 0.0)
        {
            System.out.println("Enter valid amount\n");
            transactions++;

        }
        else {
            balance = balance + money;
            System.out.println(money + " deposited successfully\n");
            transactions++;

        }


    }
    public void current_balance()
    {
        System.out.println("Your current balance is " + balance + " rupees only\n");
        transactions++;
    }
    public void transaction_history()
    {
        System.out.println("Transactions done in this session is " + transactions);
    }
    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the recepient name : \n");
        String receiver = sc.nextLine();
        System.out.println("Enter the amount to be transferred: \n");
        float transfer_amount = sc.nextFloat();
        if(transfer_amount > 0 && balance > transfer_amount) {
            System.out.println("Enter the Account Number of the recepient:\n");
            String receiver_acc = sc.next();
            balance = balance - transfer_amount;
            System.out.println("Amount " + transfer_amount + " transferred successfully");
            transactions++;
        }
        else
        {
            System.out.println("Your current balance is low or enter the valid amount\n");
            transactions++;
        }

    }
    public void withdrawl()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdrawl : \n");
        float withdraw = sc.nextFloat();
        if(withdraw >= balance)
        {
            System.out.println("Low Balance!!!" + "" + "\n");
        }
        else
        {
            System.out.println(withdraw + " withdrawn successfully\n");
            balance = balance - withdraw;
        }
    }


}

public class ATM_Interface {
    public static void main(String args[])
    {
        System.out.println("Welcome to the DDFC Bank!!!");
        boolean operation = false;

            System.out.println("Enter your choice: \n1.Banking \n2.Exit\n");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Enter your name:\n");
                String nam = sc.next();
                System.out.println("\n");
                System.out.println("Enter the user name:\n");
                String user_name = sc.next();
                System.out.println("Enter the password:\n");
                String pwd = sc.next();
                System.out.println("Enter your account number:\n");
                String acc = sc.next();
                Account a = new Account(nam, user_name, pwd, acc);
                System.out.println("Do you want to login: Yes/No\n");
                String want = sc.next();
                if (want.equalsIgnoreCase("Yes")) {
                    if (a.signin()) {
                        System.out.println("Please select the banking options\n");
                        boolean finished = false;
                        while (!finished) {
                            System.out.println("\n1.Deposit \n2.Withdrawl \n3. Bank Balance  \n4.Transactions Done \n 5.Transfer \n");
                            int opt = sc.nextInt();
                            switch (opt) {
                                case 1:
                                    a.deposit();
                                    break;
                                case 2:
                                    a.withdrawl();
                                    break;
                                case 3:
                                    a.current_balance();
                                    break;
                                case 4:
                                    a.transaction_history();
                                    break;
                                case 5:
                                    a.transfer();
                                    break;
                                default:
                                    finished = true;
                                    operation = true;
                                    break;

                            }
                        }
                    }

                } else {
                    System.out.println("Thank You! and Have a nice day!!!\n");
                }

            } else {
                System.out.println("Thank You! Have a nice day\n");
            }
      
    }
}
