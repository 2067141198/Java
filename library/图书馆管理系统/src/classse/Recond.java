package classse;

import java.util.Date;

//关联用户和图书的借阅类
public class Recond {
    private String userId;
    private String bookISBN;
    private Date borrowTime;//借书的时间
    private Date returnTime;//还书时间
}
