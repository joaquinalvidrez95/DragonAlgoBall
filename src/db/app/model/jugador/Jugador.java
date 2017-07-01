package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.equipo.Equipo;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.estado.DragonAlgoBallModel;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class Jugador {
    private String nombreJugador;
    private Equipo mEquipo;
    private DragonAlgoBallModel mDragonAlgoBallModel;
    private EstadoDeJugador mEstadoDeJugador;
    private EstadoDeJugador mJugadorEmpezandoTurno;
    private EstadoDeJugador mJugadorYaMovio;
    private EstadoDeJugador mJugadorYaAtaco;
    private EstadoDeJugador mJugadorSinTurno;

    public Jugador(DragonAlgoBallModel dragonAlgoBallModel, Equipo equipo, String nombre) {
        mDragonAlgoBallModel = dragonAlgoBallModel;
        mEquipo = equipo;
        nombreJugador = nombre;
        mJugadorEmpezandoTurno = new JugadorEmpezandoTurno(this);
        mJugadorYaMovio = new JugadorYaMovio(this);
        mJugadorYaAtaco = new JugadorYaAtaco(this);
        mJugadorSinTurno = new JugadorSinTurno(this);
        mEstadoDeJugador = mJugadorSinTurno;
    }

    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        //try {
        mEstadoDeJugador.atacarPersonaje(atacante, atacado);
//        } catch (NoEsTurnoDeJugador noEsTurnoDeJugador) {
//            noEsTurnoDeJugador.printStackTrace();
//        } catch (AtaqueAlMismoEquipo ataqueAlMismoEquipo) {
//            ataqueAlMismoEquipo.printStackTrace();
//        } catch (JugadorYaHabiaAtacado jugadorYaHabiaAtacado) {
//            jugadorYaHabiaAtacado.printStackTrace();
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

    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, JugadorYaHabiaMovido, NoEsTurnoDeJugador, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        mEstadoDeJugador.moverPersonaje(personajeAMover, casilleroDestino);
    }

    public void pasarTurno() throws NoEsTurnoDeJugador {
        mEstadoDeJugador.pasarTurno();
    }

    void setEstado(EstadoDeJugador estadoDeJugador) {
        mEstadoDeJugador = estadoDeJugador;
    }

    public EstadoDeJugador getEstado() {
        return mEstadoDeJugador;
    }

    public Equipo getEquipo() {
        return mEquipo;
    }

    public EstadoDeJugador getJugadorEmpezandoTurno() {
        return mJugadorEmpezandoTurno;
    }

    EstadoDeJugador getJugadorYaMovio() {
        return mJugadorYaMovio;
    }

    EstadoDeJugador getJugadorYaAtaco() {
        return mJugadorYaAtaco;
    }

    EstadoDeJugador getJugadorSinTurno() {
        return mJugadorSinTurno;
    }

    public void empezarTurno() throws JugadorYaTieneElTurno {
        mEstadoDeJugador.empezarTurno();
    }

    DragonAlgoBallModel getDragonAlgoBallModel() {
        return mDragonAlgoBallModel;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, ElPersonajeEstaMuerto, DistanciaDeAtaqueInsuficiente, JugadorYaHabiaAtacado, CasilleroNoExistente, KiInsuficiente, PersonajeEstaInhabilitado, CeldaVacia, NoEsTurnoDeJugador {
        mEstadoDeJugador.usarAtaqueEspecial(atacante, atacado);
    }

    public boolean todosTusPersonajesEstanMuertos() {
        return mEquipo.todosTusPersonajesEstanMuertos();
    }

    public void actualizarPersonajesPorTurnoTerminado() {
        try {
            mEquipo.actualizarPorTurnoTerminado();
        } catch (ElPersonajeEstaMuerto elPersonajeEstaMuerto) {
        }
    }
}
