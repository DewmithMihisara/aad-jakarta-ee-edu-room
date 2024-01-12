package lk.ijse.management;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.management.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JsonBindServelet", urlPatterns = "/json")
public class JsonBindServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student("S001", "Kamal", 23);
        Student student1 = new Student("S002", "Nimal", 24);

//        Jsonb jsonb = JsonbBuilder.create();
//        String json = jsonb.toJson(student);
//        resp.getWriter().write(json);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        Jsonb jsonb = JsonbBuilder.create();

//        String json = jsonb.toJson(students);
//        resp.getWriter().write(json);

        jsonb.toJson(students, resp.getWriter());
    }
}
