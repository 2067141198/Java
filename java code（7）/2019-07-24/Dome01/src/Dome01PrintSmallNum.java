import java.util.Scanner;

public class Dome01PrintSmallNum {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要得到最小数的数量：");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }
    }
}
