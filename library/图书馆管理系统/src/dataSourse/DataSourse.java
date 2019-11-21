package dataSourse;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourse {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    private static MysqlDataSource dataSource = new MysqlDataSource();
    static {
        dataSource.setURL(URL);
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(PASSWORD);
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }
}
