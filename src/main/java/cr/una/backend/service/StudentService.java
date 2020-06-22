package cr.una.backend.service;

import cr.una.backend.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    public List<Student> findAll() throws SQLException;

    public Student findById(int id) throws SQLException;

    public Student save(Student student) throws SQLException;

    public Student update(Student student) throws SQLException;

    public boolean delete(int id) throws SQLException;
}
