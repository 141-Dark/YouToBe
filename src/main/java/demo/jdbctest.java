package demo;

import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class jdbctest {
    @Test
    public void test() throws SQLException {
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    @Test
    public  void test1() throws SQLException, ClassNotFoundException {
       /* driver = com.mysql.jdbc.Driver
        url = jdbc:mysql://localhost:3306/javaweb?rewriteBatchedStatements=true
        user = root
        pwd = root*/
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8","root","root");
        System.out.println(con);
        con.close();
    }

    @Test
    public void te() throws SQLException {
        Connection con = JdbcUtils.getConnection();

        String sql = "insert into customers values(?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql);


        pstmt.setObject(1,"12asq3");
        pstmt.setObject(2,"hha");
        pstmt.setObject(3,"as");
        pstmt.setObject(4,"123");
        pstmt.executeUpdate();
        con.close();
    }
    @Test
    public void test4() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb","root","root");


        String sql = "insert into customer values(?,?,?,?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setObject(1,"14213");
        pstmt.setObject(2,"hh232a");
        pstmt.setObject(3,"as23");
        pstmt.setObject(4,"12233");
        pstmt.setObject(5,"1s54");
        pstmt.setObject(6,"234");
        pstmt.setObject(7,"123");
        pstmt.executeUpdate();
        con.close();

    }

    @Test
    public void test5() throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        String sql = "insert into customers values(?,?,?,?)";
        Object[] params = {"561a按12时s","che","123","da"};
        qr.update(sql,params);
    }

    @Test
    public void tset6() throws SQLException {
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }
    @Test
    public void test7() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = SQL.JdbcUtils.getConnection();
        System.out.println(connection);
    }
    @Test
    public void tset() throws SQLException, IOException, ClassNotFoundException {
        Connection con = SQL.JdbcUtils.getConnection();
        System.out.println(con);
        con.close();
    }
}
