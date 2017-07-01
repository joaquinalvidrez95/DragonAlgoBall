package db.app.model.entidad.consumible.nubevoladora;

import db.app.model.entidad.consumidor.ConsumidorDeNubeVoladora;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public interface EstadoDeNubeVoladora {
    int getVelocidad(ConsumidorDeNubeVoladora personaje);

    void actualizarPorTurnoTerminado();

    void activar();
}
