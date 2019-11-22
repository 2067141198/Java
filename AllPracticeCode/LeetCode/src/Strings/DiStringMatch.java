package Strings;

public class DiStringMatch {
    /**
     * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
     * <p>
     * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
     * <p>
     * 如果 S[i] == "I"，那么 A[i] < A[i+1]
     * 如果 S[i] == "D"，那么 A[i] > A[i+1]
     *
     * @param S 输入的字符串
     * @return 返回符合条件的数组
     */
    public int[] diStringMatch(String S) {
        int[] result = new int[S.length() + 1];
        int min = 0;
        int max = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
        }
        result[S.length()] = max;
        return result;
    }
}
