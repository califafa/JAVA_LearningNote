import java.sql.*;
//import com.mysql.cj.jdbc.Driver;

public class testJdbc01{
    public static void main(String[] args) throws Exception{

        String Url="jdbc:mysql://localhost:3306/db01?serverTimezone=UTC";
        String User="root";
        String Passwd="MySQL";
        Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();
        System.out.println("forName completed");
        Connection conn=DriverManager.getConnection(Url,User,Passwd);
        System.out.println("Connected");
        Statement st=conn.createStatement();
        //st.executeQuery("CREATE DATABASE db02");
        //st.executeQuery("USE db01");
        ResultSet rs=st.executeQuery("select * from users where id=1 || name='val'");
        while(rs.next()){
            System.out.println(rs.getString("id")+" - "+rs.getString("name"));
        }
    }
}