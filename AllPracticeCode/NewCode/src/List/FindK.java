package List;

import java.util.Scanner;

public class FindK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (array[i] == m) {
                    flag = true;
                    System.out.println(i);
                }
            }
            if (!flag)
                System.out.println(-1);
        }
    }
}
