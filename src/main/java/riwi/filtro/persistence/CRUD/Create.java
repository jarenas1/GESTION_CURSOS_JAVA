package com.riwi.persistence.CRUD;

public interface Create <T>{

    //va a devolver true si se crea el usuario
    public boolean create(T objeto);
}
