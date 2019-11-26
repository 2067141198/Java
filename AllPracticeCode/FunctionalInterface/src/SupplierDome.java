import java.util.function.Supplier;

public class SupplierDome {
    public static void main(String[] args) {
        int i = getInteger(() -> 50);
        System.out.println(i);

        String s = getString(() -> "我要学习");
        System.out.println(s);
    }

    public static Integer getInteger(Supplier<Integer> sup) {
        return sup.get();
    }

    public static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
