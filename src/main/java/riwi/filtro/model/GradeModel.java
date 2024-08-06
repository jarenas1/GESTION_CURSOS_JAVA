package riwi.filtro.model;

import riwi.filtro.entities.GradeEntity;
import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.persistence.IModel.IModelGrade;
import riwi.filtro.persistence.dbConnection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeModel implements IModelGrade {
    @Override
    public boolean create(GradeEntity objeto) {

        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "INSERT INTO grade(note, description, id_course, id_student) VALUES (?,?,?,?);";
        if (objeto.getNote()>100){
            System.out.println("MAX GRADE IS 100");
            return false;
        }
        //EJECUCION
        try {
            ps = con.prepareStatement(query);

            //AÑADIMOS DATOS A LA QUERY
            ps.setDouble(1,objeto.getNote());
            ps.setString(2,objeto.getDescription().toLowerCase());
            ps.setInt(3,objeto.getId_course());
            ps.setInt(4,objeto.getId_student());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the grade cannot be created "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    @Override
    public boolean delete(Integer identidicador) {
        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "DELETE FROM grade WHERE id = ?;";

        try {
            ps = con.prepareStatement(query);
            //AÑADIR DATOS A QUERY
            ps.setInt(1,identidicador);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the grade cant be deleted "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    @Override
    public List<GradeEntity> readAll() {
        //CREAMOS INSTANCIAS
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM inscription";

        //CREAMOS ARRAY CONTENEDOR DE CURSOS
        List<GradeEntity>grades = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                GradeEntity grade = new GradeEntity(rs.getInt("id"), rs.getDouble(2),rs.getString(3),rs.getInt("id_student"), rs.getInt("id_course"));
                grades.add(grade);
            }
        }catch (Exception e){
            System.out.println("The student cannot be readed  "+e.getMessage());
        }finally {
            Connect.cerrar();
        }
        return grades;
    }


    @Override
    public boolean update(GradeEntity objeto) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE grade SET note =?, description = ?, id_student = ?, id_course = ? WHERE id = ?;";
        try {
            ps = con.prepareStatement(query);
            //AÑADIR DATOS A QUERY
            ps.setDouble(1,objeto.getNote());
            ps.setString(2,objeto.getDescription());
            ps.setInt(3,objeto.getId_student());
            ps.setInt(4,objeto.getId_course());
            ps.setInt(5,objeto.getId());

            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the grade cant be updated  0  "+e.getMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }
}
