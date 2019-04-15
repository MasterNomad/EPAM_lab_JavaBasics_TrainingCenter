package demo;

import data.CourseData;
import data.CurriculumData;
import data.StudentData;
import repository.StudentRepository;
import service.ShowService;

public class Demo {

    private StudentRepository studentRepository = new StudentRepository();
    private ShowService showService = new ShowService();

    public void execute() {
        fillData();

        showService.showStudentsByAverageMark();
        System.out.println("________________________________");
        showService.showStudentsByDaysRemaining();
        System.out.println("________________________________");
        showService.aboutStudent(studentRepository.getStudentById(3L));
    }

    private void fillData() {
        CourseData.fillCourses();
        CurriculumData.fillCurriculums();
        StudentData.fillStudents();
    }

}
