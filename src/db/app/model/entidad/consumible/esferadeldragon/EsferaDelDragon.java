package db.app.model.entidad.consumible.esferadeldragon;

import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.consumidor.ConsumidorDeEsferaDelDragon;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;

public class EsferaDelDragon extends Consumible {
    private EstadoDeEsferaDelDragon mEstadoDeEsferaDelDragon;
    private EstadoDeEsferaDelDragon mEstadoDeEsferaDelDragonActivada;
    private EstadoDeEsferaDelDragon mEstadoDeEsferaDelDragonDesactivada;
    private int mCantidadDeAtaquesRestantes;

    public EsferaDelDragon() {
        mEstadoDeEsferaDelDragonActivada = new EsferaDelDragonActivada(this);
        mEstadoDeEsferaDelDragonDesactivada = new EsferaDelDragonDesactivada(this);
        mEstadoDeEsferaDelDragon = mEstadoDeEsferaDelDragonDesactivada;
        this.setSrcImg(DragonBallZParametros.Consumibles.EsferaDelDragon.SRC_Img);
        mCantidadDeAtaquesRestantes = 0;
    }

    @Override
    public void consumir(Personaje personaje) {
        //personaje.setEfectoAtaqueAumentado(personaje.getPoderDePelea() * 0.25);
        personaje.activarEsferaDelDragon();
    }

    public double usarEnAtaque(ConsumidorDeEsferaDelDragon consumidorDeEsferaDelDragon) {
        return mEstadoDeEsferaDelDragon.usarEnAtaque(consumidorDeEsferaDelDragon);
    }

    void restarCantidadDeAtaquesRestantes() {
        mCantidadDeAtaquesRestantes--;
    }

    public void activar() {
        mEstadoDeEsferaDelDragon.activar();
    }

    int getCantidadDeAtaquesRestantes() {
        return mCantidadDeAtaquesRestantes;
    }

    void agregarCantidadDeAtaquesRestantes() {
        mCantidadDeAtaquesRestantes += 2;
    }

    EstadoDeEsferaDelDragon getEstadoDeEsferaDelDragonActivada() {
        return mEstadoDeEsferaDelDragonActivada;
    }

    EstadoDeEsferaDelDragon getEstadoDeEsferaDelDragonDesactivada() {
        return mEstadoDeEsferaDelDragonDesactivada;
    }

    void setEstadoDeEsferaDelDragon(EstadoDeEsferaDelDragon mEstadoDeEsferaDelDragon) {
        this.mEstadoDeEsferaDelDragon = mEstadoDeEsferaDelDragon;
    }
}
