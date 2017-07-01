package db.app.model.entidad;

import db.app.model.tablero.Posicion;

public class Vacio implements Posicionable {

    @Override
    public Posicion getPosicion() {
        return null;
    }

    @Override
    public void setPosicion(Posicion posicion) {

    }
}
