package classse;

import action.Actions;

import java.util.*;
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
        System.out.println("******6.  切换用户  ******");
    }

    @Override
    public boolean input() {
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 0:
                return true;
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
                returnBook();
                break;
            case 5:
                queryRecord();
                break;
            case 6:
                System.out.println("切换用户中..");
                break;
            default:
                break;
        }
        return false;
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

    private void queryRecord() {
        List<Record> recordList = new ArrayList<>();
        System.out.println("*****************************");
        System.out.println("**1.    查询全部借阅记录   **");
        System.out.println("**2. 根据用户Id查询借阅记录**");
        System.out.println("*****************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入查询的方式：");
        switch(sc.nextInt()) {
            case 1:
                recordList = Actions.queryAllRecord();
                break;
            case 2:
                sc.nextLine();
                System.out.println("请输入需要借阅记录用户的id：");
                recordList = Actions.queryIdRecord(sc.nextLine());
                break;
            default:
                System.out.println("选择有误！请重新选择：");
                break;
        }
        if(recordList.size() == 0) {
            System.out.println("未查询到与之想关的借阅记录...");
        } else {
            for(Record record : recordList) {
                System.out.println("借阅用户id：" + record.getUserId() + " 借阅书籍的ISBN：" +
                        record.getBookISBN() + " 借书时间：" + record.getBorrowTime() + " 还书时间：" +
                        record.getReturnTime());
            }
            System.out.println("共查询到" + recordList.size() + "条借阅记录");
        }
    }

}
