package riwi.filtro.model;

import riwi.filtro.entities.StudentEntity;
import riwi.filtro.persistence.IModel.IModelStudent;
import riwi.filtro.tools.Status;

import java.util.List;

public class StudentModel implements IModelStudent {
    @Override
    public boolean updateName(int id, String name) {
        return false;
    }

    @Override
    public boolean updateLastName(int id, String lastName) {
        return false;
    }

    @Override
    public boolean updateEmail(int id, String email) {
        return false;
    }

    @Override
    public boolean updateStatus(int id, Status status) {
        return false;
    }

    @Override
    public List<StudentEntity> activateStudents(Status status) {
        return List.of();
    }

    @Override
    public boolean create(StudentEntity objeto) {
        return false;
    }

    @Override
    public boolean delete(Integer identidicador) {
        return false;
    }

    @Override
    public List<StudentEntity> readAll() {
        return List.of();
    }

    @Override
    public List<StudentEntity> readInteger(Integer dato) {
        return List.of();
    }

    @Override
    public List<StudentEntity> readString(String dato) {
        return List.of();
    }

    @Override
    public boolean update(StudentEntity objeto) {
        return false;
    }
}
