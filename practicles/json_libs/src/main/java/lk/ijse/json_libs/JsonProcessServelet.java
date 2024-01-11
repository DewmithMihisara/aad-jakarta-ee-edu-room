package lk.ijse.json_libs;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "jsonProcessServelet",urlPatterns = "/json")
public class JsonProcessServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//       ================== json read  ==================

//        System.out.println("==========without json-p lib==========");
//        BufferedReader reader = req.getReader();
//        String line;
//        String json="";
//        while((line = reader.readLine()) != null) {
//            json += line +"\n";
//        }
//        System.out.println(json);

//        System.out.println("==========with json-p lib==========");
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//        System.out.println(jsonObject);

//        ================== json write  ==================

        System.out.println("==========with json-p lib==========");
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id","c001");
        builder.add("name","kamal");
        builder.add("address","colombo");
        JsonObject build = builder.build();
        resp.getWriter().write(build.toString());
    }
}
