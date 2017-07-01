package db.app.model.entidad.personaje.guerreroz.piccolo;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class PiccoloProtector implements TransformacionDelPersonaje {
    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();
    }
}
