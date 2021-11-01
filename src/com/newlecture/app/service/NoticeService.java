package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
    private  String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
    private String uid = "newlec";
    private String pwd = "dlsxo123";
    public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException ,NullPointerException{

        int start =1 + (page-1)*10;
        int end =10*page;

        String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
        String sql = "select * from (" +
                "select rownum num,n.* from (" +
                "select * from notice order by regdate desc" +
                ") n" +
                ") " +
                "where "+field+" like ? and num between ? and ?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, uid, pwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, "%"+query+"%");
        st.setInt(2,start);
        st.setInt(3,end);
        ResultSet rs = st.executeQuery();

        List<Notice> list = new ArrayList<Notice>();

        while(rs.next()) {
            int id = rs.getInt("ID");
            String writerld = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("hit");
            String files = rs.getString("FILES");


            Notice notice = new Notice(id,writerld,regDate,title,content,hit,files);

           list.add(notice);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }
    public int getCount() throws ClassNotFoundException, SQLException {
        int count =0;
        String sql = "select count(id) count from notice";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, uid, pwd);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            count = rs.getInt("count");
                  }
        rs.close();
        st.close();
        con.close();
        return count;
    }

 public  int insert(Notice notice) throws SQLException, ClassNotFoundException {
        int id = notice.getId();
        String title =notice.getTitle();
        String writerId = notice.getWriterld();
        Date regdate = notice.getRegDate();
     String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
     String sql = "insert into notice(" +
             "id," +
             "title," +
             "writerId," +
             "regdate)" +
             "VALUES(?,?,?,?)";

     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection(url, uid, pwd);
     //Statement st = con.createStatement();
     PreparedStatement st = con.prepareStatement(sql);
     st.setInt(1,id);
     st.setString(2,title);
     st.setString(3,writerId);
     st.setDate(4, (java.sql.Date) regdate);

     int  result = st.executeUpdate();





     st.close();
     con.close();
    return result;
}
 public  int update(Notice notice) throws SQLException, ClassNotFoundException {
     String title =notice.getTitle();
     String content =notice.getContent();
     String files = notice.getFiles();
     int id = notice.getId();
     String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
     String sql = "update notice " +
             "set " +
             "title=?," +
             "content=?," +
             "files=? " +
             " where id =?";

     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection(url, uid, pwd);
     //Statement st = con.createStatement();
     PreparedStatement st = con.prepareStatement(sql);
     st.setString(1,title);
     st.setString(2,content);
     st.setString(3,files);
     st.setInt(4,id);

     int  result = st.executeUpdate();





     st.close();
     con.close();
        return result;
    }
    public  int delete(int id) throws SQLException, ClassNotFoundException {

        String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
        String sql = "DELETE NOTICE where id =?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, uid, pwd);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1,id);

        int  result = st.executeUpdate();


        st.close();
        con.close();
        return result;
    }


}
