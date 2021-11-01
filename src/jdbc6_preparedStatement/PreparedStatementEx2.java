package jdbc6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx2 {
    public static void main(String[] args) {
        try {
            //1.드라이버로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2.연결객체 생성
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            String userid="madang";
            String pwd="madang";
            Connection con = DriverManager.getConnection(url,userid,pwd);

            //3.sql문 전송객체 생성 - template형식객체
            String sql ="select * from customer where name like ? and address like ?";
            PreparedStatement pstmt = con.prepareStatement(sql);//생성시 sql문을 매개변수로 받아서 생성
            //sql문 전달시 10이 바인딩되어서 완전한 쿼리문으로 전달됨
            pstmt.setString(1, "홍길동");
            pstmt.setString(2, "독도");

            //4.실행
            ResultSet rs = pstmt.executeQuery();//실행시는 sql문 을 매개변수로 받지안혹 실행
            rs.next();
            System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));


        }catch(Exception e) {

        }
    }
}