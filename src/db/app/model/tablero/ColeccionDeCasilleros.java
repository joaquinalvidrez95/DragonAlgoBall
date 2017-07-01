package db.app.model.tablero;


import db.app.exception.CasilleroNoExistente;
import db.app.model.tablero.casillero.Casillero;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by joaquinalan on 06/06/2017.
 */
public class ColeccionDeCasilleros {
    private Hashtable<Posicion, Casillero> mCasilleros;

    public ColeccionDeCasilleros() {
        this.mCasilleros = new Hashtable<Posicion, Casillero>();
    }

    public void agregarCasillero(Casillero casillero) {
        mCasilleros.put(casillero.getPosition(), casillero);
    }


    public boolean existeCasillero(Posicion posicion) {
        return mCasilleros.containsKey(posicion);
    }

    public Casillero getCasillero(Posicion posicion) throws CasilleroNoExistente {
        if (!existeCasillero(posicion)) {
            throw new CasilleroNoExistente();
        }
        return mCasilleros.get(posicion);
    }

    public Iterator<Casillero> getIterator() {
        return mCasilleros.values().iterator();
    }
}
