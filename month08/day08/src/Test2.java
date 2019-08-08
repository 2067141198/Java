public class Test2 {
    public static void main(String[] args) {
        try{
            int x = 2 / 0;
            System.out.println(x);
        } catch(Exception e) {
            System.out.println("进入catch代码块");
        } finally {
            System.out.println("进入finally代码块");
        }
    }
}
