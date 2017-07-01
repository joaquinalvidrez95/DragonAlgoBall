package db.app.model.entidad.personaje.estado;

/**
 * Created by joaquinalan on 22/06/2017.
 */
class PersonajeHabilitado extends EstadoDePersonaje {

    PersonajeHabilitado(Personaje personaje) {
        super(personaje);
        mPersonaje = personaje;
    }

}
