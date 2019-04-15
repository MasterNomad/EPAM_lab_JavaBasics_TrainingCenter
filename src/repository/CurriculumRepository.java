package repository;

import data.CurriculumData;
import dto.Curriculum;

public class CurriculumRepository {

    public Curriculum getCurriculumByTitle (String title) {
        return CurriculumData.getCurriculums().stream().filter(curriculum -> curriculum.getTitle().equals(title)).findFirst().orElse(null);
    }

    public Curriculum getCurriculumById(long id) {
        return CurriculumData.getCurriculums().stream().filter(curriculum -> curriculum.getId() == id).findFirst().orElse(null);
    }
}
