package db.app.model.tablero.casillero;

import db.app.exception.CasilleroSinPersonaje;
import db.app.exception.CeldaOcupada;
import db.app.exception.NoHayConsumible;
import db.app.model.entidad.Vacio;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 07/06/2017.
 */
public class CasilleroConConsumible implements EstadoDeCasillero {

    private Casillero mCasillero;

    public CasilleroConConsumible(Casillero casillero) {
        this.mCasillero = casillero;
    }

    @Override
    public boolean tienesPersonaje() {
        return false;
    }

    @Override
    public void setPersonaje(Personaje personaje) {

        try {
            personaje.consumirObjeto(mCasillero.getConsumible());
        } catch (NoHayConsumible noHayConsumible) {

        }
        mCasillero.colocarContenido(personaje);
        personaje.setPosicion(mCasillero.getPosition());
        mCasillero.setEstado(mCasillero.getOcupadoPersonajeState());
    }

    public void setConsumible(Consumible consumible) throws CeldaOcupada {
        throw new CeldaOcupada();
    }

    @Override
    public void limpiarCasillero() {
        mCasillero.colocarContenido(new Vacio());
        mCasillero.setEstado(mCasillero.getEmptyState());
    }

    @Override
    public Personaje getPersonaje() throws CasilleroSinPersonaje {
        throw new CasilleroSinPersonaje();
    }

    @Override
    public boolean estaVacio() {
        return false;
    }

    @Override
    public boolean tienesConsumible() {
        return true;
    }

    @Override
    public Consumible getConsumible() throws NoHayConsumible {
        return (Consumible) mCasillero.getContenido();
    }

}