package db.app.model.tablero;

import db.app.exception.PosicionInvalida;

import java.util.Objects;

/**
 * Created by joaquinalan on 06/06/2017.
 */
public class Posicion {
    private int mY;
    private int mX;

    public Posicion(int x, int y) throws PosicionInvalida {
        if (x <= 0 || y <= 0) {
            throw new PosicionInvalida();
        }
        this.mX = x;
        this.mY = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Posicion)) {
            return false;
        }
        Posicion posicion = (Posicion) obj;
        //return mY.getNumber() == posicion.mY.getNumber() &&
        ////Objects.equals(mX.getNumber(), posicion.mX.getNumber());
//                mX.getNumber() == posicion.mX.getNumber();
        return ((mY == posicion.mY) && (mX == posicion.mX));
    }

    @Override
    public int hashCode() {
        return Objects.hash(mY, mX);
    }

    public int getY() {
        return mY;
    }

    public int getX() {
        return mX;
    }
}
