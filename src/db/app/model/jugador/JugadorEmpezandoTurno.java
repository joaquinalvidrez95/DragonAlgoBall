package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class JugadorEmpezandoTurno extends EstadoDeJugador {
    protected JugadorEmpezandoTurno(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        super.atacarPersonaje(atacante, atacado);
        mJugador.setEstado(mJugador.getJugadorYaAtaco());
    }

    @Override
    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        super.moverPersonaje(personajeAMover, casilleroDestino);
        mJugador.setEstado(mJugador.getJugadorYaMovio());
    }

    @Override
    public void empezarTurno() throws JugadorYaTieneElTurno {
        throw new JugadorYaTieneElTurno();
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, KiInsuficiente, CeldaVacia, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaAtacado {
        super.usarAtaqueEspecial(atacante, atacado);
        mJugador.setEstado(mJugador.getJugadorYaAtaco());
    }
}
