package riwi.filtro.model;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.persistence.IModel.IModelCourse;

import java.util.List;

public class CourseModel implements IModelCourse {
    @Override
    public boolean create(CourseEntity objeto) {
        return false;
    }

    @Override
    public boolean delete(Integer identidicador) {
        return false;
    }

    @Override
    public List<CourseEntity> readAll() {
        return List.of();
    }

    @Override
    public List<CourseEntity> readInteger(Integer dato) {
        return List.of();
    }

    @Override
    public List<CourseEntity> readString(String dato) {
        return List.of();
    }

    @Override
    public boolean update(CourseEntity objeto) {
        return false;
    }
}
