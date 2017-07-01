package db.app.model.entidad.personaje.guerreroz.goku;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;
import db.app.model.entidad.personaje.transformacion.ValidadorDeTransformacion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GokuNormal implements TransformacionDelPersonaje {
    private Goku mGoku;
    private ValidadorDeTransformacion mTransformacionPorKi;

    GokuNormal(Goku goku) {
        mGoku = goku;
        final int kiRequeridoParaTransformarse = 20;
        mTransformacionPorKi = new TransformacionPorKi(goku, kiRequeridoParaTransformarse);
    }

    @Override
    public double getPoderDePelea() {
        double poderDePelea = DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.PODER_DE_PELEA;

        if (mGoku.getVida() < DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA * mGoku.PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO) {
            poderDePelea *= mGoku.AUMENTO_PODER_DE_PELEA_AL_ESTAR_HERIDO;
        }
        return poderDePelea;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mGoku.setTransformacionDelPersonaje(mGoku.getSegundaTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
