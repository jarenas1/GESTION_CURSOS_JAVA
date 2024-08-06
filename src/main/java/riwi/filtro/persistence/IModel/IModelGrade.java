package riwi.filtro.persistence.IModel;

import riwi.filtro.controller.GradeModel;
import riwi.filtro.entities.CourseEntity;
import riwi.filtro.entities.GradeEntity;
import riwi.filtro.persistence.CRUD.*;

public interface IModelGrade extends Create<GradeEntity>, Delete<Integer>, ReadAll<GradeEntity>, Update<GradeEntity>{
}
