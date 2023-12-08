package lk.ijse.helloservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("myServlet 2");
//        ServletConfig sc=getServletConfig();
//        String name=sc.getInitParameter("city");
//        System.out.println(name);

        ServletContext servletContext=getServletContext();
        String usrName=servletContext.getInitParameter("userName");
        System.out.println(usrName);
    }
}
