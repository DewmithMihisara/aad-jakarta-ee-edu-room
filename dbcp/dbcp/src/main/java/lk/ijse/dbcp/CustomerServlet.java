package lk.ijse.dbcp;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbcp2.BasicDataSource;

@WebServlet(name = "cusServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");
        try {
            Connection connection = dbcp.getConnection();
            System.out.println(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}