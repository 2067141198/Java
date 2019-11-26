import java.util.function.Function;

/**
 * String s = "林青霞,30";
 * 请按照我指定的要求进行操作：
 * 1:将字符串截取得到数字年龄部分
 * 2:将上一步的年龄字符串转换成为int类型的数据
 * 3:将上一步的int数据加70，得到一个int结果，在控制台输出
 * 请通过Function接口来实现函数拼接
 */
public class FunctionTest {
    public static void main(String[] args) {
        String str = "林青霞,30";

        convert(str, s -> Integer.parseInt(s.split(",")[1]), i -> String.valueOf(i + 70));
    }

    public static void convert(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        System.out.println(fun1.andThen(fun2).apply(s));
    }
}
