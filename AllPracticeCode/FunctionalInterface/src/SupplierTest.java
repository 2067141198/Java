import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        //定义一个数组
        int[] array = {15, 85, 16, 58, 62, 34};

        int max = getMax(() -> {
            int tmp = 0;
            for (int i = 0; i < array.length; i++) {
                if (tmp < array[i])
                    tmp = array[i];
            }
            return tmp;
        });

        System.out.println(max);
    }

    public static Integer getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
