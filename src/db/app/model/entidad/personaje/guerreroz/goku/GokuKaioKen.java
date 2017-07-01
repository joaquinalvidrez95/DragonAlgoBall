package db.app.model.entidad.personaje.guerreroz.goku;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GokuKaioKen implements TransformacionDelPersonaje {
    private Goku mGoku;
    private TransformacionPorKi mTransformacionPorKi;

    GokuKaioKen(Goku goku) {
        mGoku = goku;
        final int kiRequeridoParaTransformarse = 50;
        mTransformacionPorKi = new TransformacionPorKi(goku, kiRequeridoParaTransformarse);
    }

    @Override
    public double getPoderDePelea() {
        double poderDePelea = DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.PODER_DE_PELEA;

        if (mGoku.getVida() < DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA * mGoku.PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO) {
            poderDePelea *= mGoku.AUMENTO_PODER_DE_PELEA_AL_ESTAR_HERIDO;
        }
        return poderDePelea;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mGoku.setTransformacionDelPersonaje(mGoku.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
