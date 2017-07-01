package db.app.model.entidad.personaje;

import db.app.exception.IncapazDeTransformarse;

/**
 * Created by joaquinalan on 08/06/2017.
 */
public interface TransformacionDelPersonaje {

    String getNombreEstado();

    double getPoderDePelea();

    int getDistanciaAtaque();

    int getVelocidad();

    void transform() throws IncapazDeTransformarse;
}
