package db.app.model.entidad.personaje.enemigodelatierra.cell;

import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class CellPerfecto implements TransformacionDelPersonaje {

    @Override
    public double getPoderDePelea() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellPerfecto.PODER_DE_PELEA;
    }

    @Override
    public int getDistanciaAtaque() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellPerfecto.DISTANCIA_DE_ATAQUE;
    }

    @Override
    public int getVelocidad() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellPerfecto.VELOCIDAD;
    }

    @Override
    public String getNombreEstado() {
        return DragonBallZParametros.ParametrosDePersonajes.Cell.CellPerfecto.NOMBRE;
    }

    @Override
    public void transform() throws IncapazDeTransformarse {
        throw new IncapazDeTransformarse();
    }
}
