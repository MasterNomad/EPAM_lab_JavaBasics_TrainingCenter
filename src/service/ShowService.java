package service;

import dto.Course;
import dto.Student;
import repository.StudentRepository;

import java.util.List;

public class ShowService {

    private StudentService studentService;
    private String format = "%-20s %-20s %-10s%n";

    public ShowService(StudentRepository studentRepository) {
        this.studentService = new StudentService(studentRepository);
    }

    public void showStudentsByAverageMark() {
        List <Student> sortStudents = studentService.getStudentsSortedByAverageMark();

        System.out.println("\tСортировка по средней оценке");
        System.out.format(format, "Студент", "Учебный план", "Средняя оценка");
        for (Student student : sortStudents) {
            System.out.format(format, student.getName(), student.getCurriculum().getTitle(), studentService.getAverageMarkByStudent(student));
        }
    }

    public void showStudentsByRemainingDays() {
        List<Student> sortStudents = studentService.getStudentsSortedByRemainingDays();

        System.out.println("\tСортировка по оставшимся дням");
        System.out.format(format, "Студент", "Учебный план", "Дней осталось");
        for (Student student : sortStudents) {
            System.out.format(format, student.getName(), student.getCurriculum().getTitle(), studentService.getRemainingDaysByStudent(student));
        }
    }

    public void aboutStudent(Student student) {
        System.out.format("Студент: %s%nУчебный план: %s%nНачало обучения: %s%n%n",
                student.getName(),
                student.getCurriculum().getTitle(),
                student.getStartDate());

        System.out.format("%-25s %s%n", "Курс", "Длительность (ч.)");
        System.out.println("----------------------------------------");
        for (Course course : student.getCurriculum().getCourses()) {
            System.out.format("%-25s %s%n", course.getTitle(), course.getDuration());
        }

        System.out.println("\nОценки:");
        List<Integer> marks = student.getMarks();
        for (int i = 0; i < marks.size(); i++) {
            System.out.print(marks.get(i));
            if (i != marks.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        showStudentStatus(student);
    }

    private void showStudentStatus(Student student) {
        int remainingDays = studentService.getRemainingDaysByStudent(student);
        double averageMark = studentService.getAverageMarkByStudent(student);
        String curriculumTitle = student.getCurriculum().getTitle();

        if (remainingDays == 0) {

            if (averageMark < 4.5) {
                System.out.format("Студент был исключён из программы %s со средним баллом: %.1f%n",
                        curriculumTitle,
                        averageMark);
            } else {
                System.out.format("Студент успешно окончил обучение по программе %s со средним баллом: %.1f",
                        curriculumTitle,
                        averageMark);
            }
        } else {
            int studentStatus = studentService.isStudentCanBeKickOut(student);
            System.out.format("До конца обучения по программе %s осталось %d дней. Средний бал: %.1f%n",
                    curriculumTitle,
                    remainingDays,
                    averageMark);
            if (studentStatus == 0 && averageMark < 4.5) {
                System.out.println("Студент может быть исключён, если не будет учиться лучше");
            }
            if (studentStatus == 0 && averageMark >= 4.5) {
                System.out.println("Студент имеет хорошие оценки, но нужно продолжать стараться");
            }
            if (studentStatus < 0) {
                System.out.println("Студент направлен на исключение");
            }
            if (studentStatus > 0) {
                System.out.println("Студент идёт на успешное окончание обучения!");
            }
        }
    }
}
