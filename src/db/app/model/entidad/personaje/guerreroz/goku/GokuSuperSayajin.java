package db.app.model.entidad.personaje.guerreroz.goku;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GokuSuperSayajin implements TransformacionDelPersonaje {
    private Goku mGoku;

    GokuSuperSayajin(Goku goku) {
        mGoku = goku;
    }

    @Override
    public double getPoderDePelea() {
        double poderDePelea = DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.PODER_DE_PELEA;

        if (mGoku.getVida() < DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA * mGoku.PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO) {
            poderDePelea *= mGoku.AUMENTO_PODER_DE_PELEA_AL_ESTAR_HERIDO;
        }
        return poderDePelea;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.NOMBRE;
    }


    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();

    }
}
