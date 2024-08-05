package riwi.filtro.persistence.IModel;

import riwi.filtro.entities.StudentEntity;
import riwi.filtro.persistence.CRUD.*;
import riwi.filtro.tools.Status;

import java.util.List;

public interface IModelStudent extends Create<StudentEntity>, Delete<Integer>, ReadAll<StudentEntity>, ReadString<StudentEntity,String>, ReadInteger<StudentEntity,Integer>,Update<StudentEntity> {

    boolean updateName(int id, String name);

    boolean updateLastName(int id, String lastName);

    boolean updateEmail(int id, String email);

    boolean updateStatus(int id, Status status);

    void readStudentCoursesID(int id);

    void readStudentCoursesEmail(String email);

    List<StudentEntity> activateStudents(Status status);

}
