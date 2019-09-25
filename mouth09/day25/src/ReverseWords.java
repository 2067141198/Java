public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            String st = reverse(str[i]);
            if(i == str.length - 1) {
                sb.append(st);
            } else {
                sb.append(st);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String reverse2(String s) {
        //将传入的字符串转化成StringBuilder后再进行逆置，然后再转成String返回；
        return new StringBuilder(s).reverse().toString();
    }

    public String reverse(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        return new String(ch);
    }
}
