package db.app.model.entidad;

import db.app.model.tablero.Posicion;

public interface Posicionable {
    Posicion getPosicion();

    void setPosicion(Posicion posicion);

}
