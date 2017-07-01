package db.app.model.entidad.personaje.estado;

import db.app.exception.*;
import db.app.model.entidad.personaje.AtaqueBasico;
import db.app.model.entidad.personaje.Movimiento;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public abstract class EstadoDePersonaje {
    protected Personaje mPersonaje;
    // protected int mCantidadDeTurnosInhabilitado = 0;

    protected EstadoDePersonaje(Personaje personaje) {
        mPersonaje = personaje;
    }

    void actualizarPorTurnoTerminado() throws ElPersonajeEstaMuerto {
        mPersonaje.setKi(mPersonaje.getKi() + 5);
    }

    void atacar(Personaje enemigo) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente {
        new AtaqueBasico().atacarA(mPersonaje, enemigo);
    }

    void usarAtaqueEspecial(Personaje enemigo) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, KiInsuficiente, DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo {
        mPersonaje.getAtaqueEspecial().atacar(enemigo);
    }

    void mover(Posicion destino, Pisable areaEnDondeMoverse) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, CaminoBloqueado, PosicionInvalida, CeldaOcupada, CasilleroNoExistente, FaltaDeVelocidad, CeldaVacia {
        Movimiento movimiento = new Movimiento();
        movimiento.mueveme(mPersonaje, areaEnDondeMoverse, destino);
    }

    void perderVida(double dano) {
        double vidaActualizada = mPersonaje.getVida() - dano;

        if (vidaActualizada <= 0) {
            vidaActualizada = 0;
        }

        mPersonaje.setVida(vidaActualizada);
        if (mPersonaje.getVida() <= 0) {
            mPersonaje.setEstadoDelPersonaje(mPersonaje.getPersonajeMuerto());
        }
    }

    void inhabilitar(int cantidadDeTurnosDeshabilitado) {
        mPersonaje.agregarCantidadDeTurnosDeshabilitado(cantidadDeTurnosDeshabilitado);
        mPersonaje.setEstadoDelPersonaje(mPersonaje.getPersonajeInhabilitado());
    }

    public boolean estasVivo() {
        return true;
    }
}
