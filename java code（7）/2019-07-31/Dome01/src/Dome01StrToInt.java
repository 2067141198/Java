import java.util.Arrays;
import java.lang.Integer;

import static java.lang.Character.MAX_VALUE;
import static java.lang.Character.MIN_VALUE;

public class Dome01StrToInt {
    public static int StrToInt(String str) {
        String s = str;
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));

        int[] num = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] > '9' || ch[i] < '0')
                return 0;
            num[i] = ch[i] - '0';
        }

        int stringNum = 0;
        for (int i = 0; i < num.length; i++) {
            stringNum = stringNum * 10 + num[i];
        }

        int max = MAX_VALUE;
        int min = MIN_VALUE;
        System.out.println(max);
        System.out.println(min);
        if(stringNum > max) {
            return max;
        } else if (stringNum < min) {
            return min;
        } else {
            return stringNum;
        }
    }

    public static void main(String[] args) {
        int i = StrToInt("2147483647");
        System.out.println(i);
    }
}
