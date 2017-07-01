package db.app.model.entidad.personaje.ataqueespecial;

import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.DragonBallZParametros;


/**
 * Created by joaquinalan on 15/06/2017.
 */
public class Makankosappo extends AtaqueEspecialSinEfectos {
    public Makankosappo(Atacante mAtacante) {
        super(mAtacante, DragonBallZParametros.AtaquesEspeciales.Makankosappo.COSTO, 25,
                DragonBallZParametros.AtaquesEspeciales.Makankosappo.NOMBRE);
    }
}
