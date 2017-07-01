package db.app.model.entidad.personaje.enemigodelatierra.majinboo;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class BooOriginal implements TransformacionDelPersonaje {
    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooOriginal.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooOriginal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooOriginal.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooOriginal.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();
    }
}
