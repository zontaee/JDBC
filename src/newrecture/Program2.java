package newrecture;


import java.sql.*;

public class Program2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String title ="Test2";
        String writerId = "newlec";
        String content = "haha";
        String files = "";
        String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
        String sql = "insert into notice(" +
                "title," +
                "writer_id," +
                "content," +
                "files)" +
                "VALUES(?,?,?,?)";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "newlec", "dlsxo123");
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);

        int  result = st.executeUpdate();
         System.out.println(result);




        st.close();
        con.close();
    }
}