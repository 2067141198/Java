import java.util.Arrays;

public class PrintNumIntOfStr {
    public static void main(String[] args) {
        String s = "bit666keji123";

        char[] ch = s.toCharArray();

        System.out.println(ch);
        System.out.println(Arrays.toString(ch));

        int tmp = 0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] <= '9' && ch[i] >= '0') {
                tmp++;
            }
        }

        System.out.println("该字符串中数字的个数为：" + tmp);
    }
}
