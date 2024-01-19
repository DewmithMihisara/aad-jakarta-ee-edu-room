package lk.ijse.kadepitipassa.model;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name = "Customer", urlPatterns = "/customers", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "username" , value = "root"),
        @WebInitParam(name = "password" , value = "Dew@2005"),
        @WebInitParam(name = "url" , value = "jdbc:mysql://localhost:3306/gdse66_hello")
})
public class CustomerServlet extends HttpServlet {
    private String username;
    private String password;
    private String url;

    @Override
    public void init() throws ServletException {
        ServletConfig sc = getServletConfig();
        username = ((ServletConfig) sc).getInitParameter("username");
        password = sc.getInitParameter("password");
        url = sc.getInitParameter("url");
    }

}
