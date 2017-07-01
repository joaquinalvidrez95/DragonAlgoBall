package db.app.model.entidad.personaje.enemigodelatierra.cell;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorAbsorcion;
import db.app.model.entidad.personaje.transformacion.ValidadorDeTransformacion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class CellSemiPerfecto implements TransformacionDelPersonaje {
    private Cell mCell;
    private ValidadorDeTransformacion mTransformacionPorAbsorcion;

    public CellSemiPerfecto(Cell cell) {
        mTransformacionPorAbsorcion = new TransformacionPorAbsorcion(cell, 8);
        mCell = cell;
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorAbsorcion.puedoTransformarme()) {
            mCell.setTransformacionDelPersonaje(mCell.getTerceraTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
