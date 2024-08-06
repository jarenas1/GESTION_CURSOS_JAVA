package riwi.filtro.controller;

import riwi.filtro.entities.StudentEntity;
import riwi.filtro.model.StudentModel;
import riwi.filtro.persistence.IModel.IModelStudent;
import riwi.filtro.tools.Status;

import java.util.List;

public class StudentController {
    private final IModelStudent modelStudent;

    public StudentController(){
        this.modelStudent = new StudentModel();
    }

    public boolean create(String name, String lastName, String email, Status status){
        return this.modelStudent.create(new StudentEntity(name,lastName,email,status));
    }

    public boolean delete (Integer id){
        return this.modelStudent.delete(id);
    }

    public void eadStudentCoursesID(int id){
         this.modelStudent.readStudentCoursesID(id);
    }

    public void readStudentCoursesEmail(String email){
        this.modelStudent.readStudentCoursesEmail(email);
    }
    public List<StudentEntity> activateStudents(Status status){
        return this.modelStudent.activateStudents(status);
    }

    public boolean updateName(int id, String name){
        return this.modelStudent.updateName(id,name);
    }

    public boolean updateLastName(int id, String lastName){
        return this.modelStudent.updateLastName(id,lastName);
    }

    public boolean updateEmail(int id, String email){
        return this.modelStudent.updateEmail(id,email);
    }

    public boolean updateStatus(int id, Status status){
        return this.modelStudent.updateStatus(id,status);
    }

    public boolean update(int id, String name, String lastName, String email, Status status){
        return this.modelStudent.update(new StudentEntity(id,name,lastName,email,status));
    }
}
