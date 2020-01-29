package Maths;

import java.util.Scanner;

public class IsShouXingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s1 = String.valueOf(n);

            int tmp = n * n;
            String s2 = String.valueOf(tmp);
            String s = s2.substring(s2.length() - s1.length(), s2.length() - 1);
            if (s.equals(s1))
                System.out.println("Yes!");
            else
                System.out.println("No!");
        }
    }
}
