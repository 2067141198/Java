import java.util.Arrays;

public class Dome01PrintHighFrequencyNum {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};

        //创建一个数组用来保存每个元素在array数组中出现的个次数
        int[] arrayCount = new int[array.length];


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    arrayCount[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arrayCount));
    }
}
