package classse;

//图书类
public class Book {
    private String ISBN;//书的sku
    private String title;//书名
    private String author;//作者
    private double price;//价格
    private String category;//书的类型
    private int allCount;//图书的全部数量
    private int existCount;//图书的现存数量
    private int borrowCount;//被借的次数

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getAllCount() {
        return allCount;
    }

    public int getExistCount() {
        return existCount;
    }

    public String getCategory() {
        return category;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public Book(String ISBN, String title, String author, String category, double price, int count) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.allCount = count;
        this.existCount = count;
        this.borrowCount = 0;
    }

    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        allCount += count;
        existCount += count;
    }
}
