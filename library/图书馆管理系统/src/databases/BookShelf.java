package databases;

import Exception.NoSuchBookException;
import classse.Book;

import java.util.*;

//存储所有图书的数据库，即书架
public class BookShelf {
    static List<Book> bookList = new ArrayList<>();
    static Map<String, List<Book>> bookMap = new HashMap<>();
    static List<String> categoryList = new ArrayList<>();

    private static BookShelf bookShelf = new BookShelf();
    public static BookShelf getInstance() {
        return bookShelf;
    }

    /**
     * categoryMenuhe和input是由用户选择全图书查询时先将所有书的类别
     * 输出为菜单的形式让用户选择，然后返回符合用户选择的图书类型的所
     * 有图书
     */
    public static void categoryMenu() {
        for(Book book : bookList) {
            List<Book> iniList = bookMap.getOrDefault(book.getCategory(),new ArrayList<>());
            iniList.add(book);
            bookMap.put(book.getCategory(), iniList);
        }
        Set<String> set = bookMap.keySet();
        categoryList = new ArrayList<>(set);
        System.out.println("**********图书的类别**********");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("******" + i + categoryList.get(i) + "******");
        }
        System.out.println("********" + categoryList.size() + "返回上一级**********");
    }

    public static List<Book> input() {
        List<Book> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();
        if(tmp < 0 || tmp > categoryList.size()) {
            throw new IndexOutOfBoundsException();
        }
        if(tmp == categoryList.size()){
            System.out.println("返回上一级...");
        }
        for(Book book : bookList) {
            if(book.getCategory().equals(categoryList.get(tmp)))
                result.add(book);
        }
        return result;
        //return bookMap.get(categoryList.get(tmp));
    }

    public Book search(String ISBN) throws NoSuchBookException {
        for(Book book : bookList) {
            if(book.is(ISBN)) {
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }

    public void putBook(Book book) {
        bookList.add(book);
    }

    /**
     * 通过传入的实现Where接口的类的对象来对所有图书进行符合要求的查询
     * @param where 实现Where接口类的对象
     * @return 符合查询条件的图书的集合
     */
    public List<Book> queryBook(Where<Book> where) {
        List<Book> result = new ArrayList<>();
        for(Book book : bookList) {
            if(where.test(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
