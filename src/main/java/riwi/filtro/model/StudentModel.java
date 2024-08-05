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
            ps.setString(1,objeto.getName());
            ps.setString(2,objeto.getLastName());
            ps.setString(3, objeto.getEmail());

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

    @Override
    public boolean delete(Integer identidicador) {
        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "DELETE FROM student WHERE id = ?;";

        try {
            ps = con.prepareStatement(query);

            //AÑADIR DATOS A QUERY
            ps.setInt(1,identidicador);

            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the student cant be deleted "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //READS
    @Override
    public List<StudentEntity> readAll() {
        //CREAMOS INSTANCIAS Y RESULSET YA QUE VAMOS A EXTRAER RESULTADO
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM student;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            //ITERAMOS PARA AÑADIR AL ARRAY
            while (rs.next()){
                //EXTRAEMOS EL ENUM PARA ASIGNARLO EN JAVA
                String activeStr = rs.getString("active");
                Status status = Status.valueOf(activeStr);

                //AÑADIMOS OBJETO AL ARRAY
                StudentEntity student = new StudentEntity(rs.getInt("id"),rs.getString("name"),rs.getString("lastName"), rs.getString("email"),status);
                students.add(student);
            }
        }catch (Exception e){
            System.out.println("cannot be read te students");
        }finally {
            Connect.cerrar();
        }
        //DEVOLVEMOS LISTA
        return students;
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

    //read email
    @Override
    public List<StudentEntity> readString(String dato) {

        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM student WHERE email = dato;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            //ITERAMOS PARA AÑADIR AL ARRAY
            while (rs.next()){
                //EXTRAEMOS EL ENUM PARA ASIGNARLO EN JAVA
                String activeStr = rs.getString("active");
                Status status = Status.valueOf(activeStr);

                //AÑADIMOS OBJETO AL ARRAY
                StudentEntity student = new StudentEntity(rs.getInt("id"),rs.getString("name"),rs.getString("lastName"), rs.getString("email"),status);
                students.add(student);
            }
        }catch (Exception e){
            System.out.println("cannot be read te students");
        }finally {
            Connect.cerrar();
        }
        //DEVOLVEMOS LISTA
        return students;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //read id
    @Override
    public List<StudentEntity> readInteger(Integer id) {

        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM student WHERE id = ?;";

        //CREAMOS ARRAY CONTENEDOR DE ESTUDIANTES
        List<StudentEntity> students = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            //ITERAMOS PARA AÑADIR AL ARRAY
            while (rs.next()){
                //EXTRAEMOS EL ENUM PARA ASIGNARLO EN JAVA
                String activeStr = rs.getString("active");
                Status status = Status.valueOf(activeStr);

                //AÑADIMOS OBJETO AL ARRAY
                StudentEntity student = new StudentEntity(rs.getInt("id"),rs.getString("name"),rs.getString("lastName"), rs.getString("email"),status);
                students.add(student);
            }
        }catch (Exception e){
            System.out.println("cannot be read te students");
        }finally {
            Connect.cerrar();
        }
        //DEVOLVEMOS LISTA
        return students;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------

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

    //UPDATES
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
    public boolean update(StudentEntity objeto) {
        return false;
    }

}
