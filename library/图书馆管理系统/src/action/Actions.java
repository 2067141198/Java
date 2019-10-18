package action;

import classse.Book;
import classse.User;
import databases.BookShelf;
import Exception.NoSuchBookException;
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
}
