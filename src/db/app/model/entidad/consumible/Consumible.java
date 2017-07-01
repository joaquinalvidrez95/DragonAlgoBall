package db.app.model.entidad.consumible;

import db.app.model.entidad.Posicionable;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Posicion;

public abstract class Consumible implements Posicionable {

    private Posicion mPosicion;
    private String srcImg;


    @Override
    public void setPosicion(Posicion posicion) {
        //
        mPosicion = posicion;
    }

    @Override
    public Posicion getPosicion() {
        return mPosicion;
    }

    public abstract void consumir(Personaje personaje);


    public String getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }
}
