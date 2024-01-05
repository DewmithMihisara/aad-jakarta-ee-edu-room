package lk.ijse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servelet1", value = "/test")
public class ServeletExactMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Servelet 1</h1>");

        System.out.println("=============Exact Mapping============");
        System.out.println("context path : "+request.getContextPath());
        System.out.println("path info : "+request.getPathInfo());
        System.out.println("servelet path : "+request.getServletPath());
        System.out.println("path translated: "+request.getPathTranslated());
        System.out.println("query string : "+request.getQueryString());
        System.out.println("request uri : "+request.getRequestURI());
        System.out.println("request url : "+request.getRequestURL());
        System.out.println(request.getProtocol());
        System.out.println(request.getScheme());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(request.getMethod());
    }
}
