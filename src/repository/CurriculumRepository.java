package repository;

import dto.Curriculum;

import java.util.LinkedList;
import java.util.List;

public class CurriculumRepository {

    private List<Curriculum> curriculumList = new LinkedList<>();

    public Curriculum getCurriculumById(long id) {
        return curriculumList.stream().filter(curriculum -> curriculum.getId() == id).findFirst().orElse(null);
    }

    public void addCurriculumList(List <Curriculum> curriculumList) {
        this.curriculumList.addAll(curriculumList);
    }
}
