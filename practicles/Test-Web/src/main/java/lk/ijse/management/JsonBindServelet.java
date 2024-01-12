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

//        ===========serialization================
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        ===========deserialization================
//        Jsonb jsonb = JsonbBuilder.create();
//        Student student = jsonb.fromJson(req.getReader(), Student.class);
//        System.out.println(student);

//        Jsonb jsonb = JsonbBuilder.create();
//        ArrayList<Student> students = jsonb.fromJson(req.getReader(), new ArrayList<Student>(){}.getClass().getGenericSuperclass());
//        System.out.println(students);

//        ArrayList student = JsonbBuilder.create().fromJson(req.getReader(), ArrayList.class);
//        System.out.println(student);

        Jsonb jsonb = JsonbBuilder.create();
        Student[] student = jsonb.fromJson(req.getReader(), Student[].class);
        for (Student student1 : student) {
            System.out.println(student1);
        }
    }
}
