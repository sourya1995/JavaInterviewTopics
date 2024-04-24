package Singletons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCSingleton {

    private static JDBCSingleton jdbc;

    private JDBCSingleton() {
    }

    public static JDBCSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new JDBCSingleton();
        }
        return jdbc;
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/username", "root", "root1234");
        return conn;
    }

    public int insert(String name, String pass){
        Connection c = null;
        PreparedStatement ps = null;
        int recordCounter = 0;

        try {
            c1 = this.getConnection();
            ps = c1.prepareStatement("INSERT INTO USERDATA(uname, password)VALUES(?, ?)");
            ps.setString(1, name);
            ps.setString(2, pass);
            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                ps.close();
            } if(c1 != null){
                c1.close();
            }
        }
        return recordCounter;
    }

    public void view(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.getConnection();
            ps = conn.prepareStatement("select * from userdata where uname = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Name=" + rs.getString(2) + "\t" + "Password=" + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(rs != null) {
                rs.close();
            }if(ps != null){
                ps.close();
            }if(con != null){
                con.close();
            }
        }
    }

    public int update(String name, String password){
        Connection c = null;
        PreparedStatement ps = null;
        int recordCounter = 0;
        try {
            c1 = this.getConnection();
            ps = c.prepareStatement("update userdata set password=? where uname=' "+name+" '");
            ps.setString(1, password);
            recordCounter = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null){
                ps.close();
            }if(c1 != null){
                c1.close();
            }
        }
        return recordCounter;
    }

    public int delete(int userId) {
        Connection c = null;
        PreparedStatement ps = null;
        int recordCounter = 0;
        try {
            c1 = this.getConnection();
            ps = c1.prepareStatement("delete from userdata where uid = ' " + userId + " ' ");
            recordCounter = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            } if(c1 != null){
                c1.close();
            }
        }
        return recordCounter;
    }
}
