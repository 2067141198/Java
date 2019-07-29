public class Dome01CompressionString {
    public static void main(String[] args) {
        String s = "aabbaaccddeebf";
        char[] ch = s.toCharArray();
        System.out.println(ch);

        char[] compressionCh = new char[ch.length];
        int j = 0;
        compressionCh[j++] = ch[0];
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == compressionCh[j]) {
                continue;
            } else {
                compressionCh[j++] = ch[i];
            }
        }

        System.out.println(compressionCh);
    }
}
