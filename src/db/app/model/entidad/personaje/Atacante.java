package db.app.model.entidad.personaje;

import db.app.model.tablero.Posicion;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public interface Atacante {
    Posicion getPosicion();

    int getDistanciaDeAtaque();

    int getKi();

    void consumirKi(int mKiRequerido);

    double getPoderDePelea();

    String getEquipo();

    double usarEsferaDelDragon();
}
