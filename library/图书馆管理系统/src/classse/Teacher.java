package classse;

import action.Actions;

import java.util.Scanner;

public class Teacher extends User {
    public Teacher () {}

    public Teacher (String id, String name, String role) {
        super(id, name, role);
    }
    @Override
    public void menu() {
        System.out.println("******  老师请选择  ******");
        System.out.println("******0.  退出系统  ******");
        System.out.println("******1.  新书上架  ******");
        System.out.println("******2.  查询图书  ******");
        System.out.println("******3.  借阅图书  ******");
        System.out.println("******4.  归还图书  ******");
        System.out.println("******5.查询借阅信息******");
    }

    @Override
    public boolean input() {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                return false;
            case 1:
                putBook();
                break;
            case 2:
                queryBook();
                break;
            case 3:
                borrowedBook();
                break;
            case 4:
                System.out.println("正在还书...");
                break;
            case 5:
                System.out.println("正在查询借阅记录...");
                break;
            default:
                break;
        }
        return true;
    }

    private void putBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加书的ISBN：");
        String ISBN = sc.nextLine();
        System.out.println("请输入图书的名称：");
        String title = sc.nextLine();
        System.out.println("请输入图书的作者：");
        String author = sc.nextLine();
        System.out.println("请输入图书的类别：");
        String category = sc.nextLine();
        System.out.println("请输入图书的价格：");
        double price = sc.nextDouble();
        System.out.println("请输入需要添加的数量：");
        int count = sc.nextInt();

        Actions.putBook(ISBN, title, author, category, price, count);
        System.out.println("《" + title + "》添加成功，添加数量为：" + count);
    }
}
