package data;

import dto.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseData {

    private static List<Course> courses = new ArrayList<>();

    public static List<Course> getCourses() {
        return courses;
    }

    public static void fillCourses() {

        courses.add(new Course(1L, "VCS", 20));
        courses.add(new Course(2L, "Java basics", 40));
        courses.add(new Course(3L, "Build tools", 16));
        courses.add(new Course(4L, "Unit testing", 30));
        courses.add(new Course(5L, "Advanced Java", 48));

        courses.add(new Course(6L, "Технология Java Servlets", 16));
        courses.add(new Course(7L, "Struts Framework", 24));
        courses.add(new Course(8L, "Hibernate", 20));
        courses.add(new Course(9L, "Advanced Java", 48));

        courses.add(new Course(10L, "Обзор технологий Java", 8));
        courses.add(new Course(11L, "Библиотека JFC/Swing", 16));
        courses.add(new Course(12L, "Технология JDBC", 16));
        courses.add(new Course(13L, "Технология JAX", 52));
        courses.add(new Course(14L, "Библиотеки commons", 44));
    }
}