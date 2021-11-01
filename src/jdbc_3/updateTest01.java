package jdbc_3;

import jdbc_2.DaoConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updateTest01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DaoConnector.getInstance().getConnection();
        Statement stat = con.createStatement();
        String address = "사울";
        String phone = "010-2200-3138";
        int custid = 3;
        String sql = "update customer set address='"+address+"'," +
                " phone='"+phone+"' where custid="+custid;
        System.out.println(sql);
        int result = stat.executeUpdate(sql);
        if(result>0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
        stat.close(); con.close();

    }
}
