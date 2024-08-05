package riwi.filtro.model;

import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.persistence.IModel.IModelInscription;

import java.util.List;

public class InscriptionModel implements IModelInscription {
    @Override
    public boolean create(InscriptionEntity objeto) {
        return false;
    }

    @Override
    public boolean delete(Integer identidicador) {
        return false;
    }

    @Override
    public List<InscriptionEntity> readAll() {
        return List.of();
    }

    @Override
    public List<InscriptionEntity> readInteger(Integer dato) {
        return List.of();
    }

    @Override
    public List<InscriptionEntity> readString(String dato) {
        return List.of();
    }

    @Override
    public boolean update(InscriptionEntity objeto) {
        return false;
    }
}
