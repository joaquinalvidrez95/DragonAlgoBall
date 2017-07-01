package db.app.model.entidad.personaje.enemigodelatierra.cell;

import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.exception.KiInsuficiente;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ataqueespecial.Absorbedor;
import db.app.model.entidad.personaje.ataqueespecial.Absorcion;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.transformacion.TransformablePorAbsorcion;
import db.app.model.tablero.Posicion;

public class Cell extends Personaje implements TransformablePorAbsorcion, Absorbedor {
    private Absorcion mAbsorcion;

    public Cell(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.CELL,
                DragonBallZParametros.ParametrosDePersonajes.Cell.SRC_Img,
                posicion);

        mTransformacionNormal = new CellNormal(this);
        mSegundaTransformacion = new CellSemiPerfecto(this);
        mTerceraTransformacion = new CellPerfecto();
        mTransformacionDelPersonaje = mTransformacionNormal;
        mAtaqueEspecial = new Absorcion(this);
        mAbsorcion = new Absorcion(this);
    }

    public Cell() {
        super(DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA,
                DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.CELL,
                DragonBallZParametros.ParametrosDePersonajes.Cell.SRC_Img);

        mTransformacionNormal = new CellNormal(this);
        mSegundaTransformacion = new CellSemiPerfecto(this);
        mTerceraTransformacion = new CellPerfecto();
        mTransformacionDelPersonaje = mTransformacionNormal;
        mAtaqueEspecial = new Absorcion(this);
        mAbsorcion = new Absorcion(this);
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente {
        mAbsorcion.atacar(atacado);
    }

    @Override
    public int getCantidadDeAbsorcionesHechas() {
        return mAbsorcion.getCantidadDeAbsorcionesHechas();
    }
}
