package db.app.exception;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class CantidadDePersonajesMayorAlNumeroDeFilas extends Exception {

    public CantidadDePersonajesMayorAlNumeroDeFilas() {
        super("La cantidad de Personajes es superior al número de filas del tablero");
    }
}
