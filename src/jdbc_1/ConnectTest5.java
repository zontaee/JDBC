package jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//오라클 접속 테스트
public class ConnectTest5 {

    public static void main(String[] args) {
        String url ="jdbc:oracle:thin:@220.94.153.57:1521/xe";
        String  userid="madang";
        String pwd = "madang";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("데이터베이스 연결 준비...");
            Connection con =  DriverManager.getConnection(url,userid,pwd);
            if(con!=null) {
                System.out.println("데이터베이스 연결 성공..");
            }
            //쿼리객체 생성
            Statement stmt = null;
            ResultSet rs =null;
            //db연결정보로 쿼리객체 생성
            stmt = con.createStatement();
            StringBuffer sb = new StringBuffer();
            sb.append("select bookid,bookname,publisher,price from book order by bookid");
            //DBMS로 쿼리문 전송 후 결과 받기
            rs =stmt.executeQuery(sb+"");
            //결과로 넘어온 RESULTSET을 항행씩 추출하여 처리하기
            while(rs.next()){
              int bookid =  rs.getInt(1);
              String bookname = rs.getString(2);
              String publisher = rs.getString(3);
              int price =  rs.getInt(4);
              System.out.println(bookid+"|"+ bookname+"|"+ publisher+ "|" + price);
            }
            //자원해제
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
