package DFS;

import java.util.ArrayList;
import java.util.List;

public class PhoneNum {
    private static void DFS(String digits, int index, String curStr, List<String> res) {
        String[] digitMaps = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (index == digits.length()) {
            res.add(curStr);
            return;
        }

        int num = digits.charAt(index) - '0' - 1;
        String digitMap = digitMaps[num];
        for (int i = 0; i < digitMap.length(); i++) {
            String newStr = curStr + digitMap.charAt(i);
            DFS(digits, index + 1, newStr, res);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        DFS(digits, 0, "", res);
        return res;
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
