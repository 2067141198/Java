package Strings;

import java.util.Scanner;

/**
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总
 * 的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可
 * 能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 * <p>
 * 输入描述：输入一个string型基因序列，和int型子串的长度
 * <p>
 * 输出描述：找出GC比例最高的子串,如果有多个输出第一个的子串
 */
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
