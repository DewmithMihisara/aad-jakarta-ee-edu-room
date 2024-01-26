package lk.ijse.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.dbcp2.BasicDataSource;

@WebListener(value = "seveletContextListener")
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BasicDataSource dbcp=new BasicDataSource();
        dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbcp.setUsername("root");
        dbcp.setPassword("Dew@2005");
        dbcp.setUrl("jdbc:mysql://localhost:3306/gdse66_hello");

        dbcp.setInitialSize(5);
        dbcp.setMaxTotal(10);
        sce.getServletContext().setAttribute("dbcp",dbcp);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
