package riwi.filtro.model;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.persistence.IModel.IModelInscription;
import riwi.filtro.persistence.dbConnection.Connect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscriptionModel implements IModelInscription {
    @Override
    public boolean create(InscriptionEntity objeto) {
        //CREAMOS INSTANCIAS NECESARIAS Y QUERY
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "INSERT INTO course(id_course, id_student) VALUES (?,?);";
        JOptionPane.showConfirmDialog(null," Are you sure you want to delete the inscrption? ");

        //EJECUCION
        try {
            ps = con.prepareStatement(query);

            //AÑADIMOS DATOS A LA QUERY
            ps.setInt(1,objeto.getId_course());
            ps.setInt(2,objeto.getId_student());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the inscription cannot be created "+e.getLocalizedMessage());
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
        String query = "DELETE FROM inscription WHERE id = ?;";

        try {
            ps = con.prepareStatement(query);
            //AÑADIR DATOS A QUERY
            ps.setInt(1,identidicador);
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("the course cant be deleted "+e.getLocalizedMessage());
        }finally {
            Connect.cerrar();
        }
        return false;
    }

    @Override
    public List<InscriptionEntity> readAll() {
        //CREAMOS INSTANCIAS
        ResultSet rs;
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "SELECT * FROM inscription";

        //CREAMOS ARRAY CONTENEDOR DE CURSOS
        List<InscriptionEntity>inscriptions = new ArrayList<>();

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                InscriptionEntity inscription = new InscriptionEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                inscriptions.add(inscription);
            }
        }catch (Exception e){
            System.out.println("The student cannot be readed");
        }finally {
            Connect.cerrar();
        }
        return inscriptions;
    }

    @Override
    public boolean update(InscriptionEntity objeto) {
        PreparedStatement ps;
        Connection con = Connect.conectar();
        String query = "UPDATE inscription SET id_course = ?, id_student = ? WHERE id = ? ";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,objeto.getId_course());
            ps.setInt(2,objeto.getId_student());
            ps.setInt(3,objeto.getId());

            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("The inscription cannot be updated  "+e.getLocalizedMessage());
        }
        return false;
    }
}
