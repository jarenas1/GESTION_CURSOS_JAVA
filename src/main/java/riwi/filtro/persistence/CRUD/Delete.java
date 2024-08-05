package com.riwi.persistence.CRUD;

public interface Delete <T>{

    //Recibe un identificador de tipo t y devuelve true/false si lo elimino o no
    boolean delete(T identidicador);
}
