import static java.lang.String.*;

public class Dome01ReverseString {
    private static void reverse(char[] ch, int a, int b) {
        int i = 0, j = 0;
        for(i = a, j = b; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "I am a student";
//        char ch[] = "I am a student";
        //String.toCharArray可以得到将包含整个String的char数组。
        // 这样我们就能够使用从0开始的位置索引来访问string中的任意位置的元素。
        char[] ch = s.toCharArray();

        int start = 0;
        int end = 0;

        ////运用数组遍历将字符串里的每个元素进行遍历判断。
        for (int i = 0; i < ch.length; i++) {
            //然后用if语句判断字符串里所有元素买哪些位置是空格，以此分离出这句话里的每个单词
            if(ch[i] == ' ') {
                end = i - 1;
                //调用已经编写好的换位程序现将每个单词都倒着排序
                reverse(ch, start, end);
                start = i + 1;
            }
        }

        //用函数将最后一个单词倒着排序
        reverse(ch, start, ch.length - 1);

        //最后将整个字符串倒着排序
        reverse(ch, 0, ch.length - 1);

        System.out.println(ch);
    }

}
