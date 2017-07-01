package db.app.model.entidad.personaje.guerreroz.piccolo;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TranformacionPorAmigoHerido;
import db.app.model.entidad.personaje.transformacion.ValidadorDeTransformacion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class PiccoloFortalecido implements TransformacionDelPersonaje {
    private ValidadorDeTransformacion mTransformacionPorAmigoHerido;
    private Piccolo mPiccolo;

    public PiccoloFortalecido(Piccolo piccolo) {
        mPiccolo = piccolo;
        mTransformacionPorAmigoHerido = new TranformacionPorAmigoHerido(piccolo);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloFortalecido.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloFortalecido.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloFortalecido.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloFortalecido.NOMBRE;
    }


    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorAmigoHerido.puedoTransformarme()) {
            mPiccolo.setTransformacionDelPersonaje(mPiccolo.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
