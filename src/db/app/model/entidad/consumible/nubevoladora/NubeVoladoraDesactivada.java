package db.app.model.entidad.consumible.nubevoladora;

import db.app.model.entidad.consumidor.ConsumidorDeNubeVoladora;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public class NubeVoladoraDesactivada implements EstadoDeNubeVoladora {
    private NubeVoladora mNubeVoladora;

    NubeVoladoraDesactivada(NubeVoladora nubeVoladora) {
        mNubeVoladora = nubeVoladora;
    }

    @Override
    public int getVelocidad(ConsumidorDeNubeVoladora personaje) {
        return 0;
    }

    @Override
    public void actualizarPorTurnoTerminado() {

    }

    @Override
    public void activar() {
        mNubeVoladora.setEstadoNubeVoladora(mNubeVoladora.getNubeVoladoraActivada());
        mNubeVoladora.agregarCantidadDeTurnosRestantes();
    }
}
