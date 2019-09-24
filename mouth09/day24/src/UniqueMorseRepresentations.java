import java.util.*;

/**
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字
 * 符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。

 */
public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        //先创建一个map将字母及对应的摩斯码一一对应的保存下来
        Map<Character, String> map = new HashMap<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i = 0; i < 26; i++) {
            map.put((char)('a' + i), morse[i]);
        }
        //遍历数组中的每个字符串，然后得到每个字符串的摩斯码，将其存入提前创建好的set中
        for(int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < ch.length; j++) {
                sb.append(map.get(ch[j]));
            }
            set.add(sb.toString());
        }
        //set是无序不重复的类集，所以的元素个数就是所要求得的不同单词翻译的数量
        return set.size();
    }
}
