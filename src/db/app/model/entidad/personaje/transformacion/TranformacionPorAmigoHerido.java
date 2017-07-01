package db.app.model.entidad.personaje.transformacion;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class TranformacionPorAmigoHerido implements ValidadorDeTransformacion {
    private TransformablePorAmigoHerido mTransformablePorAmigoHerido;

    public TranformacionPorAmigoHerido(TransformablePorAmigoHerido transformablePorAmigoHerido) {
        mTransformablePorAmigoHerido = transformablePorAmigoHerido;
    }

    @Override
    public boolean puedoTransformarme() {
        return mTransformablePorAmigoHerido.tuAmigoEstaHerido();
    }
}
