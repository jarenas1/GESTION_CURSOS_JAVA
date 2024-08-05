package riwi.filtro.model;

import riwi.filtro.entities.GradeEntity;
import riwi.filtro.persistence.IModel.IModelGrade;

import java.util.List;

public class GradeModel implements IModelGrade {
    @Override
    public boolean create(GradeEntity objeto) {
        return false;
    }

    @Override
    public boolean delete(Integer identidicador) {
        return false;
    }

    @Override
    public List<GradeEntity> readAll() {
        return List.of();
    }

    @Override
    public List<GradeEntity> readInteger(Integer dato) {
        return List.of();
    }

    @Override
    public boolean update(GradeEntity objeto) {
        return false;
    }
}
