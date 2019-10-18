package classse;

import java.text.SimpleDateFormat;
import java.util.Date;

//关联用户和图书的借阅类
public class Record {
    private String userId;
    private String bookISBN;
    private Date borrowTime;//借书的时间
    private Date returnTime;//还书时间

    public String getUserId() {
        return userId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getBorrowTime() {
        SimpleDateFormat fat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return fat.format(borrowTime);
    }

    public String getReturnTime() {
        SimpleDateFormat fat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return fat.format(returnTime);
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Record(User user, String ISBN) {
        this.userId = user.getId();
        this.bookISBN = ISBN;
        this.borrowTime = new Date();
        this.returnTime = null;
    }

    public boolean is(User user, String ISBN) {
        return this.userId.equals(user.getId()) && this.bookISBN.equals(ISBN) && this.returnTime == null;
    }
}
