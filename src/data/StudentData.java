package data;

import dto.Student;
import repository.CurriculumRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudentData {

    private static List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students;
    }

    public static void fillStudents() {

        CurriculumRepository curriculumRepository = new CurriculumRepository();

        students.add(new Student(1L, "Petrov Petr", curriculumRepository.getCurriculumById(1), LocalDate.now().minusDays(7), createMarks(7)));
        students.add(new Student(1L, "Ivanov Ivan", curriculumRepository.getCurriculumById(2), LocalDate.now().minusDays(2), createMarks(2)));
        students.add(new Student(1L, "Vasiliev Vasiliy", curriculumRepository.getCurriculumById(3), LocalDate.now().minusDays(20), createMarks(20)));
        students.add(new Student(1L, "Iliyn Ilya", curriculumRepository.getCurriculumById(1), LocalDate.now().minusDays(15), createMarks(15)));
        students.add(new Student(1L, "Nikitin Nikita", curriculumRepository.getCurriculumById(3), LocalDate.now().minusDays(6), createMarks(6)));
    }

    private static List<Integer> createMarks(int quantity) {

        List<Integer> marks = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            marks.add(ThreadLocalRandom.current().nextInt(3, 5 + 1));
        }

        return marks;
    }
}
