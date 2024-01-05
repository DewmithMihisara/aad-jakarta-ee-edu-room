package lk.ijse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet3", value = "*.html")
public class ServletExtensionMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Servelet 3</h1>");

        System.out.println("=============extension Mapping============");
        System.out.println("context path : "+request.getContextPath());
        System.out.println("path info : "+request.getPathInfo());
        System.out.println("servelet path : "+request.getServletPath());
        System.out.println("path translated: "+request.getPathTranslated());
        System.out.println("query string : "+request.getQueryString());
        System.out.println("request uri : "+request.getRequestURI());
        System.out.println("request url : "+request.getRequestURL());
    }
}
