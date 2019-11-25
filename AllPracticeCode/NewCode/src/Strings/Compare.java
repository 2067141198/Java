package Strings;

import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = Integer.parseInt(sc.nextLine());
            if (m == 0)
                sc.close();
            String[] str = sc.nextLine().split(" ");
            String s = sc.nextLine();
            int count = 0;
            for (String ss : str) {
                if (ss.equals(s))
                    count++;
            }
            System.out.println(count);
            count = 0;
        }
    }
}
