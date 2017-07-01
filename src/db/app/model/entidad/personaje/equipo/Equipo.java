package db.app.model.entidad.personaje.equipo;

import db.app.exception.*;
import db.app.model.entidad.personaje.ColeccionDePersonajes;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;

import java.util.Iterator;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public abstract class Equipo implements Iterable {
    private String nombre;
    ColeccionDePersonajes mColeccionDePersonajes;

    public Equipo(String nombre) {
        this.nombre = nombre;
        mColeccionDePersonajes = new ColeccionDePersonajes();
    }

    @Override
    public Iterator iterator() {
        return mColeccionDePersonajes.getIterator();
    }

    public void agregarPersonaje(Personaje personaje) throws PersonajeYaExistente {
        mColeccionDePersonajes.agregarPersonaje(personaje);
    }

    public boolean pertenceAEquipo(Personaje personaje) {
        //return mColeccionDePersonajes.existePersonaje(personaje);
        return mColeccionDePersonajes.existePersonaje(personaje.getNombre());
    }

    public Personaje getPersonaje(String nombre) throws StringVacio, NoExistePersonaje {
        return mColeccionDePersonajes.getPersonaje(nombre);
    }

    public Posicion getPosicion(String nombreDePersonaje) throws StringVacio, NoExistePersonaje {
        return mColeccionDePersonajes.getPersonaje(nombreDePersonaje).getPosicion();
    }

    public void transformar(String nombreDePersonaje) throws StringVacio, NoExistePersonaje, IncapazDeTransformarse {
        mColeccionDePersonajes.getPersonaje(nombreDePersonaje).transformar();
    }

    public void actualizarPorTurnoTerminado() throws ElPersonajeEstaMuerto {
        Iterator<Personaje> iterator = mColeccionDePersonajes.getIterator();
        while (iterator.hasNext()) {
            Personaje personaje = iterator.next();
            personaje.actualizarPorTurnoTerminado();
        }
    }

    public ColeccionDePersonajes getmColeccionDePersonajes() {
        return mColeccionDePersonajes;
    }

//    public void setmColeccionDePersonajes(ColeccionDePersonajes mColeccionDePersonajes) {
//        this.mColeccionDePersonajes = mColeccionDePersonajes;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean todosTusPersonajesEstanMuertos() {
        boolean todosMisPersonajesEstanMuertos = true;
        Iterator<Personaje> iterator = mColeccionDePersonajes.getIterator();
        while (iterator.hasNext()) {
            Personaje personaje = iterator.next();
            if (personaje.estasVivo()){
                todosMisPersonajesEstanMuertos=false;
                return false;
            }
        }
        System.out.println(todosMisPersonajesEstanMuertos);
        return todosMisPersonajesEstanMuertos;
    }
}
