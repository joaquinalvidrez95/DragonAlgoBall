package db.app.model.entidad.consumible.esferadeldragon;

import db.app.model.entidad.consumidor.ConsumidorDeEsferaDelDragon;

/**
 * Created by joaquinalan on 26/06/2017.
 */
public class EsferaDelDragonDesactivada implements EstadoDeEsferaDelDragon {
    private EsferaDelDragon mEsferaDelDragon;

    public EsferaDelDragonDesactivada(EsferaDelDragon esferaDelDragon) {
        mEsferaDelDragon = esferaDelDragon;
    }

    @Override
    public double usarEnAtaque(ConsumidorDeEsferaDelDragon consumidorDeEsferaDelDragon) {
        return 0;
    }

    @Override
    public void activar() {
        mEsferaDelDragon.setEstadoDeEsferaDelDragon(mEsferaDelDragon.getEstadoDeEsferaDelDragonActivada());
        mEsferaDelDragon.agregarCantidadDeAtaquesRestantes();
    }
}
