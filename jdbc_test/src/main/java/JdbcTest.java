import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://192.168.228.130:3306/gkyrqy?useUnicode=true&amp&characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="sa123456";
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from test");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("id")+" "
                    +rs.getString("name"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
