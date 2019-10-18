package databases;

import classse.Record;
import classse.User;
import Exception.*;

import java.util.*;

//存放所有借阅信息的数据库
public class RecordShelf {
    List<Record> recordList = new ArrayList<>();

    private static RecordShelf instance = new RecordShelf();
    public static RecordShelf getInstance() {
        return instance;
    }

    public void borrowBook(User user, String ISBN) {
        recordList.add(new Record(user, ISBN));
    }

    public boolean contains(User user, String ISBN) {
        for(Record record : recordList) {
            if(record.getUserId().equals(user.getId()) && record.getBookISBN().equals(ISBN) && record.getReturnTime() != null)
                return true;
        }
        return false;
    }

    public void returnBook(User user, String ISBN) throws NoBorrowException {
        for(Record record : recordList) {
            if(record.is(user, ISBN))
                record.setReturnTime(new Date());
        }
        throw new NoBorrowException();
    }

    public List<Record> getRecordList() {
        return new ArrayList<>(recordList);
    }

    public List<Record> search(String id) {
        List<Record> list = new ArrayList<>();
        for(Record record : recordList) {
            if(record.getUserId().equals(id))
                list.add(record);
        }
        return list;
    }
}
