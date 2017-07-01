package db.app.model.entidad.personaje.enemigodelatierra.cell;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.transformacion.TransformacionPorAbsorcion;
import db.app.model.entidad.personaje.transformacion.ValidadorDeTransformacion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class CellNormal implements TransformacionDelPersonaje {
    private Cell mCell;
    private ValidadorDeTransformacion mTransformacionPorAbsorcion;

    public CellNormal(Cell cell) {
        mTransformacionPorAbsorcion = new TransformacionPorAbsorcion(cell, 4);
        mCell = cell;
    }

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        if (mTransformacionPorAbsorcion.puedoTransformarme()) {
            mCell.setTransformacionDelPersonaje(mCell.getSegundaTransformacion());
        } else {
            throw new IncapazDeTransformarse();
        }
    }
}
