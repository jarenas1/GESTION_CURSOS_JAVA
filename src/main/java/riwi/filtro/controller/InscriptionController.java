package riwi.filtro.controller;

import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.model.InscriptionModel;
import riwi.filtro.persistence.IModel.IModelInscription;

import java.util.List;

public class InscriptionController {
    private final IModelInscription modelInscription;

    public InscriptionController(){
        this.modelInscription = new InscriptionModel();
    }

    public boolean create(int id_course, int id_student){
        return this.modelInscription.update(new InscriptionEntity(id_course,id_student));
    }

    public boolean delete (Integer id){
        return this.modelInscription.delete(id);
    }

    public List<InscriptionEntity> readAll(){
        return this.modelInscription.readAll();
    }

    public boolean update(int id, int id_course, int id_student){
        return this.modelInscription.update(new InscriptionEntity(id,id_course,id_student));
    }
}
