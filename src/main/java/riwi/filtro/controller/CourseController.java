package riwi.filtro.controller;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.model.CourseModel;
import riwi.filtro.persistence.IModel.IModelCourse;

import java.util.List;

public class CourseController {
    private final IModelCourse modelCourse;

    public CourseController(){
        this.modelCourse = new CourseModel();
    }
    //DEBE RECIBIR LAS COSAS PARA CREAR UN CURSO
    public boolean create(String name){
        return this.modelCourse.create(new CourseEntity(name));
    }

    public boolean delete (Integer id){
        return this.modelCourse.delete(id);
    }

    public List<CourseEntity> readAll(){
        return this.modelCourse.readAll();
    }

    public boolean update (Integer id, String name){
        return this.modelCourse.update(new CourseEntity(id,name));
    }
}
