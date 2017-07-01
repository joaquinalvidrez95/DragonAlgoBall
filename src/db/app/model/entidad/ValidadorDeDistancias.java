package db.app.model.entidad;

import db.app.exception.CasilleroNoExistente;
import db.app.exception.PosicionInvalida;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

public class ValidadorDeDistancias {

    private Pisable mPisable;

    public ValidadorDeDistancias(Pisable pisable) {
        this.mPisable = pisable;
    }

    public ValidadorDeDistancias() {
    } // SOLO ESTA HECHO PARA USAR EN TESTS, BORRAR

    public boolean esValidaLaDistancia(Posicion posicionInicial, Posicion posicionFinal, int distancia) {
        int diferenciaEnX = Math.abs(posicionInicial.getX() - posicionFinal.getX());
        int diferenciaEnY = Math.abs(posicionInicial.getY() - posicionFinal.getY());

        if ((diferenciaEnX <= distancia) && (diferenciaEnY <= distancia)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esValidoElCamino(Posicion origen, Posicion destino, int distancia) throws PosicionInvalida, CasilleroNoExistente {
        if (!esValidaLaDistancia(origen, destino, distancia))
            return false;

        int distanciaDelRecorrido;
        int sentidoX;
        int sentidoY;
        if ((destino.getX() - origen.getX()) > 0)
            sentidoX = 1;
        else if ((destino.getX() - origen.getX()) < 0)
            sentidoX = -1;
        else
            sentidoX = 0;

        if ((destino.getY() - origen.getY()) > 0)
            sentidoY = 1;
        else if ((destino.getY() - origen.getY()) < 0)
            sentidoY = -1;
        else
            sentidoY = 0;

        if (Math.abs((destino.getX() - origen.getX())) > Math.abs((destino.getY() - origen.getY())))
            distanciaDelRecorrido = Math.abs((destino.getX() - origen.getX()));
        else
            distanciaDelRecorrido = Math.abs((destino.getY() - origen.getY()));

        return validarCamino(origen, destino, distanciaDelRecorrido, sentidoX, sentidoY);
    }

    private boolean validarCamino(Posicion origen, Posicion destino, int distancia, int sentidoX, int sentidoY) throws PosicionInvalida, CasilleroNoExistente {
        int x = origen.getX() + sentidoX;
        int y = origen.getY() + sentidoY;

        for (int i = 0; i < distancia; i++) {
            Posicion pos = new Posicion(x, y);
            if (mPisable.tienesObjetoMovible(pos)) {
                return false;
            }

            x += sentidoX;
            y += sentidoY;
        }
        return true;
    }
}
