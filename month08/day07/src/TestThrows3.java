public class TestThrows3 {
    public static void main(String[] args) throws Exception {
        int result = dividi(4, 0);
        System.out.println(result);
    }

    public static int dividi(int x, int y) throws Exception {
        return x / y;
    }
}
