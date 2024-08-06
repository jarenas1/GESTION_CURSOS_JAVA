package riwi.filtro.controller;

import riwi.filtro.entities.GradeEntity;
import riwi.filtro.model.GradeModel;
import riwi.filtro.persistence.IModel.IModelGrade;

import java.util.List;

public class GradeController {
    private final IModelGrade modelGrade;

    public GradeController (){
        this.modelGrade = new GradeModel();
    }

public boolean create (Double note, String description, int id_student, int id_course){
        return this.modelGrade.create(new GradeEntity(note,description,id_student,id_course));
}

public boolean delete (Integer id){
        return this.modelGrade.delete(id);
}

public List<GradeEntity> readAll(){
        return this.modelGrade.readAll();
}

public boolean update(int id, Double note, String description, int id_student, int id_course){
        return this.modelGrade.update(new GradeEntity(id,note,description,id_student,id_course));
}

}
