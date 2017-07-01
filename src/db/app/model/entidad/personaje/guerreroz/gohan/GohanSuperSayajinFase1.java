package db.app.model.entidad.personaje.guerreroz.gohan;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorEquipoHerido;
import db.app.model.entidad.personaje.transformacion.TransformacionPorKi;
import db.app.model.entidad.personaje.transformacion.ValidadorDeTransformacion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GohanSuperSayajinFase1 implements TransformacionDelPersonaje {
    private Gohan mGohan;
    private ValidadorDeTransformacion mTransformacionPorEquipoHerido;
    private ValidadorDeTransformacion mTransformacionPorKi;

    public GohanSuperSayajinFase1(Gohan gohan) {
        mGohan = gohan;
        mTransformacionPorEquipoHerido = new TransformacionPorEquipoHerido(gohan);
        mTransformacionPorKi = new TransformacionPorKi(gohan, 30);
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.NOMBRE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.VELOCIDAD;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorEquipoHerido.puedoTransformarme() && mTransformacionPorKi.puedoTransformarme()) {
            mGohan.setTransformacionDelPersonaje(mGohan.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
