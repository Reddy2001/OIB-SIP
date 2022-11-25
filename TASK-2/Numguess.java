import java.util.*;
class Estimate_num
{
    public void start()
    {
        Random r = new Random(); //usage of the random class for generating random numbers
        int val = r.nextInt(100); // for generating the pseudo random number from the computer
        System.out.println("Random Number generated\n");
        int x = 3;
        System.out.println("You have just " + x + " chances to guess the number\n");
        int prize = 100; //Used for correct guess
        int i = 0;
        for( i = 0; i < x; i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number you have guessed??? : \n");
            int l = sc.nextInt();
            if(l == val)
            {
                System.out.println("Wow! You won the game\n");
                System.out.println("Your score is " + prize);
                break;
            }
            else if(l > val)
            {
                if(l - val > 25)
                {
                    System.out.println("Your guess extremely High!!!\n");
                }
                else
                {
                    System.out.println("Your guess nearly high!!!\n");
                }
            }
            else
            {
                if(val - l > 25)
                {
                    System.out.println("Your guess is extremely low!!!\n");
                }
                else
                {
                    System.out.println("Your guess is nearly low!!!\n");
                }
            }
            prize = prize - 10; //decreasing reward for every wrong guess
        }
        if(i == x)
        {
            System.out.println("Sorry!!!You are unable to guess the number\n");
            System.out.println("The random number is " + val);
            prize = 0;
            System.out.println("Your reward is : " + prize);
        }
    }
}
public class Numguess {
    public static void main(String args[])
    {
        System.out.println("Welcome to the Number Guessing Game!!!\n");
        System.out.println("Enter your choice: 1.Play \n2.Exit \n");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 1)
        {
            Estimate_num g = new Estimate_num();
            g.start();
            System.out.println("Do you want to play again: Yes/No\n");
            String a = sc.next();
            while(a.equalsIgnoreCase("Yes"))
            {
                g.start();
                System.out.println("Do you want to play once again: Yes/No\n");
                a = sc.next();
            }
        }
        else {
            System.out.println("You are now exited!!!\n");
        }


    }
}
