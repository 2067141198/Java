import java.util.Arrays;
import java.util.Scanner;

public class Dome01ReverseList2 {
    public static void main(String[] args) {
        char[] list = {'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要逆置的位置：");
        int k = sc.nextInt();
        //System.out.println(k);
        char[] listFront = new char[list.length];
        char[] listBack = new char[list.length];
        int lf = 0;
        int lb = 0;

        for (int i = 0; i < list.length; i++) {
            if (i < k) {
                listFront[lf++] = list[i];
            } else {
                listBack[lb++] = list[i];
            }
        }

        for (int i = 0; i < k; i++) {
            listBack[lb++] = listFront[i];
        }

        list = Arrays.copyOf(listBack,listBack.length);

        System.out.println(Arrays.toString(list));
    }
}
