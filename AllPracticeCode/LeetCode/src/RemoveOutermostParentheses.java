import java.util.*;

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String S) {
        //创建一个一个list保存分割开的字符串
        List<String> list = new ArrayList<>();
        //用栈来实现将字符串分割开
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        stack.push(ch[0]);
        int left = 0;
        for(int i = 1; i < ch.length; i++) {
            if(stack.isEmpty()) {
                list.add(S.substring(left, i));
                left = i;
                stack.push(ch[i]);
            } else {
                if(ch[i] != stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch[i]);
                }
            }
        }
        list.add(S.substring(left, S.length()));
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s.substring(1, s.length() - 1));
        }
        return sb.toString();
    }

    public static String removeOuterParentheses1(String S) {
        char[] ch = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int nums = 0;
        int left = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ch[0]) {
                nums++;
            } else {
                nums--;
            }

            if(nums == 0) {
                sb.append(S.substring(left + 1, i));
                left = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses1(s));
    }
}
