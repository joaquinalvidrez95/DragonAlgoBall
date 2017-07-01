package db.app.model.entidad.personaje;

import db.app.exception.NoExistePersonaje;
import db.app.exception.PersonajeYaExistente;
import db.app.exception.StringVacio;
import db.app.model.entidad.personaje.estado.Personaje;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class ColeccionDePersonajes {
    Hashtable<String, Personaje> mPersonajes;

    public ColeccionDePersonajes() {
        mPersonajes = new Hashtable<>();
    }

    public void agregarPersonaje(Personaje personaje) throws PersonajeYaExistente {
        if (existePersonaje(personaje)) {
            throw new PersonajeYaExistente();
        }
        mPersonajes.put(personaje.getNombre(), personaje);
    }

    public boolean existePersonaje(Personaje personaje) {
        return mPersonajes.contains(personaje);
    }

    public boolean existePersonaje(String nombreDePersonaje) {
        return mPersonajes.containsKey(nombreDePersonaje);
    }

    public Iterator getIterator() {
        return mPersonajes.values().iterator();
    }

    public Personaje getPersonaje(String nombreDePersonaje) throws StringVacio, NoExistePersonaje {
        if (nombreDePersonaje.isEmpty()) {
            throw new StringVacio();
        }
        if (!existePersonaje(nombreDePersonaje)) {
            throw new NoExistePersonaje();
        }
        return mPersonajes.get(nombreDePersonaje);
    }

    public Hashtable<String, Personaje> getmPersonajes() {
        return mPersonajes;
    }

    public void setmPersonajes(Hashtable<String, Personaje> mPersonajes) {
        this.mPersonajes = mPersonajes;
    }

}
