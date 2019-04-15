package repository;

import data.StudentData;
import dto.Student;

public class StudentRepository {

    public Student getStudentById (long id) {
        return StudentData.getStudents().stream().filter(curriculum -> curriculum.getId() == id).findFirst().orElse(null);
    }

}
