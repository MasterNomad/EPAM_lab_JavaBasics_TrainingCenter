package service;

import dto.Course;
import dto.Curriculum;
import dto.Student;
import repository.StudentRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public int getRemainingDaysByStudent(Student student) {
        int remainingDays = getCurriculumDuration(student.getCurriculum()) - (int) DAYS.between(student.getStartDate(), LocalDate.now());
        return remainingDays < 0 ? 0 : remainingDays;
    }

    public double getAverageMarkByStudent(Student student) {
        double value = student.getMarks().stream().mapToDouble(a -> a).average().orElse(0);

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Возвращает -1, если студент однознаяно будет отчислен
    // 1 если студент не будет отчислен ни при каких обстоятельствах
    // 0 если будующее студента не определено
    public int isStudentCanBeKickOut(Student student) {
        double currentAverageMark = getAverageMarkByStudent(student);
        int curriculumDuration = getCurriculumDuration(student.getCurriculum());
        int remainingDays = getRemainingDaysByStudent(student);

        double bestPossibleAverageMark = ((currentAverageMark * (curriculumDuration - remainingDays)) + 5 * remainingDays) / curriculumDuration;
        double worstPossibleAverageMark = ((currentAverageMark * (curriculumDuration - remainingDays)) + remainingDays) / curriculumDuration;

        if (worstPossibleAverageMark > 4.5) {
            return 1;
        }
        if (bestPossibleAverageMark < 4.5) {
            return -1;
        }
        return 0;
    }

    private int getCurriculumDuration(Curriculum curriculum) {
        int curriculumDuration = 0;

        for (Course course : curriculum.getCourses()) {
            curriculumDuration += Math.ceil(course.getDuration() / 8.0);
        }

        return curriculumDuration;
    }

}
