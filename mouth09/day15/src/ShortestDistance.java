public class ShortestDistance {
    public static int[] shortestToChar(String S, char C) {
        char[] array = S.toCharArray();
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            //定义两个布尔变量来判断遍历到i位置处左边或者右边时候走到头还没有找到C
            //必须定义在大循环内，如果定义之外的话经过一次false赋值后，这两个的值不再会发生改变，影响最终结果
            boolean flagLeft = true;
            boolean flagRight = true;

            //如果该下标 i 处在字符数组中左边存在 C 的话返回与其的距离
            //如果通过break返回的话证明左边存在字符 C ，返回的就是距离左边字符 C的距离
            //如果不是通过break返回的话，说明左边不存在字符 C
            int left = 0;
            for(int k = i; k >= 0; k--) {
                if(array[k] == C) {
                    flagLeft = false;
                    break;
                }
                left++;
            }
            //判断线标 i 处右边是否存在字符 C 然后返回其距离
            int right = 0;
            for(int j = i; j < array.length; j++) {
                if(array[j] == C) {
                    flagRight = false;
                    break;
                }
                right++;
            }

            //如果flagLeft == true 说明不是通过break返回的，即左半部分不存在字符C，让result[i] = right;
            //如果flagRight == true 说明不是通过break返回的，即右半部分不存在字符C，让result[i] = left;
            //如果两个都是false，说明两边都有字符C，让将left和right中最小的值赋值给 result[i]
            if(flagLeft) {
                result[i] = right;
            } else if(flagRight) {
                result[i] = left;
            } else {
                result[i] = Math.min(left, right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abaa";
        int[] array = shortestToChar(s, 'b');
        for(Integer i : array) {
            System.out.println(i);
        }
    }
}
