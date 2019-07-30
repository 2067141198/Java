import java.util.ArrayList;

public class Dome01CompressionString {
    public static void main(String[] args) {
        String s = "aabbaaccddeebf";
        char[] ch = s.toCharArray();
        System.out.println(ch);

        //char[] compressionCh = new char[ch.length];
        ArrayList<Character> compressionCh = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            compressionCh.add(ch[i]);
        }

        System.out.println(compressionCh);

        for (int i = 0; i < compressionCh.size(); i++) {
            for (int j = i + 1; j < compressionCh.size(); j++) {
                if(compressionCh.get(i) == compressionCh.get(j)) {
                    compressionCh.remove(j);
                }
            }
        }
        System.out.println(compressionCh);
    }
}
