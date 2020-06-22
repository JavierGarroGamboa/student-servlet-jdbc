package cr.una.backend.service;

import cr.una.backend.dao.StudentDAO;
import cr.una.backend.dao.StudentDAOImpl;
import cr.una.backend.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDAO studentDAO;
    List<Student> listStudents = null;

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> listStudents = new ArrayList<Student>();
        studentDAO = new StudentDAOImpl();
        listStudents = studentDAO.findAll();
        return listStudents;
    }

    @Override
    public Student findById(int id) throws SQLException {
        Student student = null;
        studentDAO = new StudentDAOImpl();
        student = studentDAO.findById(id);
        return student;
    }

    @Override
    public Student save(Student office) throws SQLException {
        Student StudentSaved;
        studentDAO = new StudentDAOImpl();
        StudentSaved = studentDAO.save(office);
        return StudentSaved;
    }

    @Override
    public Student update(Student student) throws SQLException{
        Student studentUpdate;
        studentDAO = new StudentDAOImpl();
        studentUpdate = studentDAO.update(student);
        return studentUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException{
        boolean isDeleted;
        studentDAO = new StudentDAOImpl();
        isDeleted = studentDAO.delete(id);
        return isDeleted;
    }

}
