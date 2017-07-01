package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class JugadorYaAtaco extends EstadoDeJugador {
    protected JugadorYaAtaco(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo, JugadorYaHabiaAtacado {
        throw new JugadorYaHabiaAtacado();
    }

    @Override
    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        super.moverPersonaje(personajeAMover, casilleroDestino);
        mJugador.getDragonAlgoBallModel().terminarTurnoDeFormaNormal();
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, KiInsuficiente, CeldaVacia, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaAtacado {
        throw new JugadorYaHabiaAtacado();
    }

    @Override
    public void empezarTurno() throws JugadorYaTieneElTurno {
        throw new JugadorYaTieneElTurno();
    }
}
