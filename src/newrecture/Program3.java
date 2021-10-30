package newrecture;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String title ="Test3";
        String content = "hahaha";
        String files = "";
        int id = 12;
        String url = "jdbc:oracle:thin:@220.94.153.57:1521/xepdb1";
        String sql = "update notice " +
                "set " +
                "title=?," +
                "content=?," +
                "files=? " +
                " where id =?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "newlec", "dlsxo123");
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);

        int  result = st.executeUpdate();
         System.out.println(result);




        st.close();
        con.close();
    }
}