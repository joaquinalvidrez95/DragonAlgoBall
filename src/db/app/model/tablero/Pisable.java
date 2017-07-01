package db.app.model.tablero;

import db.app.exception.CasilleroNoExistente;
import db.app.exception.CeldaOcupada;
import db.app.exception.CeldaVacia;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public interface Pisable {
    boolean tienesObjetoMovible(Posicion posicion) throws CasilleroNoExistente;


    void limpiarCasillero(Posicion posicion) throws CasilleroNoExistente, CeldaVacia;

    void colocarPersonaje(Posicion posicionFinal, Personaje personaje) throws CasilleroNoExistente, CeldaOcupada;


    void colocarConsumible(Posicion posicion, Consumible consumible) throws CasilleroNoExistente, CeldaOcupada;

    boolean tienesConsumible(Posicion posicion) throws CasilleroNoExistente;
}
