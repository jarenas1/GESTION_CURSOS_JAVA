package riwi.filtro.persistence.IModel;

import riwi.filtro.entities.CourseEntity;
import riwi.filtro.persistence.CRUD.*;

public interface IModelCourse extends Create<CourseEntity>, Delete<Integer>, ReadAll<CourseEntity>, Update<CourseEntity>{
}
