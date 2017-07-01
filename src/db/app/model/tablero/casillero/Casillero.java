package db.app.model.tablero.casillero;

import db.app.exception.CasilleroSinPersonaje;
import db.app.exception.CeldaOcupada;
import db.app.exception.CeldaVacia;
import db.app.exception.NoHayConsumible;
import db.app.model.entidad.Posicionable;
import db.app.model.entidad.Vacio;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;


public class Casillero {
    private final Posicion mPosicion;
    private final EstadoDeCasillero mCasilleroConConsumible;
    private final EstadoDeCasillero mCasilleroConPersonaje;
    private final EstadoDeCasillero mCasilleroVacio;
    private EstadoDeCasillero mEstadoDeCasillero;
    private Posicionable mPosicionable;
    private Consumible consumible;

    public Casillero(Posicion posicion) {
        mPosicion = posicion;
        mPosicionable = new Vacio();
        mCasilleroVacio = new CasilleroVacio(this);
        mCasilleroConConsumible = new CasilleroConConsumible(this);
        mCasilleroConPersonaje = new CasilleroConPersonaje(this);
        mEstadoDeCasillero = mCasilleroVacio;
    }

    public void colocarConsumible(Consumible consumible) throws CeldaOcupada {
        mEstadoDeCasillero.setConsumible(consumible);
    }

    public void colocarPersonaje(Personaje personaje) throws CeldaOcupada {
        mEstadoDeCasillero.setPersonaje(personaje);
    }

    public void limpiarCasillero() throws CeldaVacia {
        mEstadoDeCasillero.limpiarCasillero();
    }

    public Posicion getPosition() {
        return mPosicion;
    }

    public boolean tienesPersonaje() {
        return mEstadoDeCasillero.tienesPersonaje();
    }

    EstadoDeCasillero getOcupadoConsumibleState() {
        return mCasilleroConConsumible;
    }

    EstadoDeCasillero getOcupadoPersonajeState() {
        return mCasilleroConPersonaje;
    }

    EstadoDeCasillero getEmptyState() {
        return mCasilleroVacio;
    }

    void colocarContenido(Posicionable contenido) {
        this.mPosicionable = contenido;
    }

    public Posicionable getContenido() {
        return mPosicionable;
    }

    public Personaje getPersonaje() throws CasilleroSinPersonaje {
        return mEstadoDeCasillero.getPersonaje();
    }

//    public boolean existeContenido(Posicionable posicionable) {
//        return posicionable == mPosicionable;
//    }

    void setEstado(EstadoDeCasillero estado) {
        this.mEstadoDeCasillero = estado;
    }

    public Consumible getConsumible() throws NoHayConsumible {
//
        return mEstadoDeCasillero.getConsumible();
    }

    public boolean estaVacio() {
        return mEstadoDeCasillero.estaVacio();
    }

    public boolean tienesConsumible() {
        return mEstadoDeCasillero.tienesConsumible();
    }
}
