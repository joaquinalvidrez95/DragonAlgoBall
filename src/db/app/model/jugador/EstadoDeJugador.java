package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Tablero;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public abstract class EstadoDeJugador {
    protected Jugador mJugador;

    protected EstadoDeJugador(Jugador jugador) {
        this.mJugador = jugador;
    }

    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo, JugadorYaHabiaAtacado, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, DistanciaDeAtaqueInsuficiente {
        if (mJugador.getEquipo().pertenceAEquipo(atacante)) {
            throw new NoEsTurnoDeJugador();
        }
        if (!mJugador.getEquipo().pertenceAEquipo(atacado)) {
            throw new AtaqueAlMismoEquipo();
        }
        atacante.atacar(atacado);
        if (atacado.getVida() <= 0) {
            mJugador.getDragonAlgoBallModel().getTablero().limpiarCasillero(atacado.getPosicion());

        }
    }

    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        Tablero tablero = mJugador.getDragonAlgoBallModel().getTablero();
        personajeAMover.mover(casilleroDestino.getPosition(), tablero);
    }

    public void pasarTurno() throws NoEsTurnoDeJugador {
        mJugador.setEstado(mJugador.getJugadorSinTurno());
    }

    public void empezarTurno() throws JugadorYaTieneElTurno {
        mJugador.setEstado(mJugador.getJugadorEmpezandoTurno());
    }

    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, KiInsuficiente, CeldaVacia, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaAtacado {
        if (mJugador.getEquipo().pertenceAEquipo(atacante)) {
            throw new NoEsTurnoDeJugador();
        }
        if (!mJugador.getEquipo().pertenceAEquipo(atacado)) {
            throw new AtaqueAlMismoEquipo();
        }
        atacante.usarAtaqueEspecial(atacado);
        if (atacado.getVida() <= 0) {
            mJugador.getDragonAlgoBallModel().getTablero().limpiarCasillero(atacado.getPosicion());
        }
    }
}
