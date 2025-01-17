import java.util.Scanner;

public class factorial {
    public static int factorial(int n) {
        try {    
            if (n == 0) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow Error");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }
}
