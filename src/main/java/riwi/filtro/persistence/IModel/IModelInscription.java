package riwi.filtro.persistence.IModel;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.entities.InscriptionEntity;
import riwi.filtro.entities.StudentEntity;
import riwi.filtro.persistence.CRUD.*;

public interface IModelInscription extends Create<InscriptionEntity>, Delete<Integer>, ReadAll<InscriptionEntity>,Update<InscriptionEntity> {
}
