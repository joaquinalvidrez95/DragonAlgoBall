package db.app.model.entidad.personaje.enemigodelatierra.majinboo;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class BooMalo implements TransformacionDelPersonaje {
    private TransformacionPorKi mTransformacionPorKi;
    private MajinBoo mMajinBoo;

    public BooMalo(MajinBoo majinBoo) {
        mMajinBoo = majinBoo;
        mTransformacionPorKi = new TransformacionPorKi(majinBoo, 50);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooMalo.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooMalo.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooMalo.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.MajinBoo.BooMalo.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mMajinBoo.setTransformacionDelPersonaje(mMajinBoo.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
