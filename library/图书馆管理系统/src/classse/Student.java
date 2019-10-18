package classse;

import java.util.Scanner;

public class Student extends User {
    public Student () {}

    public Student (String id, String name, String role) {
        super(id, name, role);
    }

    @Override
    public void menu() {
        System.out.println("******  同学请选择  ******");
        System.out.println("******0.  退出系统  ******");
        System.out.println("******1.  查询图书  ******");
        System.out.println("******2.  借阅图书  ******");
        System.out.println("******3.  归还图书  ******");
        System.out.println("******4.查询借阅信息******");
    }

    @Override
    public boolean input() {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                return false;
            case 1:
                queryBook();
                break;
            case 2:
                borrowedBook();
                break;
            case 3:
                System.out.println("正在还书...");
                break;
            case 4:
                System.out.println("正在查询借阅记录...");
                break;
            default:
                break;
        }
        return true;
    }
}
