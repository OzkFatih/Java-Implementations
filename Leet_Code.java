import java.util.Scanner;

public class Leet_Code {
    public static void main(String[] args) {
        char[] english = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] leet = {'4','8','(','D','3','F','6','H','1','J','K','L','M','N','0','P','Q','R','5','7','U','V','W','X','Y','2'};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < english.length; j++) {
                if (str.charAt(i) == english[j]) {
                    result += leet[j];
                    break;
                }
            }
        }
        System.out.println("Leet Code: " + result);
    }
}
