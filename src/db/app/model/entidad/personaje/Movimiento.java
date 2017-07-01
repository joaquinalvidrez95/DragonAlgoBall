package db.app.model.entidad.personaje;

import db.app.exception.*;
import db.app.model.entidad.ValidadorDeDistancias;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

/**
 * Created by joaquinalan on 14/06/2017.
 */
public class Movimiento {
    //private Pisable mPisable;
    //private Movible mMovible;
    private ValidadorDeDistancias mValidadorDeDistancias;

    public Movimiento() {
        //this.mPisable = pisable;
        //mMovible = movible;
        mValidadorDeDistancias = new ValidadorDeDistancias();
    }

    public void mueveme(Personaje personaje, Pisable areaEnDondeMoverse, Posicion posicionFinal) throws PosicionInvalida, CasilleroNoExistente, FaltaDeVelocidad, CaminoBloqueado, CeldaOcupada, CeldaVacia {
        if (!mValidadorDeDistancias.esValidaLaDistancia(personaje.getPosicion(), posicionFinal, personaje.getVelocidad())) {
            throw new FaltaDeVelocidad();
        }
        Posicion posicionInicial = personaje.getPosicion();

        validarCamino(posicionInicial, posicionFinal, areaEnDondeMoverse);

        areaEnDondeMoverse.colocarPersonaje(posicionFinal, personaje);
        areaEnDondeMoverse.limpiarCasillero(posicionInicial);
    }

    private void validarCamino(Posicion origen, Posicion destino, Pisable areaEnDondeMoverse) throws PosicionInvalida, CasilleroNoExistente, CaminoBloqueado {
        int deltaX;
        int deltaY;
        if ((destino.getX() - origen.getX()) > 0)
            deltaX = 1;
        else if ((destino.getX() - origen.getX()) < 0)
            deltaX = -1;
        else
            deltaX = 0;

        if ((destino.getY() - origen.getY()) > 0)
            deltaY = 1;
        else if ((destino.getY() - origen.getY()) < 0)
            deltaY = -1;
        else
            deltaY = 0;

        ///
        int x = origen.getX() + deltaX;
        int y = origen.getY() + deltaY;

        Posicion pos;
        do {
            pos = new Posicion(x, y);
            if (areaEnDondeMoverse.tienesObjetoMovible(pos)) {
                throw new CaminoBloqueado();
            }
            x += deltaX;
            y += deltaY;
        } while (!destino.equals(pos));
    }

//    private boolean validarCamino(Posicion origen, Posicion destino, int distancia, int deltaX, int deltaY) throws PosicionInvalida, CasilleroNoExistente {
//        int x = origen.getX() + deltaX;
//        int y = origen.getY() + deltaY;
//
//        for (int i = 0; i < distancia; i++) {
//            Posicion pos = new Posicion(x, y);
//
//            if (mPisable.tienesObjetoMovible(pos)) {
//                return false;
//            }
//
//            x += deltaX;
//            y += deltaY;
//        }
//        return true;
//    }

}
