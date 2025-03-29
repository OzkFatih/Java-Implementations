import java.util.Scanner;

public class Min_Max_Value {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        Min_Max_Value mv = new Min_Max_Value();
        int min = mv.Find_Min_Value(A);
        int max = mv.Find_Max_Value(A);
        System.out.println("Min Value: " + min);
        System.out.println("Max Value: " + max);
	}
    
	public int Find_Min_Value(int[] A) {
		int ans = A[0];
        int n = A.length;
        for (int i = 0;i < n; i++){
            if (A[i] < ans){
                ans = A[i];
            }
        }
        return ans;
	}
    public int Find_Max_Value(int[] A) {
        int ans = A[0];
        int n = A.length;
        for (int i = 0;i < n; i++){
            if (A[i] > ans){
                ans = A[i];
            }
        }
        return ans;
    }
}