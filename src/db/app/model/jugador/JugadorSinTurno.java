package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class JugadorSinTurno extends EstadoDeJugador {
    protected JugadorSinTurno(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo {
        throw new NoEsTurnoDeJugador();
    }

    @Override
    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador {
        throw new NoEsTurnoDeJugador();
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, KiInsuficiente, CeldaVacia, CasilleroNoExistente, NoEsTurnoDeJugador {
        throw new NoEsTurnoDeJugador();
    }

    @Override
    public void pasarTurno() throws NoEsTurnoDeJugador {
        throw new NoEsTurnoDeJugador();
    }
}
