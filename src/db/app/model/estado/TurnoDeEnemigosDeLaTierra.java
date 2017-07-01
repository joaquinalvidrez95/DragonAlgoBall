package db.app.model.estado;

import db.app.exception.*;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.jugador.Jugador;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class TurnoDeEnemigosDeLaTierra implements EstadoDelJuego {
    private DragonAlgoBallModel mDragonAlgoBallModel;

    TurnoDeEnemigosDeLaTierra(DragonAlgoBallModel dragonAlgoBallModel) {
        this.mDragonAlgoBallModel = dragonAlgoBallModel;
    }

    @Override
    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, NoEsTurnoDeJugador, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        //try {
        mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra().atacarPersonaje(atacante, atacado);
//        } catch (NoEsTurnoDeJugador noEsTurnoDeJugador) {
//            noEsTurnoDeJugador.printStackTrace();
//        } catch (AtaqueAlMismoEquipo ataqueAlMismoEquipo) {
//            ataqueAlMismoEquipo.printStackTrace();
//        } catch (JugadorYaHabiaAtacado jugadorYaHabiaAtacado) {
//            jugadorYaHabiaAtacado.printStackTrace();
//        } catch (DistanciaDeAtaqueInsuficiente distanciaDeAtaqueInsuficiente) {
//            distanciaDeAtaqueInsuficiente.printStackTrace();
//        } catch (CeldaVacia celdaVacia) {
//            celdaVacia.printStackTrace();
//        } catch (CasilleroNoExistente casilleroNoExistente) {
//            casilleroNoExistente.printStackTrace();
//        } catch (PersonajeEstaInhabilitado personajeEstaInhabilitado) {
//            personajeEstaInhabilitado.printStackTrace();
//        } catch (ElPersonajeEstaMuerto elPersonajeEstaMuerto) {
//            elPersonajeEstaMuerto.printStackTrace();
//        }
    }

    @Override
    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra().moverPersonaje(personajeAMover, casilleroDestino);
    }

    @Override
    public void pasarTurno() throws NoEsTurnoDeJugador {
        Jugador jugadorGuerrerosZ = mDragonAlgoBallModel.getJugadorGuerrerosZ();
        Jugador jugadorEnemigosDeLaTierra = mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra();

        jugadorEnemigosDeLaTierra.pasarTurno();

        try {
            jugadorGuerrerosZ.empezarTurno();
        } catch (JugadorYaTieneElTurno jugadorYaTieneElTurno) {
            jugadorYaTieneElTurno.printStackTrace();
        }

        mDragonAlgoBallModel.setEstadoDelJuego(mDragonAlgoBallModel.getTurnoDeGuerrerosZ());
    }

    @Override
    public void terminarTurnoDeFormaNormal() throws NoEsTurnoDeJugador {
        Jugador jugadorGuerrerosZ = mDragonAlgoBallModel.getJugadorGuerrerosZ();
        Jugador jugadorEnemigosDeLaTierra = mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra();

        jugadorEnemigosDeLaTierra.pasarTurno();
        try {
            jugadorGuerrerosZ.empezarTurno();
        } catch (JugadorYaTieneElTurno jugadorYaTieneElTurno) {
            jugadorYaTieneElTurno.printStackTrace();
        }

        mDragonAlgoBallModel.setEstadoDelJuego(mDragonAlgoBallModel.getTurnoDeGuerrerosZ());
    }

    @Override
    public String getNombreEquipo() {
        return DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA;
    }

    @Override
    public boolean esTurnoDePersonaje(Posicion posicion) {
        //return mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra();
        return true;
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, ElPersonajeEstaMuerto, DistanciaDeAtaqueInsuficiente, JugadorYaHabiaAtacado, CasilleroNoExistente, KiInsuficiente, PersonajeEstaInhabilitado, CeldaVacia, NoEsTurnoDeJugador {
        mDragonAlgoBallModel.getJugadorEnemigosDeLaTierra().usarAtaqueEspecial(atacante, atacado);
    }

    @Override
    public boolean yaGanaste() {
        boolean yaGanaste;
        Jugador jugador = mDragonAlgoBallModel.getJugadorGuerrerosZ();
        yaGanaste = jugador.todosTusPersonajesEstanMuertos();
        return yaGanaste;
    }

}
