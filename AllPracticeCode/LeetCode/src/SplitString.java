public class SplitString {
    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     *
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     *
     * 返回可以通过分割得到的平衡字符串的最大数量。
     *
     * @param s 被分割的字符串
     * @return 返回分割后都是平衡字符串的数量
     */
    public static int balancedStringSplit(String s) {
        char ch = s.charAt(0);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) {
                sum++;
            } else {
                sum--;
            }

            if(sum ==  0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "LLLRLLRRLRRR";
        System.out.println(balancedStringSplit(s));
    }
}
