import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        char op;
        Double a1, a2, result;


        Scanner input = new Scanner(System.in);

        System.out.println("Choose an operator: +, -, *, or /");
        op = input.next().charAt(0);


        System.out.println("Enter first number");
        a1 = input.nextDouble();

        System.out.println("Enter second number");
        a2 = input.nextDouble();

        switch (op) {


            case '+':
                result = a1 + a2;
                System.out.println(a1 + " + " + a2 + " = " + result);
                break;


            case '-':
                result = a1 - a2;
                System.out.println(a1 + " - " + a2 + " = " + result);
                break;


            case '*':
                result =a1 * a2;
                System.out.println(a1 + " * " + a2 + " = " + result);
                break;


            case '/':
                result = a1 / a2;
                System.out.println(a1 + " / " + a2 + " = " + result);
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }
}