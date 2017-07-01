package db.app.model.estado;


import db.app.exception.*;
import db.app.model.ModelInterface;
import db.app.model.ObservadorDeModelo;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.equipo.EnemigosDeLaTierra;
import db.app.model.entidad.personaje.equipo.Equipo;
import db.app.model.entidad.personaje.equipo.GuerrerosZ;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.jugador.Jugador;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import db.app.model.tablero.posicionadordeconsumibles.PosicionadorDeConsumibles;

import java.util.*;


/**
 * Created by joaquinalan on 11/06/2017.
 */
public class DragonAlgoBallModel implements ModelInterface {
    private EstadoDelJuego mEstadoDelJuego;
    private EstadoDelJuego mTurnoDeEnemigosDeLaTierra;
    private EstadoDelJuego mTurnoDeGuerrerosZ;
    private Jugador mJugadorGuerrerosZ;
    private Jugador mJugadorEnemigosDeLaTierra;
    private Tablero mTablero;
    private String ganador;
    private HashMap<String, Equipo> equipos = new HashMap<String, Equipo>();
    private PosicionadorDeConsumibles posicionadorDeConsumibles;

    private int mCantidadDeFilas;
    private int mCantidadDeColumnas;
    private List<ObservadorDeModelo> mObservadores = new ArrayList<>();

    public DragonAlgoBallModel() {
        GuerrerosZ guerrerosZ = new GuerrerosZ();
        EnemigosDeLaTierra enemigosDeLaTierra = new EnemigosDeLaTierra();
        equipos.put(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA, enemigosDeLaTierra);
        equipos.put(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z, guerrerosZ);
    }

    public DragonAlgoBallModel(String nombreJugador1, String nombreJugador2,
                               String nombreEquipo1, String nombreEquipo2,
                               int cantidadDeColumnas, int cantidadDeFilas) {
        final String nombreGuerrerosZ = DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z;
        final String nombreEnemigosDeLaTierra = DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA;
        GuerrerosZ guerrerosZ = new GuerrerosZ();
        EnemigosDeLaTierra enemigosDeLaTierra = new EnemigosDeLaTierra();
        equipos.put(nombreEnemigosDeLaTierra, enemigosDeLaTierra);
        equipos.put(nombreGuerrerosZ, guerrerosZ);
        mTurnoDeGuerrerosZ = new TurnoDeGuerrerosZ(this);
        mTurnoDeEnemigosDeLaTierra = new TurnoDeEnemigosDeLaTierra(this);
        mCantidadDeColumnas = cantidadDeColumnas;
        mCantidadDeFilas = cantidadDeFilas;
        switch (equipos.get(nombreEquipo1).getNombre()) {
            case nombreGuerrerosZ:
                mJugadorGuerrerosZ = new Jugador(this, equipos.get(nombreEquipo1), nombreJugador1);
                mJugadorEnemigosDeLaTierra = new Jugador(this, equipos.get(nombreEquipo2), nombreJugador2);
                break;
            case nombreEnemigosDeLaTierra:
                mJugadorGuerrerosZ = new Jugador(this, equipos.get(nombreEquipo1), nombreJugador2);
                mJugadorEnemigosDeLaTierra = new Jugador(this, equipos.get(nombreEquipo2), nombreJugador1);
            default:
                break;
        }

        try {
            mTablero = new Tablero(mCantidadDeFilas,
                    mCantidadDeColumnas,
                    equipos.get(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z),
                    equipos.get(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA));
        } catch (DimensionesDelTableroInvalidas dimensionesDelTableroInvalidas) {
            System.out.println(dimensionesDelTableroInvalidas.getMessage());
        } catch (CantidadDePersonajesMayorAlNumeroDeFilas cantidadDePersonajesMayorAlNumeroDeFilas) {
            System.out.println(cantidadDePersonajesMayorAlNumeroDeFilas.getMessage());
        }
        posicionadorDeConsumibles = new PosicionadorDeConsumibles(mTablero);
        asignarTurnoAleatoriamente();
    }

    public void atacarPersonaje(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, CeldaVacia, NoEsTurnoDeJugador, JugadorYaHabiaAtacado, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, DistanciaDeAtaqueInsuficiente, CasilleroNoExistente {
        String nombreDelGanador = mEstadoDelJuego.getNombreEquipo();
        mEstadoDelJuego.atacarPersonaje(atacante, atacado);
        if (mTurnoDeEnemigosDeLaTierra.yaGanaste() | mTurnoDeGuerrerosZ.yaGanaste()) {

            notificarObservadoresQuienGano(nombreDelGanador);
        }
    }

    public void moverPersonaje(Personaje personaje, Posicion destino) throws CeldaOcupada, CasilleroNoExistente, JugadorYaHabiaMovido, NoEsTurnoDeJugador, CaminoBloqueado, FaltaDeVelocidad, PosicionInvalida, ElPersonajeEstaMuerto, PersonajeEstaInhabilitado, CeldaVacia {
        mEstadoDelJuego.moverPersonaje(personaje, mTablero.getCasillero(destino));

    }

    public void pasarTurno() throws NoEsTurnoDeJugador, CeldaOcupada, CasilleroNoExistente, ElPersonajeEstaMuerto {
        mJugadorGuerrerosZ.actualizarPersonajesPorTurnoTerminado();
        mJugadorEnemigosDeLaTierra.actualizarPersonajesPorTurnoTerminado();
        mEstadoDelJuego.pasarTurno();
        posicionadorDeConsumibles.colocarConsumible();
        //getEquipos().get(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA).actualizarPorTurnoTerminado();
        //getEquipos().get(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z).actualizarPorTurnoTerminado();
    }

    public Tablero getTablero() {
        return mTablero;
    }

    void setEstadoDelJuego(EstadoDelJuego estadoDelJuego) {
        mEstadoDelJuego = estadoDelJuego;
    }

    public Jugador getJugadorGuerrerosZ() {
        return mJugadorGuerrerosZ;
    }

    public Jugador getJugadorEnemigosDeLaTierra() {
        return mJugadorEnemigosDeLaTierra;
    }

    public HashMap<String, Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(HashMap<String, Equipo> equipos) {
        this.equipos = equipos;
    }

    private void asignarTurnoAleatoriamente() {
        final int TURNO_GUERREROS_Z = 1;
        final int TURNO_ENEMIGOS_DE_LA_TIERRA = 2;
        int turno;

        turno = (new Random()).nextInt(2) + 1;
        switch (turno) {
            case TURNO_GUERREROS_Z:
                mEstadoDelJuego = mTurnoDeGuerrerosZ;
                try {
                    mJugadorGuerrerosZ.empezarTurno();
                } catch (JugadorYaTieneElTurno jugadorYaTieneElTurno) {
                    jugadorYaTieneElTurno.printStackTrace();
                }
                break;
            case TURNO_ENEMIGOS_DE_LA_TIERRA:
                mEstadoDelJuego = mTurnoDeEnemigosDeLaTierra;
                try {
                    mJugadorEnemigosDeLaTierra.empezarTurno();
                } catch (JugadorYaTieneElTurno jugadorYaTieneElTurno) {
                    jugadorYaTieneElTurno.printStackTrace();
                }
                break;
        }
    }

    public EstadoDelJuego getTurnoDeEnemigosDeLaTierra() {
        return mTurnoDeEnemigosDeLaTierra;
    }

    public EstadoDelJuego getTurnoDeGuerrerosZ() {
        return mTurnoDeGuerrerosZ;
    }

    public EstadoDelJuego getEstadoDelJuego() {
        return mEstadoDelJuego;
    }

    public void terminarTurnoDeFormaNormal() throws NoEsTurnoDeJugador {
        mJugadorGuerrerosZ.actualizarPersonajesPorTurnoTerminado();
        mJugadorEnemigosDeLaTierra.actualizarPersonajesPorTurnoTerminado();
        mEstadoDelJuego.terminarTurnoDeFormaNormal();
    }

    public Iterator<Consumible> getConsumibles() {
        return mTablero.getConsumibles();
    }

    public Iterator<Personaje> getIteratorDePersonajes() {
        return mTablero.getIteratorDePersonajes();
    }

    public void usarAtaqueEspecial(Personaje atacante, Personaje atacado) throws AtaqueAlMismoEquipo, ElPersonajeEstaMuerto, DistanciaDeAtaqueInsuficiente, JugadorYaHabiaAtacado, CasilleroNoExistente, KiInsuficiente, PersonajeEstaInhabilitado, CeldaVacia, NoEsTurnoDeJugador {
        String nombreDelGanador = mEstadoDelJuego.getNombreEquipo();
        mEstadoDelJuego.usarAtaqueEspecial(atacante, atacado);
        if (mTurnoDeEnemigosDeLaTierra.yaGanaste() | mTurnoDeGuerrerosZ.yaGanaste()) {

            notificarObservadoresQuienGano(nombreDelGanador);
        }
    }

    @Override
    public void registrarObservador(ObservadorDeModelo observadorDeModelo) {
        mObservadores.add(observadorDeModelo);
    }

    @Override
    public void desregistrarObservador(ObservadorDeModelo observadorDeModelo) {
        mObservadores.remove(observadorDeModelo);
    }

    @Override
    public void notificarObservadoresQuienGano(String nombreDelGanador) {
        for (ObservadorDeModelo observadorDeModelo : mObservadores) {
            observadorDeModelo.seTerminoElJuego(nombreDelGanador);
        }
    }


}
