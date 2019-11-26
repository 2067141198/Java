package Strings;

import java.util.Scanner;

public class DNASequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int n = sc.nextInt();
            String result = null;
            int resultSize = 0;
            //考虑特殊情况，当输入子串的长度等于输入字符串的长度时，结果直接是整个字符串
            if (str.length() == n)
                result = str;
            //根据子串的长度将字符串分割成不同的字串
            for (int i = 0; i < str.length() - n - 1; i++) {
                String s = str.substring(i, i + n);
                int count = 0;
                //然后遍历子串，记录子串中的'G'和'C'的个数
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == 'G' || s.charAt(j) == 'C')
                        count++;
                }
                //更新'G'和'C'的个数最多的子串为要输出的结果
                if (resultSize < count) {
                    resultSize = count;
                    result = s;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}
