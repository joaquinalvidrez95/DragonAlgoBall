package db.app.model.estado;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public interface EstadoDelJuego {
    void atacarPersonaje(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, NoEsTurnoDeJugador, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto;

    void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia;

    void pasarTurno() throws NoEsTurnoDeJugador;

    void terminarTurnoDeFormaNormal() throws NoEsTurnoDeJugador;

    String getNombreEquipo();

    boolean esTurnoDePersonaje(Posicion posicion);

    void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, ElPersonajeEstaMuerto, DistanciaDeAtaqueInsuficiente, JugadorYaHabiaAtacado, CasilleroNoExistente, KiInsuficiente, PersonajeEstaInhabilitado, CeldaVacia, NoEsTurnoDeJugador;

    boolean yaGanaste();
}
