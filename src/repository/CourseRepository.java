package repository;

import data.CourseData;
import dto.Course;

public class CourseRepository {

    public Course getCourseByTitle (String title) {
        return CourseData.getCourses().stream().filter(course -> course.getTitle().equals(title)).findFirst().orElse(null);
    }

}
