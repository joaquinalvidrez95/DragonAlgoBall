package db.app.model.entidad.personaje.enemigodelatierra.freezer;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class FreezerNormal implements TransformacionDelPersonaje {
    private TransformacionPorKi mTransformacionPorKi;
    private Freezer mFreezer;

    public FreezerNormal(Freezer freezer) {
        mFreezer = freezer;
        mTransformacionPorKi = new TransformacionPorKi(freezer, 20);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerNormal.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerNormal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerNormal.VELOCIDAD;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mFreezer.setTransformacionDelPersonaje(mFreezer.getSegundaTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerNormal.NOMBRE;
    }
}

