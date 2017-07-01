package db.app.model.entidad.consumible.nubevoladora;

import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.consumidor.ConsumidorDeNubeVoladora;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;

public class NubeVoladora extends Consumible {
    private EstadoDeNubeVoladora mEstadoDeNubeVoladora;
    private EstadoDeNubeVoladora mNubeVoladoraActivada;
    private EstadoDeNubeVoladora mNubeVoladoraDesactivada;
    //private Personaje mPersonaje;

    private int mCantidadDeTurnosRestantes = 0;
    //private int mVelocidadParaAumentar;

    public NubeVoladora() {
        mNubeVoladoraActivada = new NubeVoladoraActivada(this);
        mNubeVoladoraDesactivada = new NubeVoladoraDesactivada(this);
        this.setSrcImg(DragonBallZParametros.Consumibles.NubeVoladora.SRC_Img);
        mEstadoDeNubeVoladora = mNubeVoladoraDesactivada;
    }

    @Override
    public void consumir(Personaje personaje) {
        //mVelocidadParaAumentar = personaje.getVelocidadSinNubeVoladora();
        //personaje.setEfectoVelocidadAumentada(personaje.getVelocidad());
        personaje.activarNubeVoladora();
    }

    public int getVelocidad(ConsumidorDeNubeVoladora consumidorDeNubeVoladora) {
        return mEstadoDeNubeVoladora.getVelocidad(consumidorDeNubeVoladora);
    }

    public void activar() {
        mEstadoDeNubeVoladora.activar();
    }

    public void actualizarPorTurnoTerminado() {
        mEstadoDeNubeVoladora.actualizarPorTurnoTerminado();
    }

    EstadoDeNubeVoladora getNubeVoladoraActivada() {
        return mNubeVoladoraActivada;
    }

    EstadoDeNubeVoladora getNubeVoladoraDesactivada() {
        return mNubeVoladoraDesactivada;
    }

    void setEstadoNubeVoladora(EstadoDeNubeVoladora estadoNubeVoladora) {
        mEstadoDeNubeVoladora = estadoNubeVoladora;
    }

    int getCantidadDeTurnosRestantes() {
        return mCantidadDeTurnosRestantes;
    }

    void restarCantidadDeTurnosRestantes() {
        this.mCantidadDeTurnosRestantes--;
    }

//    int getVelocidadParaAumentar() {
//        return mVelocidadParaAumentar;
//    }

    void agregarCantidadDeTurnosRestantes() {
        mCantidadDeTurnosRestantes += 3;
    }
}
