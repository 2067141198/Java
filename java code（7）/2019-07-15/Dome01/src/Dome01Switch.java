public class Dome01Switch {
    /*
     * 测试 switch 语句的选择语句为数字的时候能否正常编译运行
     */
    public static void main(String[] args) {
        int num = 5;

        switch(num) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                break;
        }
    }
}
