package db.app.model.entidad.personaje.equipo;


import db.app.exception.PersonajeYaExistente;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;


/**
 * Created by joaquinalan on 11/06/2017.
 */
public class GuerrerosZ extends Equipo {
    public GuerrerosZ() {
        super(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z);
        try {
            agregarPersonaje(new Goku());
            agregarPersonaje(new Gohan());
            agregarPersonaje(new Piccolo());
        } catch (PersonajeYaExistente personajeYaExistente) {
            personajeYaExistente.printStackTrace();
        }
    }

//    public Goku getGoku() {
//        try {
//            return (Goku) getPersonaje(NombresDeEnemigosDeLaTierra.GOKU);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }
//
//    public Gohan getGohan() {
//        try {
//            return (Gohan) getPersonaje(NombresDeEnemigosDeLaTierra.GOHAN);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }
//
//    public Piccolo getPiccolo() {
//        try {
//            return (Piccolo) getPersonaje(NombresDeEnemigosDeLaTierra.PICCOLO);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }

}
