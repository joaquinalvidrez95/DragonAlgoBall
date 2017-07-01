//package db.app.tests;

import db.app.exception.*;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.equipo.EnemigosDeLaTierra;
import db.app.model.entidad.personaje.equipo.GuerrerosZ;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joaquinalan on 07/06/2017.
 */
public class TableroTest {
    @Test(expected = DimensionesDelTableroInvalidas.class)
    public void constructor_DimensionesDelTableroInvalidas_DeberiaLanzarExcepcion() throws DimensionesDelTableroInvalidas, CantidadDePersonajesMayorAlNumeroDeFilas {
        Tablero tablero = new Tablero(0, 1, new GuerrerosZ(), new EnemigosDeLaTierra());
    }

    @Test(expected = CantidadDePersonajesMayorAlNumeroDeFilas.class)
    public void constructor_CantidadDePersonajesInvalido_DeberiaLanzarExcepcion() throws Exception {
        Tablero tablero = new Tablero(2, 7, new GuerrerosZ(), new EnemigosDeLaTierra());
    }

    @Test
    public void constructor_ParametrosValidos_NoDeberiaLanzarExcepcion() throws Exception {
        GuerrerosZ guerrerosZ = new GuerrerosZ();
        EnemigosDeLaTierra enemigosDeLaTierra = new EnemigosDeLaTierra();
        Tablero tablero = new Tablero(7, 7, guerrerosZ, enemigosDeLaTierra);

        Posicion posicionDeGoku = new Posicion(1, 5);
        Posicion posicionDeGohan = new Posicion(1, 4);
        Posicion posicionDePiccolo = new Posicion(1, 3);

        Posicion posicionDeMajinBoo = new Posicion(7, 5);
        Posicion posicionDeCell = new Posicion(7, 4);
        Posicion posicionDeFreezer = new Posicion(7, 3);

        assertEquals(posicionDeGoku, guerrerosZ.getPosicion(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOKU));
        assertEquals(posicionDeGohan, guerrerosZ.getPosicion(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GOHAN));
        assertEquals(posicionDePiccolo, guerrerosZ.getPosicion(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.PICCOLO));

        assertEquals(posicionDeFreezer, enemigosDeLaTierra.getPosicion(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.FREEZER));
        assertEquals(posicionDeCell, enemigosDeLaTierra.getPosicion(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.CELL));
        assertEquals(posicionDeMajinBoo, enemigosDeLaTierra.getPosicion(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.MAJIN_BOO));

    }

    @Test
    public void posicionarPersonaje_PosicionarEnCasillaVacia_DeberiaPoderse() throws DimensionesDelTableroInvalidas, PosicionInvalida, CeldaOcupada, CasilleroNoExistente {
        Tablero tablero = new Tablero(2, 2);
        Gohan gohan = new Gohan();
        Posicion posicion = new Posicion(2, 2);

        tablero.colocarPersonaje(posicion, gohan);

        assertEquals(posicion, gohan.getPosicion());
    }

    @Test
    public void testLimpiarCeldaVaciaLanzaExcepcion() throws PosicionInvalida, DimensionesDelTableroInvalidas, CasilleroNoExistente{
    	Tablero tablero = new Tablero(2, 2);
    	Posicion posicion = new Posicion(2, 2);
    	try{
    		tablero.limpiarCasillero(posicion);
    	} catch(CeldaVacia e){
    		return;
    	}
    	fail();
    }

    @Test
    public void testColocarPersonajeYPreguntarPorObjetoMovibleEsTrue() throws PosicionInvalida, DimensionesDelTableroInvalidas, CasilleroNoExistente, CeldaOcupada{
    	Tablero tablero = new Tablero(2, 2);
        Gohan gohan = new Gohan();
        Posicion posicion = new Posicion(2, 2);
        tablero.colocarPersonaje(posicion, gohan);
        assertTrue(tablero.tienesObjetoMovible(posicion));
    }

    @Test
    public void testColocarPersonajeEnCeldaOcupadaLanzaExcepcion() throws DimensionesDelTableroInvalidas, CasilleroNoExistente, CeldaOcupada, PosicionInvalida{
    	Tablero tablero = new Tablero(2, 2);
        Personaje personaje = new Gohan();
        Posicion posicion = new Posicion(2, 2);
        tablero.colocarPersonaje(posicion, personaje);
        personaje = new Piccolo();
        try{
        	tablero.colocarPersonaje(posicion, personaje);
        } catch(CeldaOcupada e){
        	return;
        }
        fail();
    }

    @Test
    public void testPreguntarPorObjetoMovibleEsFalseEnCasilleroVacio() throws PosicionInvalida, DimensionesDelTableroInvalidas, CasilleroNoExistente{
    	Tablero tablero = new Tablero(2, 2);
        Posicion posicion = new Posicion(2, 2);
        assertFalse(tablero.tienesObjetoMovible(posicion));
    }



}
