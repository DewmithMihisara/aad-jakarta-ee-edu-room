package lk.ijse.annotation;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "HelloServlet", value = "/HelloServlet", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "userName", value = "root"),
        @WebInitParam(name = "password", value = "Dew@2005"),
        @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/jakartaTest?createDatabaseIfNotExist=true")
})
public class HelloServlet extends HttpServlet {
    private String usrName;
    private String password;
    private String url;
    @Override
    public void init() throws ServletException {
        ServletConfig sc=getServletConfig();
        usrName=sc.getInitParameter("userName");
        password=sc.getInitParameter("password");
        url=sc.getInitParameter("url");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String address = req.getParameter("address");

            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url,usrName,password);
            PreparedStatement ps=connection.prepareStatement("INSERT INTO student(id,name,address) VALUES (?,?,?)");

            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,address);

            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String address = req.getParameter("address");

            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url,usrName,password);
            PreparedStatement ps=connection.prepareStatement("UPDATE student SET name=?,address=? WHERE id=?");

            ps.setString(1,name);
            ps.setString(2,address);
            ps.setString(3,id);

            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            String id = req.getParameter("id");

            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url,usrName,password);
            PreparedStatement ps=connection.prepareStatement("DELETE FROM student WHERE id=?");

            ps.setString(1,id);

            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}