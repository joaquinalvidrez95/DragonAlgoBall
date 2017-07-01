package db.app.model.tablero.casillero;

import db.app.exception.CasilleroSinPersonaje;
import db.app.exception.CeldaOcupada;
import db.app.exception.CeldaVacia;
import db.app.exception.NoHayConsumible;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 07/06/2017.
 */
public class CasilleroVacio implements EstadoDeCasillero {

    private Casillero mCasillero;

    public CasilleroVacio(Casillero casillero) {
        this.mCasillero = casillero;
    }

    //    @Override
//    public boolean isEmpty() {
//        return true;
//    }
//
    @Override
    public boolean tienesPersonaje() {
        return false;
    }


    @Override
    public void setConsumible(Consumible consumible) {
        mCasillero.colocarContenido(consumible);
        consumible.setPosicion(mCasillero.getPosition());
        mCasillero.setEstado(mCasillero.getOcupadoConsumibleState());
    }

    @Override
    public void limpiarCasillero() throws CeldaVacia {
        throw new CeldaVacia();
    }

    @Override
    public Personaje getPersonaje() throws CasilleroSinPersonaje {
        throw new CasilleroSinPersonaje();
    }

    @Override
    public boolean estaVacio() {
        return true;
    }

    @Override
    public boolean tienesConsumible() {
        return false;
    }

    @Override
    public Consumible getConsumible() throws NoHayConsumible {
        throw new NoHayConsumible();
    }

    @Override
    public void setPersonaje(Personaje personaje) throws CeldaOcupada {
        mCasillero.colocarContenido(personaje);
        personaje.setPosicion(mCasillero.getPosition());
        mCasillero.setEstado(mCasillero.getOcupadoPersonajeState());
    }


}
