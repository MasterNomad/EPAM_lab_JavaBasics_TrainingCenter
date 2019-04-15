package dto;

import com.sun.javaws.progress.Progress;

import java.time.LocalDate;
import java.util.List;

public class Student {

    private long id;
    private String name;
    private Curriculum curriculum;
    private LocalDate startDate;
    private List<Integer> marks;

    public Student(long id, String name, Curriculum curriculum, LocalDate startDate, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.marks = marks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}
