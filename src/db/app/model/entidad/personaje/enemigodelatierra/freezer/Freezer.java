package db.app.model.entidad.personaje.enemigodelatierra.freezer;

import db.app.model.entidad.personaje.ConsumidorDeKi;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ataqueespecial.RayoMortal;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;

public class Freezer extends Personaje implements ConsumidorDeKi {

    public Freezer(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.Freezer.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.FREEZER,
                DragonBallZParametros.ParametrosDePersonajes.Freezer.SRC_Img,
                posicion);

        mTransformacionNormal = new FreezerNormal(this);
        mSegundaTransformacion = new FreezerSegundaForma(this);
        mTerceraTransformacion = new FreezerDefinitivo();
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new RayoMortal(this);
    }

    public Freezer() {
        super(DragonBallZParametros.ParametrosDePersonajes.Freezer.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.FREEZER,
                DragonBallZParametros.ParametrosDePersonajes.Freezer.SRC_Img);

        mTransformacionNormal = new FreezerNormal(this);
        mSegundaTransformacion = new FreezerSegundaForma(this);
        mTerceraTransformacion = new FreezerDefinitivo();
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new RayoMortal(this);
    }

}
