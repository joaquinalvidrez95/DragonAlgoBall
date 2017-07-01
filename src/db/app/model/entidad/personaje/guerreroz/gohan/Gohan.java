package db.app.model.entidad.personaje.guerreroz.gohan;

import db.app.model.entidad.personaje.ConsumidorDeKi;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ProvocanteDeTransformacionPorEquipoHerido;
import db.app.model.entidad.personaje.ataqueespecial.Masenko;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.transformacion.ProvocanteDeTransformacionPorAmigoHerido;
import db.app.model.entidad.personaje.transformacion.TransformablePorEquipoHerido;
import db.app.model.tablero.Posicion;

public class Gohan extends Personaje implements ConsumidorDeKi, TransformablePorEquipoHerido, ProvocanteDeTransformacionPorAmigoHerido {
    private final double PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO = 0.2;
    private ProvocanteDeTransformacionPorEquipoHerido mPiccolo;
    private ProvocanteDeTransformacionPorEquipoHerido mGoku;

    public Gohan(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.Gohan.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOHAN,
                DragonBallZParametros.ParametrosDePersonajes.Gohan.SRC_Img,
                posicion);

        mTransformacionNormal = new GohanNormal(this);
        mSegundaTransformacion = new GohanSuperSayajinFase1(this);
        mTerceraTransformacion = new GohanSuperSayajinFase2(this);
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Masenko(this);
    }

    public Gohan() {
        super(DragonBallZParametros.ParametrosDePersonajes.Gohan.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOHAN,
                DragonBallZParametros.ParametrosDePersonajes.Gohan.SRC_Img);

        mTransformacionNormal = new GohanNormal(this);
        mSegundaTransformacion = new GohanSuperSayajinFase1(this);
        mTerceraTransformacion = new GohanSuperSayajinFase2(this);
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Masenko(this);
    }

    public void setProvocantesDeTransformacionPorEquipoHerido(ProvocanteDeTransformacionPorEquipoHerido goku,
                                                              ProvocanteDeTransformacionPorEquipoHerido piccolo) {
        mGoku = goku;
        mPiccolo = piccolo;
    }

    @Override
    public boolean tuEquipoEstaHerido() {
        boolean tuEquipoEstaHerido;
        try {
            tuEquipoEstaHerido = mPiccolo.estasHerido();
            tuEquipoEstaHerido &= mGoku.estasHerido();
        } catch (NullPointerException e) {
            tuEquipoEstaHerido = false;
        }
        //tuEquipoEstaHerido = mPiccolo.estasHerido() && mGoku.estasHerido();
        return tuEquipoEstaHerido;
    }

    @Override
    public boolean estasHeridoParaTransformacionPorAmigoHerido() {
        return (getVida() < DragonBallZParametros.ParametrosDePersonajes.Gohan.VIDA * PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO);
    }
}
