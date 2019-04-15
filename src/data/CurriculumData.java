package data;

import dto.Course;
import dto.Curriculum;
import repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CurriculumData {

    private static List<Curriculum> curriculums = new ArrayList<>();

    public static List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public static void fillCurriculums() {
        CourseRepository courseRepository = new CourseRepository();

        List<Course> courses = new ArrayList<>();

        courses.add(courseRepository.getCourseByTitle("VCS"));
        courses.add(courseRepository.getCourseByTitle("Java basics"));
        courses.add(courseRepository.getCourseByTitle("Build tools"));
        courses.add(courseRepository.getCourseByTitle("Unit testing"));
        courses.add(courseRepository.getCourseByTitle("Advanced Java"));

        curriculums.add(new Curriculum(1L, "Java RD", courses));

        courses.clear();
        courses.add(courseRepository.getCourseByTitle("Технология Java Servlets"));
        courses.add(courseRepository.getCourseByTitle("Struts Framework"));
        courses.add(courseRepository.getCourseByTitle("Hibernate"));
        courses.add(courseRepository.getCourseByTitle("Advanced Java"));

        curriculums.add(new Curriculum(2L, "Java Developer ", courses));

        courses.clear();
        courses.add(courseRepository.getCourseByTitle("Обзор технологий Java"));
        courses.add(courseRepository.getCourseByTitle("Библиотека JFC/Swing"));
        courses.add(courseRepository.getCourseByTitle("Технология JAX"));
        courses.add(courseRepository.getCourseByTitle("Библиотеки commons"));

        curriculums.add(new Curriculum(3L, "J2EE Developer", courses));
    }
}
