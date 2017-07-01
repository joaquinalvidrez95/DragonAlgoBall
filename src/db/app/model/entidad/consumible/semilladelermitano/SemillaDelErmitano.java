package db.app.model.entidad.consumible.semilladelermitano;

import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;

public class SemillaDelErmitano extends Consumible {

    @Override
    public void consumir(Personaje personaje) {
        personaje.aumentarVida(100);
    }

    public SemillaDelErmitano() {
        this.setSrcImg(DragonBallZParametros.Consumibles.SemillaDelErmitano.SRC_Img);
    }


}
