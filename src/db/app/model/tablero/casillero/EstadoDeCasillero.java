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
public interface EstadoDeCasillero {
    boolean tienesPersonaje();

    void setPersonaje(Personaje personaje) throws CeldaOcupada;

    void setConsumible(Consumible consumible) throws CeldaOcupada;

    void limpiarCasillero() throws CeldaVacia;

    Personaje getPersonaje() throws CasilleroSinPersonaje;

    boolean estaVacio();

    boolean tienesConsumible();

    Consumible getConsumible() throws NoHayConsumible;
}
