package Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PassWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (checkLength(s) && checkCharKinds(s) && checkCharRepeat(s))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }

    private static boolean checkCharKinds(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                set.add(1);
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                set.add(2);
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                set.add(3);
            else
                set.add(4);
        }
        return set.size() >= 3;
    }

    private static boolean checkCharRepeat(String s) {
        int len = s.length();
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                if (s.substring(i, i + 2).equals(s.substring(j, j + 2)))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkLength(String s) {
        return s.length() > 8;
    }
}
