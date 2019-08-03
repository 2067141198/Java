public class TestTryCatch {
    public static void main(String[] args) {
        //下面的代码定义了一个 try...catch 语句用于捕获异常
        try{
            int result = dividi(4, 0);
            System.out.println(result);
        }catch(Exception e) { // 对异常进行处理
            System.out.println("捕获的异常信息为：" + e.getMessage());
        }
        System.out.println("程序继续向下执行...");
    }

    //实现两个整数相除
    public static int dividi(int x, int y) {
        return x / y;
    }
}
