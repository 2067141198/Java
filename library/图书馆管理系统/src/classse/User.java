package classse;

import action.Actions;
import databases.Where;

import java.util.*;

//用户类
public abstract class User {
    private String id;
    private String name;
    private String role;

    public User() {}

    public User(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    private static User user = null;

    /**
     * 用户登录
     * @return 登录系统的用户对象
     * @throws Exception 错误用户
     */
    public static User login() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户id：");
        String id = sc.nextLine();
        System.out.println("请输入用户姓名：");
        String name = sc.nextLine();
        System.out.println("请输入用户职业：");
        String role = sc.nextLine();
        if(role.equals("老师")) {
            user = new Teacher(id, name,role);
        } else if(role.equals("学生")) {
            user = new Student(id, name, role);
        } else {
            throw new Exception("职业输入有误");
        }
        return user;
    }

    public abstract void menu();

    public abstract boolean input();

    /*protected void categoryMenu() {
        Map<String, Book> map = Actions.categoryMenu();
        Set<String> set = map.keySet();
        List<String> list = new ArrayList<>(set);
        System.out.println("**********图书的类别**********");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("******" + i + list.get(i) + "******");
        }
        System.out.println("********" + list.size() + "返回上一级**********");
    }*/

    protected void queryBook() {
        List<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("**0.   按图书类别查询   **");
        System.out.println("**1.   按图书全名查询   **");
        System.out.println("**2. 按图书名关键字查询 **");
        System.out.println("**3. 按图书现有存量查询 **");
        System.out.println("**4.  查询所有图书信息  **");
        switch(sc.nextInt()) {
            case 0:
                System.out.println("请输入需要查询书的类别：");
                sc.nextLine();
                String category = sc.nextLine();
                list = Actions.queryBookByWhere(new BookCategory(category));
                break;
            case 1:
                System.out.println("请输入需要查询书的名称：");
                sc.nextLine();
                list = Actions.queryBookByWhere(new BookTitle(sc.nextLine()));
                break;
            case 2:
                System.out.println("请输入需要查询书的书名关键字：");
                sc.nextLine();
                list = Actions.queryBookByWhere(new BookTitleKey(sc.nextLine()));
                break;
            case 3:
                sc.nextLine();
                list = Actions.queryBookByWhere(new existCount());
                break;
            case 4:
                list = Actions.queryBook();
                break;
            default:
                System.out.println("选择有误！请重新选择：");
                break;
        }
        if(list.size() == 0) {
            System.out.println("并未查询到复合要求的图书...");
        } else {
            for (Book book : list) {
                System.out.println("《" + book.getTitle() + "》" + " ISBN " + book.getISBN() + " 作者：" + book.getAuthor()
                        + " 书的类型：" + book.getCategory() + " 价格：" + book.getPrice() + " 总书量：" + book.getAllCount()
                        + " 现剩数量：" + book.getExistCount() + " 借阅次数：" + book.getBorrowCount());
            }
            System.out.println("一共有" + list.size() + "种书");
        }
    }

    /**
     * 下述四个内部类为实现Where接口的类，其目的根据其不同的查询条件对图书进行查询
     */
    private class BookCategory implements Where<Book> {
        private String category;
        private BookCategory(String category) {
            this.category = category;
        }
        @Override
        public boolean test(Book book) {
            return book.getCategory().equals(category);
        }
    }

    private class BookTitle implements Where<Book> {
        private String title;
        private BookTitle(String title) {
            this.title = title;
        }
        @Override
        public boolean test(Book book) {
            return book.getTitle().equals(title);
        }
    }

    private class BookTitleKey implements Where<Book> {
        private String key;
        private BookTitleKey(String key) {
            this.key = key;
        }
        @Override
        public boolean test(Book book) {
            return book.getTitle().contains(key);
        }
    }

    private class existCount implements Where<Book> {
        @Override
        public boolean test(Book book) {
            return book.getExistCount() > 0;
        }
    }


}
