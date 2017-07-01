package db.app.model.entidad.personaje.transformacion;

/**
 * Created by joaquinalan on 08/06/2017.
 */
public class TransformacionPorAbsorcion implements ValidadorDeTransformacion {
    private int mCantidadDeAbsorcionesNecesarias;
    private TransformablePorAbsorcion mTransformablePorAbsorcion;

    public TransformacionPorAbsorcion(TransformablePorAbsorcion transformablePorAbsorcion,
                                      int cantidadDeAbsorcionesNecesarias) {
        mTransformablePorAbsorcion = transformablePorAbsorcion;
        mCantidadDeAbsorcionesNecesarias = cantidadDeAbsorcionesNecesarias;
    }

    @Override
    public boolean puedoTransformarme() {
        return (mTransformablePorAbsorcion.getCantidadDeAbsorcionesHechas() >= mCantidadDeAbsorcionesNecesarias);
    }
}
