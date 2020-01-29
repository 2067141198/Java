package DP;

import java.util.Scanner;

public class getCountSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int curSum = array[i];
            if (curSum > sum)
                continue;
            for (int j = i + 1; j < array.length; j++) {
                curSum += array[j];
                if (curSum >= sum) {
                    if (curSum == sum) {
                        count++;
                    }
                    curSum -= array[j];
                }
            }
        }
        System.out.println(count);
    }
}