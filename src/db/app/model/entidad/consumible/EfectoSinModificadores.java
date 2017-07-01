package db.app.model.entidad.consumible;


public class EfectoSinModificadores implements EfectoConsumible {

    @Override
    public double modificadorDeAtaque() {
        return 0;
    }

    @Override
    public int modificadorDeVelocidad() {
        return 0;
    }

}
