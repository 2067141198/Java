public class TestThrows1 {
    public static void main(String[] args) {
        int result = dividi(4, 0);
        System.out.println(result);
    }

    //在下面进行了抛出异常但是上面却未对抛出的异常进行处理
    //所以会报错,暂时将爬出异常部分注释
    public static int dividi(int x, int y) /*throws Exception*/{
        return x / y;
    }
}
