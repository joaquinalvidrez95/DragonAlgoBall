package db.app.model.entidad.personaje.enemigodelatierra.freezer;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class FreezerSegundaForma implements TransformacionDelPersonaje {
    private Freezer mFreezer;
    private TransformacionPorKi mTransformacionPorKi;

    public FreezerSegundaForma(Freezer freezer) {
        mFreezer = freezer;
        mTransformacionPorKi = new TransformacionPorKi(freezer, 50);

    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerSegundaForma.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerSegundaForma.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerSegundaForma.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Freezer.FreezerSegundaForma.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mFreezer.setTransformacionDelPersonaje(mFreezer.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
