package action;

import classse.Book;
import classse.Record;
import classse.User;
import databases.BookShelf;
import Exception.*;
import databases.RecordShelf;
import databases.UserShelf;
import databases.Where;

import java.util.List;

public class Actions {
    public static Book putBook(String ISBN, String title, String author, String category, double price, int count) {
        //首先看下书架上是否已经上架过这本书，
        //1.先得到书架对象，给系统中至始只有一个书架，故采用单例模式
        BookShelf bookShelf = BookShelf.getInstance();
        try{
            //首先在书架中查询看是否已经包含该书，如果包含直接增加该书的数量即可，如果不包含抛出NoSuchBookException异常，
            // 然后再将该书添加进去
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        }catch(NoSuchBookException e){
            //新建该书的实例对象，然后添加到书架中
            Book book = new Book(ISBN, title, author, category, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }

    public static List<Book> queryBook() {
        BookShelf.categoryMenu();
        return BookShelf.input();
    }

    public static List<Book> queryBookByWhere(Where<Book> where) {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBook(where);
    }

    public static Book borrowedBook(User user, String ISBN) throws NoSuchBookException, BorrowOutException, YetBorrowException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        UserShelf userShelf = UserShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        //判断图书馆内该书的现存量是否为空
        if(book.getExistCount() < 0) {
            throw new BorrowOutException();
        }
        //判断该用户曾经借过该书且未归还
        if(recordShelf.contains(user, ISBN)) {
            throw new YetBorrowException();
        }
        book.borrowBook();
        recordShelf.borrowBook(user, ISBN);
        //往用户数据表中添加该用户，如果是新用户就添加，否则不添加
        userShelf.addNextUser(user);
        return book;
    }

    public static Book returnBook(User user, String ISBN) throws NoSuchBookException, NoBorrowException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        //若抛出异常说明未在书架中查到该ISBN的图书
        Book book = bookShelf.search(ISBN);
        recordShelf.returnBook(user, ISBN);
        book.returnBook();
        return book;
    }

    public static List<Record> queryAllRecord() {
        RecordShelf recordShelf = RecordShelf.getInstance();
        return recordShelf.getRecordList();
    }

    public static List<Record> queryIdRecord(String id) {
        RecordShelf recordShelf = RecordShelf.getInstance();
        return recordShelf.search(id);
    }
}
