package db.app.model.tablero.posicionadordeconsumibles;

import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.consumible.esferadeldragon.EsferaDelDragon;
import db.app.model.entidad.consumible.nubevoladora.NubeVoladora;
import db.app.model.entidad.consumible.semilladelermitano.SemillaDelErmitano;

import java.util.Random;

/**
 * Created by franco on 27/06/17.
 */
public class GeneradorDeConsumibles {
    private final int CREAR_ESFERA_DEL_DRAGON = 0;
    private final int CREAR_NUBE_VOLADORA = 1;
    private final int CREAR_SEMILLA_DEL_ERMITANO = 2;

    private Random generadorDeProbabilidades;

    public GeneradorDeConsumibles() {
        generadorDeProbabilidades = new Random();
    }

    public Consumible generarConsumible() {
        int probabilidad = generadorDeProbabilidades.nextInt(3);
        Consumible consumible;
        switch (probabilidad) {
            case CREAR_ESFERA_DEL_DRAGON:
                consumible = new EsferaDelDragon();
                break;
            case CREAR_NUBE_VOLADORA:
                consumible = new NubeVoladora();
                break;
            case CREAR_SEMILLA_DEL_ERMITANO:
                consumible = new SemillaDelErmitano();
                break;
            default:
                consumible = new SemillaDelErmitano();
                break;
        }
        return consumible;
    }
}
