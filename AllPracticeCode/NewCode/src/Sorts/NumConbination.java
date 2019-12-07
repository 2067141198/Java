package Sorts;

import java.util.Scanner;
import java.util.Stack;

public class NumConbination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            //待进站的车
            Stack<Integer> waitStack1 = new Stack<>();
            for (int i = array.length - 1; i >= 0; i--) {
                waitStack1.push(array[i]);
            }
            //待出站的车
            Stack<Integer> waitStack2 = new Stack<>();
            //出站的车
            Stack<Integer> outStack = new Stack<>();
        }
    }
}
