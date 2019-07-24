import java.util.Arrays;
import java.util.Scanner;

public class Dome01PrintSmallNum {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(Arrays.toString(array));
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要得到最小数的数量：");
        int k = sc.nextInt();
        /*
        * 将数组中的元素从小到大重新排序
        * */
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }
    }
}
