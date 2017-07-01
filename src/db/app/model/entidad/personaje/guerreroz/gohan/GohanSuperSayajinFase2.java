package db.app.model.entidad.personaje.guerreroz.gohan;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GohanSuperSayajinFase2 implements TransformacionDelPersonaje {
    private Gohan mGohan;

    public GohanSuperSayajinFase2(Gohan gohan) {
        mGohan = gohan;
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();
    }
}
