package jdbc_2;

import java.sql.Connection;
import java.sql.Statement;

public class InsertTest1 {
    public static void main(String[] args) {
        //1.드라이버로딩,2.연결객체 생성
        try {
            Connection con = DaoConnector.getInstance().getConnection();
            //3.쿼리객체 생성
            Statement stmt = con.createStatement();

            //4.쿼리문 생성
            String sql ="insert into book(bookid, bookname,publisher, price) "
                    + " values((select max(bookid)+1 from book),'축구영웅','대한출판사',30000)";

            //5.쿼리전송 및 결과받기
            //executeUpdate(쿼리문) 리턴타입은 int 삽입된 행의 수 리턴, 0이면 입력안된 결과
            int result =stmt.executeUpdate(sql);
            if(result>0) {
                System.out.println("입력성공");
            }else {
                System.out.println("입력실패");
            }
            //6.자원해제
            stmt.close();  con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }



    }
}
