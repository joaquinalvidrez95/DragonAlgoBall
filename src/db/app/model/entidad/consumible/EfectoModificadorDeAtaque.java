package db.app.model.entidad.consumible;


public class EfectoModificadorDeAtaque implements EfectoConsumible {

    private double bonificacionDeAtaque;

    public EfectoModificadorDeAtaque(double bonificacionDeAtaque) {
        this.bonificacionDeAtaque = bonificacionDeAtaque;
    }

    @Override
    public double modificadorDeAtaque() {
        return bonificacionDeAtaque;
    }

    @Override
    public int modificadorDeVelocidad() {
        return 0;
    }

}
