import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * String[] strArray = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖贤,33"};
 * 字符串数组中有多条信息，请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，并
 * 遍历ArrayList集合
 * 同时满足如下要求：姓名长度大于2；年龄大于33
 */
public class PredicateTest {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖贤,33"};
        List<String> list = new ArrayList<>();

        for (String string : strArray) {
            boolean flag = checkString(string, s -> s.split(",")[0].length() > 2,
                    s -> Integer.parseInt(s.split(",")[1]) > 33);

            if (flag)
                list.add(string);
        }

        System.out.println(list);
    }

    //同一个字符串给出两个不同的判断条件，最后把这两个判断的结果做逻辑与运算的结果作为最终的结果
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(s);
    }
}
