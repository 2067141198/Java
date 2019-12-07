import java.util.function.Function;

public class FunctionDome {
    public static void main(String[] args) {
        convert("100", s -> Integer.parseInt(s));
        convert("100", Integer::parseInt);

        convert(100, i -> String.valueOf(i));
        //convert(100, i -> String::valueOf);          //string is not a functional interface

        convert("100", s -> Integer.parseInt(s), i -> String.valueOf(i + 55));
    }

    public static void convert(String s, Function<String, Integer> fun) {
        int i = fun.apply(s);
        System.out.println(i);
    }

    public static void convert(Integer i, Function<Integer, String> fun) {
        String s = fun.apply(i);
        System.out.println(s);
    }

    public static void convert(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }
}
