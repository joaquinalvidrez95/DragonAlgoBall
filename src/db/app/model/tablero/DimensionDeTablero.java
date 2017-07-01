package db.app.model.tablero;

import db.app.exception.DimensionesDelTableroInvalidas;

/**
 * Created by joaquinalan on 11/06/2017.
 */
public class DimensionDeTablero {
    private final int mCantidadDeFilas;
    private final int mCantidadDeColumnas;

    public DimensionDeTablero(int cantidadDeFilas, int cantidadDeColumnas) throws DimensionesDelTableroInvalidas {
        if (cantidadDeFilas <= 0 || cantidadDeColumnas < 2) {
            throw new DimensionesDelTableroInvalidas();
        }
        this.mCantidadDeFilas = cantidadDeFilas;
        this.mCantidadDeColumnas = cantidadDeColumnas;
    }

    public int getCantidadDeFilas() {
        return mCantidadDeFilas;
    }

    public int getCantidadDeColumnas() {
        return mCantidadDeColumnas;
    }
}
