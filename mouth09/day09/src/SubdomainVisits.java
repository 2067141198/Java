import java.util.*;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        //首先遍历字符串数组中的每个字符串
        for(String s : cpdomains) {
            //首先将字符串根据其中拥有的指定字符分割成几部分
            String[] sIndex = s.split(" ");
            //将其中字符串数字转化成整型数字
            int index = Integer.valueOf(sIndex[0]);

            //再根据其中的.将字符分成每个最小单位的字符串
            String[] w = sIndex[1].split("\\.");
            String[] sub = null;
            //将字符串按顺序组成几个连续的字字符串
            for(int i = 0; i < w.length; i++) {
                sub = Arrays.copyOfRange(w, i, w.length);
                String d = String.join(".", sub);
                //找到每个子字符串原来对相应的value值（即出现的次数）
                int oldCount = map.getOrDefault(d, 0);
                //然后将最终的子字符串和对应的vlaue值重新加入map
                map.put(d, oldCount + index);
            }
        }
        List<String> list = new ArrayList<>();
        //将每个子字符串即对应出现的次数拼接成新的字符串，然后添加入list中
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String d = entry.getKey();
            int n = entry.getValue();
            list.add(n + " " + d);
        }
        return list;
    }
}
