package db.app.model.tablero;

import db.app.exception.*;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.tablero.casillero.Casillero;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by joaquinalan on 06/06/2017.
 */
public class Tablero implements Pisable {
    private final DimensionDeTablero mDimensionDeTablero;
    private final ColeccionDeCasilleros mColeccionDeCasilleros;

    public Tablero(int cantidadDeFilas, int cantidadDeColumnas,
                   Iterable<Personaje> iterableGuerrerosZ,
                   Iterable<Personaje> iterableEnemigosDeLaTierra) throws DimensionesDelTableroInvalidas, CantidadDePersonajesMayorAlNumeroDeFilas {

        mDimensionDeTablero = new DimensionDeTablero(cantidadDeFilas, cantidadDeColumnas);
        mColeccionDeCasilleros = new ColeccionDeCasilleros();
        inicializarTablero();

        try {
            posicionarEquipo(iterableGuerrerosZ, 1);
            posicionarEquipo(iterableEnemigosDeLaTierra, mDimensionDeTablero.getCantidadDeColumnas());
        } catch (NumeroDeColumnaParaEquipoInvalido numeroDeColumnaParaEquipoInvalido) {
            numeroDeColumnaParaEquipoInvalido.printStackTrace();
        }
    }

    public Tablero(int cantidadDeFilas, int cantidadDeColumnas) throws DimensionesDelTableroInvalidas {
        mDimensionDeTablero = new DimensionDeTablero(cantidadDeFilas, cantidadDeColumnas);
        mColeccionDeCasilleros = new ColeccionDeCasilleros();
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int numberOfColumn = 1; numberOfColumn <= mDimensionDeTablero.getCantidadDeColumnas(); numberOfColumn++) {
            for (int numberOfRow = 1; numberOfRow <= mDimensionDeTablero.getCantidadDeFilas(); numberOfRow++) {
                Posicion posicion = null;
                try {
                    posicion = new Posicion(numberOfRow, numberOfColumn);
                } catch (PosicionInvalida posicionInvalida) {
                    posicionInvalida.printStackTrace();
                }
                Casillero casillero = new Casillero(posicion);
                mColeccionDeCasilleros.agregarCasillero(casillero);
            }
        }
    }

    private void posicionarEquipo(Iterable<Personaje> iterableEquipo, int numeroDeColumna) throws CantidadDePersonajesMayorAlNumeroDeFilas, NumeroDeColumnaParaEquipoInvalido {
        if (numeroDeColumna <= 0) {
            throw new NumeroDeColumnaParaEquipoInvalido();
        }

        Iterator<Personaje> iteratorDePersonajes = iterableEquipo.iterator();
        int cantidadDePersonajes = 0;

        while (iteratorDePersonajes.hasNext()) {
            iteratorDePersonajes.next();
            cantidadDePersonajes++;
        }

        int offsetDeLaUltimaFilaAlPersonaje = (mDimensionDeTablero.getCantidadDeFilas() - cantidadDePersonajes) / 2;
        if (offsetDeLaUltimaFilaAlPersonaje <= 0) {
            throw new CantidadDePersonajesMayorAlNumeroDeFilas();
        }
        int filaParaColocarPersonajes = mDimensionDeTablero.getCantidadDeFilas() - offsetDeLaUltimaFilaAlPersonaje;

        iteratorDePersonajes = iterableEquipo.iterator();
        while (iteratorDePersonajes.hasNext()) {
            Posicion posicion;
            try {
                posicion = new Posicion(numeroDeColumna, filaParaColocarPersonajes);
            } catch (PosicionInvalida posicionInvalida) {
                throw new CantidadDePersonajesMayorAlNumeroDeFilas();
            }
            Personaje personaje = iteratorDePersonajes.next();
            try {
                colocarPersonaje(posicion, personaje);
            } catch (CasilleroNoExistente casilleroNoExistente) {
                casilleroNoExistente.printStackTrace();
            } catch (CeldaOcupada celdaOcupada) {
                celdaOcupada.printStackTrace();
            }
            filaParaColocarPersonajes--;
        }
    }

    public Casillero getCasillero(Posicion posicion) throws CasilleroNoExistente {
        return mColeccionDeCasilleros.getCasillero(posicion);
    }

//	public void atacarConPersonaje(int xOrigen, int yOrigen, int xDestino, int yDestino) {
//        if ((getCasillero(xDestino, yDestino).estaVacia()) || (getCasillero(xOrigen, yOrigen).estaVacia()))
//            return;
//
//        Personaje atacante = (Personaje)getCasillero(xOrigen, yOrigen).obtenerContenido();
//        Personaje enemigo = (Personaje)getCasillero(xDestino, yDestino).obtenerContenido();
//
//        if (esValidaLaDistancia(atacante, atacante.getDistanciaDeAtaque(), xDestino, yDestino)){
//            atacante.atacar(enemigo);
//            System.out.println("Se puede atacar");
//        }
//
//        if (enemigo.getVida() <= 0)
//            getCasillero(enemigo.getX(), enemigo.getY()).vaciarCelda();
//
//	}

//    public void posicionarPersonaje(Posicion posicion, Personaje personaje) throws CasilleroNoExistente, CeldaOcupada {
//        Casillero casillero = mColeccionDeCasilleros.getCasillero(posicion);
//        casillero.colocarPersonaje(personaje);
//    }

//    public boolean existeContenidoDeCasillero(Posicionable posicionable) {
//        Iterator<Casillero> iteratorDeCasilleros = mColeccionDeCasilleros.getIterator();
//        boolean existeContenidoDeCasillero = false;
//
//        while (iteratorDeCasilleros.hasNext()) {
//            Casillero casillero = iteratorDeCasilleros.next();
//            existeContenidoDeCasillero |= casillero.existeContenido(posicionable);
//        }
//        return existeContenidoDeCasillero;
//    }


    public boolean tienesObjetoMovible(Posicion posicion) throws CasilleroNoExistente {
        return mColeccionDeCasilleros.getCasillero(posicion).tienesPersonaje();
    }

    @Override
    public void colocarPersonaje(Posicion posicion, Personaje personaje) throws CasilleroNoExistente, CeldaOcupada {
        Casillero casillero = mColeccionDeCasilleros.getCasillero(posicion);
        casillero.colocarPersonaje(personaje);
    }

    @Override
    public void colocarConsumible(Posicion posicion, Consumible consumible) throws CasilleroNoExistente, CeldaOcupada {
        Casillero casillero = mColeccionDeCasilleros.getCasillero(posicion);
        casillero.colocarConsumible(consumible);
    }

    @Override
    public boolean tienesConsumible(Posicion posicion) throws CasilleroNoExistente {
        return mColeccionDeCasilleros.getCasillero(posicion).tienesConsumible();
    }

    @Override
    public void limpiarCasillero(Posicion posicion) throws CasilleroNoExistente, CeldaVacia {
        mColeccionDeCasilleros.getCasillero(posicion).limpiarCasillero();
    }


    public Personaje getPersonaje(Posicion posicion) throws CasilleroSinPersonaje, CasilleroNoExistente {
        return mColeccionDeCasilleros.getCasillero(posicion).getPersonaje();
    }

    public int getAltura() {
        return mDimensionDeTablero.getCantidadDeFilas();
    }

    public int getLargo() {
        return mDimensionDeTablero.getCantidadDeColumnas();
    }


    public Iterator<Consumible> getConsumibles() {
        ArrayList<Consumible> consumibles = new ArrayList<>();
        Iterator<Casillero> itCasillero = mColeccionDeCasilleros.getIterator();
        while (itCasillero.hasNext()) {
            try {
                consumibles.add(itCasillero.next().getConsumible());
            } catch (NoHayConsumible noHayConsumible) {
                //noHayConsumible.printStackTrace();
            }
        }
        return consumibles.iterator();
    }

    public Iterator<Personaje> getIteratorDePersonajes() {
        ArrayList<Personaje> personajes = new ArrayList<>();
        Iterator<Casillero> itCasillero = mColeccionDeCasilleros.getIterator();
        while (itCasillero.hasNext()) {
            try {
                Personaje personaje = itCasillero.next().getPersonaje();
                if (personaje.estasVivo()) {
                    personajes.add(personaje);
                }
            } catch (CasilleroSinPersonaje casilleroSinPersonaje) {
            }
        }
        return personajes.iterator();
    }
}
