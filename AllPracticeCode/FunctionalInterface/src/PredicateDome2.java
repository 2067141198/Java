import java.util.function.Predicate;

public class PredicateDome2 {
    public static void main(String[] args) {
        System.out.println(checkString("hello", s -> s.length() > 15, s -> s.length() < 4));    //false
        System.out.println(checkString("hello", s -> s.length() < 15, s -> s.length() < 4));    //false
        System.out.println(checkString("hello", s -> s.length() < 15, s -> s.length() > 4));    //true

        System.out.println(checkString1("hello", s -> s.length() > 3, s -> s.length() > 15));    //true
        System.out.println(checkString1("hello", s -> s.length() > 15, s -> s.length() > 3));    //true
        System.out.println(checkString1("hello", s -> s.length() < 15, s -> s.length() < 3));    //true
        System.out.println(checkString1("hello", s -> s.length() > 3, s -> s.length() < 15));    //true
        System.out.println(checkString1("hello", s -> s.length() < 3, s -> s.length() > 15));    //false
    }

    //同一个字符串给出两个不同的判断条件，最后把这两个判断的结果做逻辑与运算的结果作为最终的结果
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(s);
    }

    //同一个字符串给出两个不同的判断条件，最后把这两个判断的结果做逻辑或运算的结果作为最终的结果
    public static boolean checkString1(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);
    }
}
