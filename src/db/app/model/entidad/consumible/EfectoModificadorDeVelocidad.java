package db.app.model.entidad.consumible;

public class EfectoModificadorDeVelocidad implements EfectoConsumible {

    private int bonificacionDeVelocidad;

    public EfectoModificadorDeVelocidad(int bonificacionDeVelocidad) {
        this.bonificacionDeVelocidad = bonificacionDeVelocidad;
    }

    @Override
    public double modificadorDeAtaque() {
        return 0;
    }

    @Override
    public int modificadorDeVelocidad() {
        return bonificacionDeVelocidad;
    }

}
