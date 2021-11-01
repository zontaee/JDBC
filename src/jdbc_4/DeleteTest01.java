package jdbc_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url ="jdbc:oracle:thin:@220.94.153.57:1521:xe";
        String userid="madang";
        String pwd ="madang";
        Connection con = DriverManager.getConnection(url,userid,pwd);

        Statement stat = con.createStatement();

        con.setAutoCommit(false);//false로 처리하면 수동 commit 처리됨.
        String sql = "delete from customer where custid = (select max(custid) from customer)";

        int result = stat.executeUpdate(sql);
        if(result>0){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
        con.commit();
        stat.close();con.close();
        try {
            con.rollback();
        }catch (SQLException e){
            e.printStackTrace();
    }finally {
            try {
                con.setAutoCommit(true);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        }
}
