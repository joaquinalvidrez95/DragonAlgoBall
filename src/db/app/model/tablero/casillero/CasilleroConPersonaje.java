package db.app.model.tablero.casillero;

import db.app.exception.CasilleroSinPersonaje;
import db.app.exception.CeldaOcupada;
import db.app.exception.NoHayConsumible;
import db.app.model.entidad.Vacio;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;

public class CasilleroConPersonaje implements EstadoDeCasillero {

    private Casillero mCasillero;

    public CasilleroConPersonaje(Casillero casillero) {
        this.mCasillero = casillero;
    }


    @Override
    public boolean tienesPersonaje() {
        return true;
    }

    @Override
    public void setPersonaje(Personaje personaje) throws CeldaOcupada {
        throw new CeldaOcupada();
    }

    @Override
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
        return (Personaje) mCasillero.getContenido();
    }

    @Override
    public boolean estaVacio() {
        return false;
    }

    @Override
    public boolean tienesConsumible() {
        return false;
    }

    @Override
    public Consumible getConsumible() throws NoHayConsumible {
        throw new NoHayConsumible();
    }

}
