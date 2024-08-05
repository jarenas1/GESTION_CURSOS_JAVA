package riwi.filtro.model;

import riwi.filtro.entities.StudentEntity;
import riwi.filtro.persistence.IModel.IModelStudent;
import riwi.filtro.persistence.dbConnection.Connect;
import riwi.filtro.tools.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IModelStudent {


    @Override
    public boolean create(StudentEntity objeto) {
        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "INSERT INTO student(name,lastName,email) VALUES (?,?,?);";

        //EJECUCION
        try {
            ps = con.prepareStatement(query);

            //AÑADIMOS DATOS A LA QUERY
            ps.setString(1,objeto.getName().toLowerCase());
            ps.setString(2,objeto.getLastName().toLowerCase());
            ps.setString(3, objeto.getEmail().toLowerCase());

            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("user not found "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }


    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //BUSCAR POR ID Y TRAER LOS CURSOS
    @Override
    public void readStudentCoursesID(int id) {
        //CREAMOS INSTANCIAS
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM inscription INNER JOIN student ON inscription.id_student = student.id INNER JOIN course ON inscription.id_course = course.id WHERE student.id = ?;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("id: "+rs.getInt(1)+" / name: "+rs.getString(5)+" / last name: "+rs.getString(6)+ " / email: "+rs.getString(7)+" / Active: "+rs.getString(8)+" / class id: "+rs.getInt(9)+" / class name: "+rs.getString(10));
            }
        }catch (Exception e){
            System.out.println("The student cannot be readed");
        }finally {
            Connect.cerrar();
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------

    //BUSCAR POR EMAIL Y TRAER LOS CURSOS
    @Override
    public void readStudentCoursesEmail(String email) {
        //CREAMOS INSTANCIAS
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM inscription INNER JOIN student ON inscription.id_student = student.id INNER JOIN course ON inscription.id_course = course.id WHERE student.email = ?;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,email);

            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("id: "+rs.getInt(1)+" / name: "+rs.getString(5)+" / last name: "+rs.getString(6)+ " / email: "+rs.getString(7)+" / Active: "+rs.getString(8)+" / class id: "+rs.getInt(9)+" / class name: "+rs.getString(10));
            }
        }catch (Exception e){
            System.out.println("The student cannot be readed");
        }finally {
            Connect.cerrar();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public List<StudentEntity> activateStudents(Status status) {
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM student WHERE status = ?;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,status.name());

            rs = ps.executeQuery();

            while (rs.next()){
                //EXTRAEMOS EL ENUM PARA ASIGNARLO EN JAVA
                String activeStr = rs.getString("active");
                Status statusTemp = Status.valueOf(activeStr);

                //AÑADIMOS OBJETO AL ARRAY
                StudentEntity student = new StudentEntity(rs.getInt("id"),rs.getString("name"),rs.getString("lastName"), rs.getString("email"),statusTemp);
                students.add(student);
            }

        }catch (Exception e){
            System.out.println("the users cannot be readed");
        }
        return students;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------

    //UPDATES

    @Override
    public boolean updateName(int id, String name) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE student SET nombre = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,name.toLowerCase());
            ps.setInt(2,id);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The coder cannot be updated");
        }finally {
            Connect.cerrar();
        }

        return false;
    }

    @Override
    public boolean updateLastName(int id, String lastName) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE student SET lastName = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,lastName.toLowerCase());
            ps.setInt(2,id);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The coder cannot be updated");
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    @Override
    public boolean updateEmail(int id, String email) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE student SET email = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,email.toLowerCase());
            ps.setInt(2,id);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The coder cannot be updated");
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    @Override
    public boolean updateStatus(int id, Status status) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE student SET active = ? WHERE id = ?";

        try {
            //PASAMOS EL ENUM A STRING
            ps = con.prepareStatement(query);
            ps.setString(1,status.name());
            ps.setInt(2,id);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The coder cannot be updated");
        }finally {
            Connect.cerrar();
        }
        return false;
    }


    @Override
    public boolean update(StudentEntity objeto) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE student SET nombre = ?, lastName = ?, email = ?, active = ? WHERE id = ?";

        try {

        }catch (Exception e){
            System.out.println("The coder cannot be updated");
        }finally {
            Connect.cerrar();
        }
        return false;
    }

}
