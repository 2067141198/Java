import java.util.ArrayList;
import java.util.Arrays;

public class Dome01CompressionString {
    public static void main(String[] args) {
        String s = "aabbaaccddeebf";
        char[] ch = s.toCharArray();
        System.out.println("s = " + s);
        System.out.println(ch);

        //char[] compressionCh = new char[ch.length];
        ArrayList<Character> compressionCh = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            compressionCh.add(ch[i]);
        }

        System.out.println(compressionCh);

        //删除compressionCh中重复的元素
        for (int i = 0; i < compressionCh.size(); i++) {
            for (int j = i + 1; j < compressionCh.size(); j++) {
                if(compressionCh.get(i) == compressionCh.get(j)) {
                    compressionCh.remove(j);
                }
            }
        }
        System.out.println(compressionCh);

        //创建一个数组，用来储存compressionCh中对应位置元素出现的次数
        int[] appearNum = new int[compressionCh.size()];
        for (int i = 0; i < compressionCh.size(); i++) {
            for (int j = 0; j < ch.length; j++) {
                if(compressionCh.get(i) == ch[j]) {
                    appearNum[i]++;
                }
            }
        }

        System.out.println(Arrays.toString(appearNum));

        //最终压缩后的字符串
        ArrayList<Character> newCompressionCh  = new ArrayList<>();
        for (int i = 0; i < appearNum.length; i++) {
            newCompressionCh.add(compressionCh.get(i));
            newCompressionCh.add((char)(appearNum[i] + 48));
        }
        System.out.println(newCompressionCh);
    }
}
