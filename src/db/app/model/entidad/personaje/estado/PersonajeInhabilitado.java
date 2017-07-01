package db.app.model.entidad.personaje.estado;

import db.app.exception.PersonajeEstaInhabilitado;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public class PersonajeInhabilitado extends EstadoDePersonaje {

    PersonajeInhabilitado(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void actualizarPorTurnoTerminado() {
//        int cantidadDeTurnosInhabilitado = mPersonaje.getCantidadDeTurnosDeshabilitado();
//        cantidadDeTurnosInhabilitado--;
        mPersonaje.restarCantidadDeTurnosDeshabilitado();
        if (mPersonaje.getCantidadDeTurnosDeshabilitado() == 0) {
            mPersonaje.setEstadoDelPersonaje(mPersonaje.getPersonajeHabilitado());
        }
    }

    @Override
    public void atacar(Personaje enemigo) throws PersonajeEstaInhabilitado {
        throw new PersonajeEstaInhabilitado();
    }

    @Override
    public void usarAtaqueEspecial(Personaje enemigo) throws PersonajeEstaInhabilitado {
        throw new PersonajeEstaInhabilitado();
    }

    @Override
    public void mover(Posicion destino, Pisable areaEnDondeMoverse) throws PersonajeEstaInhabilitado {
        throw new PersonajeEstaInhabilitado();
    }
}
