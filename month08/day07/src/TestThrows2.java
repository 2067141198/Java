public class TestThrows2 {
    public static void main(String[] args) {
        try{
            int result = dividi(4, 0);
            System.out.println(result);
        }catch (Exception e) {
            //System.out.println("捕获的异常信息是：" + e.getMessage());
            e.printStackTrace();    //打印捕获的异常信息
        }
    }

    public static int dividi(int x, int y) {
        return x / y;
    }
}
