import java.util.*;

public class day18MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //根据指定的 k 查找对应的 v
        System.out.println(map.get("张三"));
        //根据指定的 k 查找对应的 v，没有找到用默认值代替
        System.out.println(map.getOrDefault("张三","成绩暂时未输入"));
        System.out.println(map.get("张三"));

        //将指定的 k-v 放入 Map
        map.put("张三", "85");
        map.put("李四", "83");
        map.put("王五", "89");

        //返回键值对的数量
        System.out.println(map.size());

        //判断是否包含 key
        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsKey("孙六"));

        //判断是否包含 value
        System.out.println(map.containsValue("85"));
        System.out.println(map.containsValue("50"));

        //判断是否为空
        System.out.println(map.isEmpty());

        //将所有键值对返回
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);
    }
}
