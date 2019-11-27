package Strings;

/**
 * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素
 * 代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的个数小于等于500，
 * 同时保证s的长度小于等于1000。
 */
public class ChildString {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            result[i] = s.contains(p[i]);
        }
        return result;
    }
}
