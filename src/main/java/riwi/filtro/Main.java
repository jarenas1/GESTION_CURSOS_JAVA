package riwi.filtro;

import riwi.filtro.controller.CourseController;
import riwi.filtro.entities.CourseEntity;
import riwi.filtro.entities.GradeEntity;
import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.model.CourseModel;
import riwi.filtro.model.GradeModel;
import riwi.filtro.model.InscriptionModel;
import riwi.filtro.model.StudentModel;
import riwi.filtro.persistence.dbConnection.Connect;
import riwi.filtro.tools.Status;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JOptionPane.showInternalMessageDialog(null, "Bienvenido");
        CourseController courseController = new CourseController();
        boolean menu1 = true;

        while (menu1){
            String op1 = JOptionPane.showInputDialog("""
                    Welcome to RiwiCourses: \n
                    1. Courses \n
                    2. Students \n
                    3. Inscriptions \n
                    4. Grades \n
                    5. Exit \n
                    Option:""");

            switch (op1){
                case "1" -> {

                    String op2 = JOptionPane.showInputDialog("""
                    Welcome toCourses: \n
                    1. Create \n
                    2. Delete \n
                    3. Read All \n
                    4. Update \n
                    Option:""");

                    if (op2.equals("1")){
                        String name = JOptionPane.showInputDialog("Introduce the course Name");
                        courseController.create(name);
                    } else if (op2.equals("2")) {
                        String toDelete = JOptionPane.showInputDialog("Introduce the id of the course to delete");
                        courseController.delete(Integer.valueOf(toDelete));
                    } else if (op2.equals("3")) {
                        JOptionPane.showInternalConfirmDialog(null,courseController.readAll());
                    } else if (op2.equals("4")) {
                        String id = JOptionPane.showInputDialog("Introduce the course id");
                        String name = JOptionPane.showInputDialog("Introduce the course Name");
                        courseController.update(Integer.valueOf(id),name);
                    } else{
                        JOptionPane.showInternalMessageDialog(null, "Select an valid option");

                    }

                }
                case "2" -> {


                }
                case "3" -> {



                }
                case "4" -> {

                }

                case "5" -> {menu1 = false;}
            }

        }

    }
}