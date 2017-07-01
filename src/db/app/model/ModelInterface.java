package db.app.model;

/**
 * Created by joaquinalan on 28/06/2017.
 */
public interface ModelInterface {
    //boolean esTurnoDePersonaje(Posicion posicion);
    void registrarObservador(ObservadorDeModelo observadorDeModelo);
    void desregistrarObservador(ObservadorDeModelo observadorDeModelo);
    void notificarObservadoresQuienGano(String nombreDelGanador);

}
