

public class Dome01Switch2 {
    /*
    * 测试 switch 语句的选择语句为字符的时候能否正常编译运行
    * */
    public static void main(String[] args) {
       char c = 'a';

        switch(c) {
            case 'a':
                System.out.println('a');
                break;
            case 'b':
                System.out.println('b');
                break;
            case 'c':
                System.out.println('c');
                break;
            default:
                break;
        }
    }
}
