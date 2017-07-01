package db.app.model.entidad.consumible.esferadeldragon;

import db.app.model.entidad.consumidor.ConsumidorDeEsferaDelDragon;

/**
 * Created by joaquinalan on 26/06/2017.
 */
public interface EstadoDeEsferaDelDragon {
    double usarEnAtaque(ConsumidorDeEsferaDelDragon consumidorDeEsferaDelDragon);

    void activar();
}
