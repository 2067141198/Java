package Maths;

import java.util.Scanner;

public class RMBTransition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] units1 = {"拾", "佰", "仟", "万", "亿"};
        String[] numCh = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] units2 = {"元", "角", "分"};
        char[] ch1 = new StringBuilder(str.substring(0, str.length() - 3)).reverse().toString().toCharArray();
        StringBuilder sb1 = new StringBuilder();
        sb1.append(units2[0]);
        for (int i = 0; i < ch1.length; i++) {
            int index = (i) % (units1.length - 1);
            sb1.append(numCh[ch1[i] - '0']);
            if (i != ch1.length - 1)
                sb1.append(units1[index]);
        }
        if (sb1.charAt(sb1.length() - 1) == '壹' && sb1.charAt(sb1.length() - 2) == '拾')
            sb1.deleteCharAt(sb1.length() - 1);


        char[] ch2 = str.substring(str.length() - 2).toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < ch2.length; i++) {
            sb2.append(numCh[ch2[i] - '0']);
            sb2.append(units2[i + 1]);
        }

        StringBuilder result = new StringBuilder();

        if (sb2.length() == 0 && sb1.length() != 0) {
            result.append("人民币").append(sb1.reverse()).append("整");
        } else if (sb1.length() == 0 && sb2.length() != 0) {
            result.append(sb2);
        } else {
            result.append("人民币").append(sb1.reverse()).append("整").append(sb2);
        }

        System.out.println(result.toString());
    }
}
