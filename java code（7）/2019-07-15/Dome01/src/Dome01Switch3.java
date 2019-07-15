public class Dome01Switch3 {
    /*
     * 测试 switch 语句的选择语句为字符串的时候能否正常编译运行
     * */
    public static void main(String[] args) {
        String s = "abc";

        switch(s) {
            case "abc":
                System.out.println("abc");
                break;
            case "def":
                System.out.println("def");
                break;
            case "ghi":
                System.out.println("ghi");
                break;
            default:
                break;
        }
    }
}
