package db.app.model.entidad.personaje.transformacion;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class TransformacionPorEquipoHerido implements ValidadorDeTransformacion {
    private TransformablePorEquipoHerido mTransformablePorEquipoHerido;

    public TransformacionPorEquipoHerido(TransformablePorEquipoHerido mTransformablePorEquipoHerido) {
        this.mTransformablePorEquipoHerido = mTransformablePorEquipoHerido;
    }

    @Override
    public boolean puedoTransformarme() {
        return mTransformablePorEquipoHerido.tuEquipoEstaHerido();
    }
}
