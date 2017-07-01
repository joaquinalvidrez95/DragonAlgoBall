package db.app.model.entidad.personaje.guerreroz.goku;

import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ProvocanteDeTransformacionPorEquipoHerido;
import db.app.model.entidad.personaje.ataqueespecial.Kamehameha;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;

public class Goku extends Personaje implements ProvocanteDeTransformacionPorEquipoHerido {
    final double PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO = 0.3;
    final double AUMENTO_PODER_DE_PELEA_AL_ESTAR_HERIDO = 1.2;

    public Goku(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOKU,
                DragonBallZParametros.ParametrosDePersonajes.Goku.SRC_Img,
                posicion);

        mTransformacionNormal = new GokuNormal(this);
        mSegundaTransformacion = new GokuKaioKen(this);
        mTerceraTransformacion = new GokuSuperSayajin(this);
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Kamehameha(this);
    }

    public Goku() {
        super(DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOKU,
                DragonBallZParametros.ParametrosDePersonajes.Goku.SRC_Img);

        mTransformacionNormal = new GokuNormal(this);
        mSegundaTransformacion = new GokuKaioKen(this);
        mTerceraTransformacion = new GokuSuperSayajin(this);
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Kamehameha(this);
    }

    @Override
    public boolean estasHerido() {
        return (getVida() < DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA * PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO);
    }
}
