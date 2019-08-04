public class TestTryCatchFinally {
    public static void main(String[] args) {
        try{
            int result  = dividi(4, 0);
            System.out.println(result);
        }catch (Exception e) { // 对捕获到的异常进行处理
            System.out.println("捕获的异常信息为：" + e.getMessage());
        }finally{
            System.out.println("进入finally代码块");
        }
        System.out.println("程序继续向下执行。。。");
    }

    public static int dividi(int x, int y) {
        return x / y;
    }
}
