package jdbc_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest8 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Connection con = DaoConnector.getInstance().getConnection();

       Statement stat = con.createStatement();

       String sql = " insert into customer values " +
                "((select max(custid)+1 from customer)," +
                "'홍길이',null,null)";
       int result = stat.executeUpdate(sql);
       if (result>0){
           System.out.println("성공");
       }else{
           System.out.println("실패");
       }
       stat.close(); con.close();
    }
}
