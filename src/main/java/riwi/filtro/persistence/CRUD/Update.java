package com.riwi.persistence.CRUD;

public interface Update <T>{

    //devuelve true si actualiza, false si no
     boolean update(T objeto);
}
