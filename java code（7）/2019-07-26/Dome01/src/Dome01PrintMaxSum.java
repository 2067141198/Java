import java.util.ArrayList;

public class Dome01PrintMaxSum {
    public static void main(String[] args) {
        int[] list = {1,-2,3,10,-4,7,2,-5};

        //用来存储除单个元素外有多少子数组
        int count = 0;

        //用来存储给定数组的子数组的所有和（除单个元素的子数列）
        ArrayList<Integer> listSum = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            int sum = list[i];
            for (int j = i + 1; j < list.length; j++) {
                sum += list[j];
                listSum.add(sum);
                count++;
            }
        }
        System.out.println(listSum);
        System.out.println("count = " + count);

        //用来存储子数组和的最大值
        int maxSum = 0;
        for (int i = 0; i < listSum.size(); i++) {
            if(listSum.get(i) > maxSum) {
                maxSum = listSum.get(i);
            }
        }
        System.out.println("给定数组中子数组的最大和为：" + maxSum);
    }
}
