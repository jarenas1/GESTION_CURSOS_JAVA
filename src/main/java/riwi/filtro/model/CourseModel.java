package riwi.filtro.model;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.entities.StudentEntity;
import riwi.filtro.persistence.IModel.IModelCourse;
import riwi.filtro.persistence.dbConnection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseModel implements IModelCourse {
    @Override
    public boolean create(CourseEntity objeto) {

        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "INSERT INTO course(name) VALUES (?);";

        //EJECUCION
        try {
            ps = con.prepareStatement(query);

            //AÑADIMOS DATOS A LA QUERY
            ps.setString(1,objeto.getName().toLowerCase());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the course cannot be created "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    //---------------------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean delete(Integer identidicador) {

        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "DELETE FROM course WHERE id = ?;";
        String query2 = "SELECT * FROM course INNER JOIN inscription ON inscription.id_course = course.id WHERE inscription.id_student IS NOT NULL AND inscription.id_course = 4;";

        try {
            //VERIFICAR QUE EL CURSO ESTE VACIO ANTES DE BORRARLO
            ps = con.prepareStatement(query2);
            ps.setInt(1,identidicador);
            rs = ps.executeQuery();
            if (!rs.next()){
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
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            Connect.cerrar();
        }
            return false;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public List<CourseEntity> readAll() {

        //CREAMOS INSTANCIAS
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM course";

        //CREAMOS ARRAY CONTENEDOR DE CURSOS
        List<CourseEntity>courses = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                CourseEntity course = new CourseEntity(rs.getInt(1),rs.getString(2));
                courses.add(course);
            }
        }catch (Exception e){
            System.out.println("The student cannot be readed");
        }finally {
            Connect.cerrar();
        }
        return courses;
    }

    @Override
    public boolean update(CourseEntity objeto) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE course SET name = ? WHERE id =?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1,objeto.getName().toLowerCase());
            ps.setInt(2,objeto.getId());

            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The course cannot be updated  "+e.getLocalizedMessage());
        }
        return false;
    }
}
