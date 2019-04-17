package demo;

import dto.Course;
import dto.Curriculum;
import dto.Student;
import repository.CourseRepository;
import repository.CurriculumRepository;
import repository.StudentRepository;
import service.ShowService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DemoService {

    private StudentRepository studentRepository = new StudentRepository();
    private CourseRepository courseRepository = new CourseRepository();
    private CurriculumRepository curriculumRepository = new CurriculumRepository();

    private ShowService showService = new ShowService(studentRepository);

    public DemoService() {
        fillData();
    }

    public void execute() {
        showService.showStudentsByAverageMark();
        System.out.println("________________________________");
        showService.showStudentsByRemainingDays();
        System.out.println("________________________________");
        showService.aboutStudent(studentRepository.getStudentById(1L));
    }

    private void fillData() {
        List<Course> courses = Arrays.asList(
                new Course(1L, "VCS", 20),
                new Course(2L, "Java basics", 40),
                new Course(3L, "Build tools", 16),
                new Course(4L, "Unit testing", 30),
                new Course(5L, "Advanced Java", 48),
                new Course(6L, "Технология Java Servlets", 16),
                new Course(7L, "Struts Framework", 24),
                new Course(8L, "Hibernate", 20),
                new Course(9L, "Advanced Java", 48),
                new Course(10L, "Обзор технологий Java", 8),
                new Course(11L, "Библиотека JFC/Swing", 16),
                new Course(12L, "Технология JDBC", 16),
                new Course(13L, "Технология JAX", 52),
                new Course(14L, "Библиотеки commons", 44));
        courseRepository.addCourses(courses);

        List<Curriculum> curriculumList = Arrays.asList(
                new Curriculum(1L, "Java RD", Arrays.asList(courseRepository.getCourseByTitle("VCS"),
                        courseRepository.getCourseByTitle("Java basics"),
                        courseRepository.getCourseByTitle("Build tools"),
                        courseRepository.getCourseByTitle("Unit testing"),
                        courseRepository.getCourseByTitle("Advanced Java"))),
                new Curriculum(2L, "Java Developer", Arrays.asList(
                        courseRepository.getCourseByTitle("Технология Java Servlets"),
                        courseRepository.getCourseByTitle("Struts Framework"),
                        courseRepository.getCourseByTitle("Hibernate"),
                        courseRepository.getCourseByTitle("Advanced Java"))),
                new Curriculum(3L, "J2EE Developer", Arrays.asList(
                        courseRepository.getCourseByTitle("Обзор технологий Java"),
                        courseRepository.getCourseByTitle("Библиотека JFC/Swing"),
                        courseRepository.getCourseByTitle("Технология JAX"),
                        courseRepository.getCourseByTitle("Библиотеки commons"))));
        curriculumRepository.addCurriculumList(curriculumList);

        List<Student> students = Arrays.asList(
                new Student(1L, "Petrov Petr", curriculumRepository.getCurriculumById(1), LocalDate.now().minusDays(7), createMarks(7)),
                new Student(2L, "Ivanov Ivan", curriculumRepository.getCurriculumById(2), LocalDate.now().minusDays(2), createMarks(2)),
                new Student(3L, "Vasiliev Vasiliy", curriculumRepository.getCurriculumById(3), LocalDate.now().minusDays(20), createMarks(20)),
                new Student(4L, "Iliyn Ilya", curriculumRepository.getCurriculumById(1), LocalDate.now().minusDays(15), createMarks(15)),
                new Student(5L, "Nikitin Nikita", curriculumRepository.getCurriculumById(3), LocalDate.now().minusDays(6), createMarks(6)));
        studentRepository.addStudents(students);
    }

    private List<Integer> createMarks(int quantity) {
        List<Integer> marks = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            marks.add(ThreadLocalRandom.current().nextInt(3, 6));
        }
        return marks;
    }
}
