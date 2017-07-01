package db.app.model.jugador;

import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.casillero.Casillero;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class JugadorYaMovio extends EstadoDeJugador {
    protected JugadorYaMovio(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void moverPersonaje(Personaje personajeAMover, Casillero casilleroDestino) throws CeldaOcupada, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaMovido {
        throw new JugadorYaHabiaMovido();
    }

    @Override
    public void empezarTurno() throws JugadorYaTieneElTurno {
        throw new JugadorYaTieneElTurno();
    }

    @Override
    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, KiInsuficiente, CeldaVacia, CasilleroNoExistente, NoEsTurnoDeJugador, JugadorYaHabiaAtacado {
        super.usarAtaqueEspecial(atacante, atacado);
        mJugador.getDragonAlgoBallModel().terminarTurnoDeFormaNormal();
    }

    @Override
    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws NoEsTurnoDeJugador, AtaqueAlMismoEquipo, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CeldaVacia, CasilleroNoExistente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        //try {
        super.atacarPersonaje(atacante, atacado);
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
        mJugador.getDragonAlgoBallModel().terminarTurnoDeFormaNormal();
    }
}
