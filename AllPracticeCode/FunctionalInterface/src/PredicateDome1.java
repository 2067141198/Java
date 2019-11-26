import java.util.function.Predicate;

public class PredicateDome1 {
    public static void main(String[] args) {
        System.out.println(checkString("hello", s -> s.length() > 8));
    }

    public static boolean checkString(String s, Predicate<String> pre) {
        //return !pre.test(s);   //true
        return pre.test(s);   //false
        //return pre.negate().test(s);    //true
    }
}
