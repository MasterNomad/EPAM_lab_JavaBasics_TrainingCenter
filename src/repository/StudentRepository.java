package repository;

import data.StudentData;
import dto.Student;

import java.util.List;

public class StudentRepository {

    public Student getStudentById (long id) {
        return StudentData.getStudents().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAllStudents() {
        return StudentData.getStudents();
    }

}
