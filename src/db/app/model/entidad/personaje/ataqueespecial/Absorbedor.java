package db.app.model.entidad.personaje.ataqueespecial;

import db.app.model.entidad.personaje.Atacante;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public interface Absorbedor extends Atacante {
    void aumentarVida(double poderDePeleaDelAtacante);
}
