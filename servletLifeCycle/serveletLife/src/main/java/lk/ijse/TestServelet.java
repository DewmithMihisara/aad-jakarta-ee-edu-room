package lk.ijse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServelet extends HttpServlet {
//    static {
//        System.out.println("MyServlet class is loaded");
//    }
    public TestServelet(){
        System.out.println("MyServlet() : constructor : TestServelet");
    }
//    @Override
//    public void init() throws ServletException {
//        System.out.println("init() : method");
//    }
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println("init(ServeletConfig) : method");
//        super.init(config);
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doGet() : method : TestServelet");
//    }
}
