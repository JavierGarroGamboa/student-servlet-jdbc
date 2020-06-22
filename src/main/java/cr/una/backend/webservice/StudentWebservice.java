package cr.una.backend.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.una.backend.model.Student;
import cr.una.backend.service.StudentService;
import cr.una.backend.service.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * REST Web Service
 *
 * @author mike.education
 */
@WebServlet(name = "StudentWebservice", urlPatterns = {"students"}, loadOnStartup = 1)
public class StudentWebservice extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private StudentService studentService = new StudentServiceImpl();

    /**
     * Retrieves All the Students
     * URL/students
     * URL/students?id=1
     *
     * @return Student
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String json = null;
        String param = request.getParameter("id");
        try {
            if (param != null) {
                int id = Integer.valueOf(param);
                Student student = studentService.findById(id);
                json = mapper.writeValueAsString(student);
            } else {
                List<Student> studentList = null;
                studentList = studentService.findAll();
                json = mapper.writeValueAsString(studentList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String json = null;

        String id = request.getParameter("id");
        String name = request.getHeader("name");
        String course = request.getHeader("course");
        String rating = request.getParameter("rating");

        Student newStudent = new Student(9, "Santiago", "Sistemas Operativos", "A");
        try {
            Student students = studentService.save(newStudent);
            json = mapper.writeValueAsString(students);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String json = null;

        Student newStudent = new Student(9, "Javier", "Sistemas Operativos", "A");
        try {
            Student students = studentService.update(newStudent);
            json = mapper.writeValueAsString(students);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String json = null;
        String param = request.getParameter("id");
        try {
            if (param != null) {
                int id = Integer.valueOf(param);
                boolean isDelete = studentService.delete(id);
                json = mapper.writeValueAsString(isDelete);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);
    }
}
