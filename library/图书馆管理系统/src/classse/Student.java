package classse;

import action.Actions;

import java.util.List;
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
        System.out.println("******5.  切换用户  ******");
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
                returnBook();
                break;
            case 4:
                queryRecord();
                break;
            case 5:
                System.out.println("切换用户中..");
                break;
            default:
                break;
        }
        return true;
    }

    private void queryRecord() {
        List<Record> recordList = Actions.queryIdRecord(User.getCurrentUser().getId());
        if(recordList.size() == 0) {
            System.out.println("您不曾在该图书馆借阅过图书...");
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
