package db.app.model.entidad.personaje.ataqueespecial;

import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.DragonBallZParametros;


public class Kamehameha extends AtaqueEspecialSinEfectos {
    public Kamehameha(Atacante mAtacante) {
        super(mAtacante, DragonBallZParametros.AtaquesEspeciales.Kamehameha.COSTO, 50, DragonBallZParametros.AtaquesEspeciales.Kamehameha.NOMBRE);
    }
}
