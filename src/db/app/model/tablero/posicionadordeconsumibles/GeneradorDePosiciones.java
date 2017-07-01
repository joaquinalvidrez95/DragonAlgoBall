package db.app.model.tablero.posicionadordeconsumibles;

import db.app.exception.CasilleroNoExistente;
import db.app.exception.PosicionInvalida;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import db.app.model.tablero.casillero.Casillero;

import java.util.Random;

/**
 * Created by franco on 27/06/17.
 */
public class GeneradorDePosiciones {

    private Tablero tablero;
    private Random generadorDePosiciones;

    public GeneradorDePosiciones(Tablero tablero) {
        this.tablero = tablero;
        generadorDePosiciones = new Random();
    }

    public Posicion generarPosicionAleatoria() {
        Posicion posicionAleatoria;
        Casillero casilleroActual;
        while (true) {
            int x = generadorDePosiciones.nextInt(tablero.getLargo());
            int y = generadorDePosiciones.nextInt(tablero.getAltura());
            try {
                posicionAleatoria = new Posicion(x, y);
                casilleroActual = tablero.getCasillero(posicionAleatoria);
            } catch (PosicionInvalida e) {
                continue;
            } catch (CasilleroNoExistente e) {
                continue;
            }
            if (!casilleroActual.estaVacio())
                continue;
            return posicionAleatoria;
        }
    }

}
