package db.app.model.entidad.personaje.transformacion;

import db.app.model.entidad.personaje.ConsumidorDeKi;

/**
 * Created by joaquinalan on 08/06/2017.
 */
public class TransformacionPorKi implements ValidadorDeTransformacion {
    private ConsumidorDeKi mConsumidorDeKi;
    private int mKiRequerido;

    public TransformacionPorKi(ConsumidorDeKi consumidorDeKi, int kiRequerido) {
        mConsumidorDeKi = consumidorDeKi;
        this.mKiRequerido = kiRequerido;
    }

    @Override
    public boolean puedoTransformarme() {
        boolean puedoTransformarme;
        if (mConsumidorDeKi.getKi() >= mKiRequerido) {
            mConsumidorDeKi.consumirKi(mKiRequerido);
            puedoTransformarme = true;
        } else {
            puedoTransformarme = false;
        }
        return puedoTransformarme;
    }
}
