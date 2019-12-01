package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberCategory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> list3 = new ArrayList<>();
            ArrayList<Integer> list4 = new ArrayList<>();
            ArrayList<Integer> list5 = new ArrayList<>();

            for (int n : array) {
                int mod = n % 5;
                if (mod == 0 && (n % 2) == 0)
                    list1.add(n);
                switch (mod) {
                    case 1:
                        list2.add(n);
                        break;
                    case 2:
                        list3.add(n);
                        break;
                    case 3:
                        list4.add(n);
                        break;
                    case 4:
                        list5.add(n);
                        break;
                    default:
                        break;
                }
            }
            int A1 = 0;
            for (int i : list1) {
                A1 += i;
            }
            if (list1.size() == 0)
                System.out.print("N ");
            else
                System.out.print(A1 + " ");

            int A2 = 0;
            for (int i = 0; i < list2.size(); i++) {
                if (i % 2 == 0)
                    A2 += list2.get(i);
                else
                    A2 -= list2.get(i);
            }
            if (list2.size() == 0)
                System.out.print("N ");
            else
                System.out.print(A2 + " ");

            int A3 = list3.size();
            if (list3.size() == 0)
                System.out.print("N ");
            else
                System.out.print(A3 + " ");

            int sum = 0;
            for (int i : list4) {
                sum += i;
            }
            double A4 = sum * 1.0 / list4.size();
            if (list4.size() == 0)
                System.out.print("N ");
            else
                System.out.printf("%.1f" + " ", A4);

            int A5 = 0;
            for (int i : list5) {
                if (A5 < i)
                    A5 = i;
            }
            if (list5.size() == 0)
                System.out.println("N ");
            else
                System.out.println(A5);

            //System.out.println(A1 + " " + A2 + " " + A3 + " " + A4 + " " + A5);
        }
        sc.close();
    }
}
