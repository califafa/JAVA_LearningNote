import java.sql.*;
//import com.mysql.cj.jdbc.Driver;

public class testJdbc01{
    public static void main(String[] args) throws Exception{

        ResultSet rs1=Query1();
        rs1.previous();//previous one
        rs1.absolute(0);
        while(rs1.next()){
            System.out.println("row  "+rs1.getRow());
        }

        ResultSet rs2=Query2();
        rs2.absolute(0);
        while(rs2.next()){
            System.out.println("row  "+rs2.getRow());
        }
    }

    public static ResultSet Query1() throws Exception{        
        String Url="jdbc:mysql://localhost:3306/db01?serverTimezone=UTC";
        String User="root";
        String Passwd="MySQL";
        Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();
        System.out.println("forName completed");
        Connection conn=DriverManager.getConnection(Url,User,Passwd);
        System.out.println("Connected");
        String mySql="select * from users where id=? || name=?";
        PreparedStatement pst=conn.prepareStatement(mySql);
        pst.setInt(1, 3);
        pst.setString(2, "hel");
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("id")+" - "+rs.getString("name"));
        }
        return rs;
    }

    public static ResultSet Query2() throws Exception{
        String Url="jdbc:mysql://localhost:3306/db01?serverTimezone=UTC";
        String User="root";
        String Passwd="MySQL";
        Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();
        System.out.println("forName completed");
        Connection conn=DriverManager.getConnection(Url,User,Passwd);
        System.out.println("Connected");

        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select * from users where id=1 || name='val'");
        
        while(rs.next()){
            System.out.println(rs.getString("id")+" - "+rs.getString("name"));
        }
        return rs;
    }

}