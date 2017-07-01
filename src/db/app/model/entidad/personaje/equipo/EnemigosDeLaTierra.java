package db.app.model.entidad.personaje.equipo;

import db.app.exception.PersonajeYaExistente;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.enemigodelatierra.cell.Cell;
import db.app.model.entidad.personaje.enemigodelatierra.freezer.Freezer;
import db.app.model.entidad.personaje.enemigodelatierra.majinboo.MajinBoo;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class EnemigosDeLaTierra extends Equipo {


    public EnemigosDeLaTierra() {
        super(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA);
        try {
            agregarPersonaje(new Freezer());
            agregarPersonaje(new Cell());
            agregarPersonaje(new MajinBoo());
        } catch (PersonajeYaExistente personajeYaExistente) {
            personajeYaExistente.printStackTrace();
        }
    }

//    public Freezer getFreezer() {
//        try {
//            return (Freezer) getPersonaje(NombresDeEnemigosDeLaTierra.FREEZER);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }
//
//    public Cell getCell() {
//        try {
//            return (Cell) getPersonaje(NombresDeEnemigosDeLaTierra.CELL);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }
//
//    public MajinBoo getMajinBoo() {
//        try {
//            return (MajinBoo) getPersonaje(NombresDeEnemigosDeLaTierra.MAJIN_BOO);
//        } catch (StringVacio stringVacio) {
//            stringVacio.printStackTrace();
//        }
//        return null;
//    }

}

