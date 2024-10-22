import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Random b = new Random();
        int[][] matrix = new int[5][5];   
        for (int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                matrix[i][j]=b.nextInt(100);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(b);
        }
    }
}
