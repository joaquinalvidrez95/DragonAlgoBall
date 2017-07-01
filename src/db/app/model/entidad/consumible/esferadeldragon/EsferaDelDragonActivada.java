package db.app.model.entidad.consumible.esferadeldragon;

import db.app.model.entidad.consumidor.ConsumidorDeEsferaDelDragon;

/**
 * Created by joaquinalan on 26/06/2017.
 */
public class EsferaDelDragonActivada implements EstadoDeEsferaDelDragon {
    private EsferaDelDragon mEsferaDelDragon;

    public EsferaDelDragonActivada(EsferaDelDragon esferaDelDragon) {
        mEsferaDelDragon = esferaDelDragon;
    }

    @Override
    public double usarEnAtaque(ConsumidorDeEsferaDelDragon consumidorDeEsferaDelDragon) {
        mEsferaDelDragon.restarCantidadDeAtaquesRestantes();
        if (mEsferaDelDragon.getCantidadDeAtaquesRestantes() == 0) {
            mEsferaDelDragon.setEstadoDeEsferaDelDragon(mEsferaDelDragon.getEstadoDeEsferaDelDragonDesactivada());
        }
        return consumidorDeEsferaDelDragon.getPoderDePelea() * 0.25;
    }

    @Override
    public void activar() {
        mEsferaDelDragon.agregarCantidadDeAtaquesRestantes();
    }
}
