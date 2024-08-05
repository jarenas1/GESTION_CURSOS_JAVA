package riwi.filtro.persistence.CRUD;

import java.util.List;

public interface ReadInteger<T,A>{

    //Devuelve una lista de tipo A con los usuario que se llamaron de la database
    public List<T> readInteger (A dato);
}