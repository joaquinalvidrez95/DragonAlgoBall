package db.app.model.tablero.posicionadordeconsumibles;

import db.app.exception.CasilleroNoExistente;
import db.app.exception.CeldaOcupada;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;

import java.util.Random;


public class PosicionadorDeConsumibles {

    private Tablero tablero;
    private GeneradorDeConsumibles generadorDeConsumibles;
    private Random generadorDeProbabilidades;
    private GeneradorDePosiciones generadorDePosiciones;
    private int probabilidad = 40;

    public PosicionadorDeConsumibles(Tablero tablero) {
        this.tablero = tablero;
        generadorDeConsumibles = new GeneradorDeConsumibles();
        generadorDePosiciones = new GeneradorDePosiciones(tablero);
        generadorDeProbabilidades = new Random();
    }

    public void colocarConsumible() throws CeldaOcupada, CasilleroNoExistente {
        if (generadorDeProbabilidades.nextInt(100) > probabilidad)
            return;
        Posicion posicionAColocar = generadorDePosiciones.generarPosicionAleatoria();
        Consumible nuevoConsumible = generadorDeConsumibles.generarConsumible();
        tablero.colocarConsumible(posicionAColocar, nuevoConsumible);

    }
}
