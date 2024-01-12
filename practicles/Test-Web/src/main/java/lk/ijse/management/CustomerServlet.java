package lk.ijse.management;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.management.dto.CustomerDTO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "Customer", urlPatterns = "/customers", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "username", value = "root"),
        @WebInitParam(name = "password", value = "Dew@2005"),
        @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/gdse66_hello")
})
public class CustomerServlet extends HttpServlet {
    private String username;
    private String password;
    private String url;

    @Override
    public void init() throws ServletException {
        ServletConfig sc = getServletConfig();
        username = sc.getInitParameter("username");
        password = sc.getInitParameter("password");
        url = sc.getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ==================this for get data=================

//        Writer writer = resp.getWriter();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = stm.executeQuery();
//            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            ArrayList<CustomerDTO> customerDTOArrayList = new ArrayList<>();
            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String name = resultSet.getString("name");
//                String address = resultSet.getString("address");
//
//                JsonObjectBuilder builder = Json.createObjectBuilder();
//                builder.add("id",id);
//                builder.add("name",name);
//                builder.add("address",address);
//                JsonObject build = builder.build();
//                arrayBuilder.add(build);
                customerDTOArrayList.add(new CustomerDTO(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("address")));
            }

//            resp.getWriter().write(arrayBuilder.build().toString());
            Jsonb jsonb = JsonbBuilder.create();
            jsonb.toJson(customerDTOArrayList, resp.getWriter());
            resp.setContentType("application/json");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

//        =======================how to send data to client example======================

//        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
//
//        objectBuilder.add("id","C001");
//        objectBuilder.add("name","Kasun");
//
//        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
//        addressBuilder.add("no",123);
//        addressBuilder.add("street","Galle Road");
//        addressBuilder.add("city","Colombo");
//
//        objectBuilder.add("address",addressBuilder);
//
//        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//        arrayBuilder.add("077-1234567");
//        arrayBuilder.add("071-1234567");
//
//        objectBuilder.add("cntact",arrayBuilder);
//
//        JsonObject build = objectBuilder.build();
//        resp.getWriter().write(build.toString());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ==============this for save data=================


        Connection connection = null;
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//
//        String id = jsonObject.getString("id");
//        String name = jsonObject.getString("name");
//        String address = jsonObject.getString("address");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer(id, name, address) VALUES (?,?,?)");

//            stm.setString(1, id);
//            stm.setString(2, name);
//            stm.setString(3, address);
            stm.setString(1, customerDTO.getId());
            stm.setString(2, customerDTO.getName());
            stm.setString(3, customerDTO.getAddress());

            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

//        ===========how to get data from json object example================

//        {
//                "id": "C001",
//                "name": "Kasun",
//                "address": {
//                    "no": 123,
//                    "street": "Galle Road",
//                    "city": "Colombo"
//                },
//                "cntact": ["077-1234567", "071-1234567"]
//        }



//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//        System.out.println(jsonObject);
//
//        String id = jsonObject.getString("id");
//        String name = jsonObject.getString("name");
//        JsonObject addressJsonObj = jsonObject.getJsonObject("address");
//
//        int no = addressJsonObj.getInt("no");
//        String street = addressJsonObj.getString("street");
//        String city = addressJsonObj.getString("city");
//
//        JsonArray cntactJsonArray = jsonObject.getJsonArray("cntact");
//        String firstContact = cntactJsonArray.getString(0);
//        String secondContact = cntactJsonArray.getString(1);
//
//        System.out.println("id: "+id);
//        System.out.println("name: "+name);
//        System.out.println("no: "+no);
//        System.out.println("street: "+street);
//        System.out.println("city: "+city);
//        System.out.println("firstContact: "+firstContact);
//        System.out.println("secondContact: "+secondContact);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//
//        String id = jsonObject.getString("id");
//        String name = jsonObject.getString("name");
//        String address = jsonObject.getString("address");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("UPDATE customer SET name=?, address=? WHERE id=?");

//            stm.setString(1, name);
//            stm.setString(2, address);
//            stm.setString(3, id);
            stm.setString(1, customerDTO.getName());
            stm.setString(2, customerDTO.getAddress());
            stm.setString(3, customerDTO.getId());

            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//
//        String id = jsonObject.getString("id");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("DELETE FROM customer WHERE id=?");

//            stm.setString(1, id);
            stm.setString(1, customerDTO.getId());

            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
