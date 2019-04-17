package repository;

import dto.Course;

import java.util.LinkedList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new LinkedList<>();

    public Course getCourseByTitle(String title) {
        return courses.stream().filter(course -> course.getTitle().equals(title)).findFirst().orElse(null);
    }

    public void addCourses (List<Course> courses) {
        this.courses.addAll(courses);
    }
}
