package db.app.model.entidad.personaje.enemigodelatierra.majinboo;

import db.app.model.entidad.personaje.ConsumidorDeKi;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ataqueespecial.ConvierteteEnChocolate;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;

public class MajinBoo extends Personaje implements ConsumidorDeKi {

    public MajinBoo(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.MajinBoo.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.MAJIN_BOO,
                DragonBallZParametros.ParametrosDePersonajes.MajinBoo.SRC_Img,
                posicion);

        mTransformacionNormal = new BooNormal(this);
        mSegundaTransformacion = new BooMalo(this);
        mTerceraTransformacion = new BooOriginal();
        mTransformacionDelPersonaje = mTransformacionNormal;
        mAtaqueEspecial = new ConvierteteEnChocolate(this);
    }

    public MajinBoo() {
        super(DragonBallZParametros.ParametrosDePersonajes.MajinBoo.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.MAJIN_BOO,
                DragonBallZParametros.ParametrosDePersonajes.MajinBoo.SRC_Img);

        mTransformacionNormal = new BooNormal(this);
        mSegundaTransformacion = new BooMalo(this);
        mTerceraTransformacion = new BooOriginal();
        mTransformacionDelPersonaje = mTransformacionNormal;
        mAtaqueEspecial = new ConvierteteEnChocolate(this);
    }
}
