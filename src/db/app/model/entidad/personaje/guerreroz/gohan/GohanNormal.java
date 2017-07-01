package db.app.model.entidad.personaje.guerreroz.gohan;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GohanNormal implements TransformacionDelPersonaje {
    private Gohan mGohan;
    private TransformacionPorKi mTransformacionPorKi;

    public GohanNormal(Gohan gohan) {
        mGohan = gohan;
        mTransformacionPorKi = new TransformacionPorKi(gohan, 10);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanNormal.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanNormal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanNormal.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanNormal.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorKi.puedoTransformarme()) {
            mGohan.setTransformacionDelPersonaje(mGohan.getSegundaTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
