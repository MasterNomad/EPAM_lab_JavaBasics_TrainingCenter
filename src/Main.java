import data.CourseData;
import data.CurriculumData;
import data.StudentData;

public class Main {

    public static void main(String[] args) {

        CourseData.fillCourses();
        CurriculumData.fillCurriculums();
        StudentData.fillStudents();

    }

}
