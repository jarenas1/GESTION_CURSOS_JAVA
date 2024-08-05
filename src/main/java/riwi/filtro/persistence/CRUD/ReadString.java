package riwi.filtro.persistence.CRUD;

import java.util.List;

public interface ReadString<A,T>{

    //Devuelve una lista de tipo T con los usuario que se llamaron de la database
    public List<A> readString (T dato);
}
