package riwi.filtro;

import riwi.filtro.model.StudentModel;
import riwi.filtro.persistence.dbConnection.Connect;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("HOLA");

        StudentModel ss = new StudentModel();

        ss.readStudentCourses(1);
    }
}