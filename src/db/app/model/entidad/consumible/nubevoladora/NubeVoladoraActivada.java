package db.app.model.entidad.consumible.nubevoladora;

import db.app.model.entidad.consumidor.ConsumidorDeNubeVoladora;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public class NubeVoladoraActivada implements EstadoDeNubeVoladora {

    private NubeVoladora mNubeVoladora;

    NubeVoladoraActivada(NubeVoladora nubeVoladora) {
        mNubeVoladora = nubeVoladora;
    }

    @Override
    public int getVelocidad(ConsumidorDeNubeVoladora personaje) {
        return personaje.getVelocidadSinNubeVoladora();
    }

    @Override
    public void actualizarPorTurnoTerminado() {
        mNubeVoladora.restarCantidadDeTurnosRestantes();

        if (mNubeVoladora.getCantidadDeTurnosRestantes() == 0) {
            mNubeVoladora.setEstadoNubeVoladora(mNubeVoladora.getNubeVoladoraDesactivada());
        }
    }

    @Override
    public void activar() {
        mNubeVoladora.agregarCantidadDeTurnosRestantes();
    }
}
