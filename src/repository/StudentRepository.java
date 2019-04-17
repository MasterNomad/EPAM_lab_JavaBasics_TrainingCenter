package repository;

import dto.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new LinkedList<>();

    public Student getStudentById(long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudents (List<Student> students) {
        this.students.addAll(students);
    }


}
