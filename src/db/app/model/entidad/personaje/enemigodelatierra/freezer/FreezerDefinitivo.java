package db.app.model.entidad.personaje.enemigodelatierra.freezer;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class FreezerDefinitivo implements TransformacionDelPersonaje {

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerDefinitivo.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerDefinitivo.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerDefinitivo.VELOCIDAD;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerDefinitivo.NOMBRE;
    }
}
