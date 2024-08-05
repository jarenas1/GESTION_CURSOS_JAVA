package com.riwi.persistence.CRUD;

import java.util.List;

public interface Read <T,A>{

    //Devuelve una lista de tipo T con los usuario que se llamaron de la database
    public List<A> read (T dato);
}
