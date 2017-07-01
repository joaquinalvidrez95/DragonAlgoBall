package db.app.model.entidad.personaje.guerreroz.piccolo;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class PiccoloNormal implements TransformacionDelPersonaje {
    private Piccolo mPiccolo;
    private TransformacionPorKi mTransformacionPorKi;

    public PiccoloNormal(Piccolo piccolo) {
        mPiccolo = piccolo;
        mTransformacionPorKi = new TransformacionPorKi(piccolo, 20);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloNormal.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloNormal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloNormal.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloNormal.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mPiccolo.setTransformacionDelPersonaje(mPiccolo.getSegundaTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
