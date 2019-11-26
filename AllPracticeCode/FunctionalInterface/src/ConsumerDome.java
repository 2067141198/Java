import java.util.function.Consumer;

public class ConsumerDome {
    public static void main(String[] args) {
        operatorString("今天是周二", s -> System.out.println(s));

        operatorString("黄山落叶松叶落上黄，山西运煤车煤运西山",
                s -> System.out.println(new StringBuilder(s).reverse().toString()));

        operatorString("今天是阴天", s -> System.out.println(s),
                s -> System.out.println(new StringBuilder(s).reverse().toString()));

        operatorString("今天是阴天", s -> System.out.println(s),
                s -> System.out.println(new StringBuilder(s).reverse().toString()),
                s -> System.out.println(s.substring(0, 4)));
    }

    public static void operatorString(String s, Consumer<String> con1, Consumer<String> con2, Consumer<String> con3) {
        con1.andThen(con2).andThen(con3).accept(s);
    }

    public static void operatorString(String s, Consumer<String> con1, Consumer<String> con2) {
        //con1.accept(s);
        //con2.accept(s);

        con1.andThen(con2).accept(s);
    }

    public static void operatorString(String s, Consumer<String> con) {
        con.accept(s);
    }
}
