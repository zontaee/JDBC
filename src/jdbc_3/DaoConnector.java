package jdbc_3;

import java.sql.*;

public class DaoConnector {
    public Connection getConnection;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    //1 .static접근자의 자신타입의 필드 선언
    private static DaoConnector instance = new DaoConnector();

    //2.기본생성자를 private
    private DaoConnector(){}

    //3.public메소드로 자신 타입의 필드를 리턴받도록 선언
    public static DaoConnector getInstance() {
        return instance;
    }
    //4.연결객체 생성 메소드
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        final String driver ="oracle.jdbc.driver.OracleDriver";
        final String url ="jdbc:oracle:thin:@220.94.153.57:1521:xe";
        final String userid="madang";
        final String pwd ="madang";
        Class.forName(driver);
       Connection conn = DriverManager.getConnection(url,userid,pwd);
        return conn;
    }
}
