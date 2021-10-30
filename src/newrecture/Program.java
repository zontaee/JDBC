package newrecture;

import java.sql.*;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
        String sql = "SELECT * FROM NOTICE WHERE HIT <10";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "newlec", "dlsxo123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            int id = rs.getInt("ID");
            String writerld = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("hit");
            System.out.printf("id : %d, title:%s, writerld:%s, regDate:%s, content:%s, hit:%d\n",id
                    ,title,writerld,regDate,content,hit);
        }
        rs.close();
        st.close();
        con.close();
    }
}
