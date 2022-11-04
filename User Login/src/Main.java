import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String u_name,password;

        System.out.print("Write User Name: ");
        u_name = scan.nextLine();

        System.out.print("Write Password: ");
        password = scan.nextLine();

        if(u_name.equals("java") && password.equals("5353"))
        {
            System.out.println("Your Login has successful");
        }
        else
        {
            System.out.println("Your login has not successful, Please try again!");
        }

    }
}