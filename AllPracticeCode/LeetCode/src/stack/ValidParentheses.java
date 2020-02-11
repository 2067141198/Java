package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add('}');
        list.add('[');
        list.add(']');
        list.add('{');
        list.add(')');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char ch = stack.peek();
            if ((list.indexOf(ch) + list.indexOf(s.charAt(i)) == 5))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        isValid(s);
    }
}
