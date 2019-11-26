import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};
        for (int i = 0; i < strArray.length; i++) {
            operatorString(strArray[i], s -> {
                //String[] str = s.split(",");
                System.out.println("姓名是：" + s.split(",")[0]);
            }, s -> {
                //String[] str = s.split(",");
                System.out.println("年龄是：" + s.split(",")[1]);
            });
        }
    }

    public static void operatorString(String s, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(s);
    }
}
