package db.app.model.entidad.personaje.ataqueespecial;


import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.DragonBallZParametros;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class Masenko extends AtaqueEspecialSinEfectos {
    public Masenko(Atacante mAtacante) {
        super(mAtacante, DragonBallZParametros.AtaquesEspeciales.Masenko.COSTO,
                25, DragonBallZParametros.AtaquesEspeciales.Masenko.NOMBRE);
    }
}
