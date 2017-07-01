package db.app.model.entidad.personaje.estado;

import db.app.exception.ElPersonajeEstaMuerto;
import db.app.exception.PersonajeEstaInhabilitado;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public class PersonajeMuerto extends EstadoDePersonaje {

    PersonajeMuerto(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void actualizarPorTurnoTerminado() throws ElPersonajeEstaMuerto {
       // throw new ElPersonajeEstaMuerto();
    }

    @Override
    public void atacar(Personaje enemigo) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        throw new ElPersonajeEstaMuerto();
    }

    @Override
    public void usarAtaqueEspecial(Personaje enemigo) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        throw new ElPersonajeEstaMuerto();
    }

    @Override
    public void mover(Posicion destino, Pisable areaEnDondeMoverse) throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        throw new ElPersonajeEstaMuerto();
    }

    @Override
    public boolean estasVivo() {
        return false;
    }
}
