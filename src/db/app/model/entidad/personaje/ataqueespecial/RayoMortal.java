package db.app.model.entidad.personaje.ataqueespecial;


import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.DragonBallZParametros;


/**
 * Created by joaquinalan on 15/06/2017.
 */
public class RayoMortal extends AtaqueEspecialSinEfectos {
    public RayoMortal(Atacante mAtacante) {
        super(mAtacante, DragonBallZParametros.AtaquesEspeciales.RayoMortal.COSTO,
                50, DragonBallZParametros.AtaquesEspeciales.RayoMortal.NOMBRE);
    }
}
