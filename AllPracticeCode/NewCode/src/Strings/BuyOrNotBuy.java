package Strings;

import java.util.Scanner;

public class BuyOrNotBuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            char[] str = s2.toCharArray();

            for (int i = 0; i < str.length; i++) {
                if (s1.indexOf(str[i]) != -1) {
                    s1 = s1.replaceFirst(String.valueOf(str[i]), "");
                    str[i] = '@';
                }
            }

            int count = 0;
            for (char ch : str) {
                if (ch != '@')
                    count++;
            }

            if (count == 0) {
                System.out.println("Yes" + " " + s1.length());
            } else {
                System.out.println("No" + " " + count);
            }
        }
        sc.close();
    }
}
