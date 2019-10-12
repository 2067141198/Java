import java.util.Scanner;

public class minCountOfFibonacci {
    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int minCount(int n) {
        int tmp = 0;
        while(fibonacci(tmp) < n) {
            tmp++;
        }
        return Math.min(Math.abs(fibonacci(tmp - 1) - n), Math.abs(fibonacci(tmp) - n));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(minCount(s.nextInt()));
    }
}
