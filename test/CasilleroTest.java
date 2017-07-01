import db.app.exception.CasilleroSinPersonaje;
import db.app.exception.CeldaOcupada;
import db.app.exception.CeldaVacia;
import db.app.exception.PosicionInvalida;
import db.app.model.entidad.personaje.enemigodelatierra.freezer.Freezer;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.casillero.Casillero;
import org.junit.Test;

import static org.junit.Assert.*;

//import db.app.model.entidad.Consumible;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class CasilleroTest {

	@Test
	public void testCrearCasilleroEmpiezaVacio() throws PosicionInvalida{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		assertFalse(casillero.tienesPersonaje());
	}

	@Test
	public void testDevolverPosicionDevuelveLaPosicionActual() throws PosicionInvalida{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		assertEquals(casillero.getPosition(), pos);
	}

	@Test
	public void testCrearCasilleroYColocarPersonaje() throws PosicionInvalida, CeldaOcupada{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		casillero.colocarPersonaje(new Piccolo());
		assertTrue(casillero.tienesPersonaje());
	}

	@Test
	public void testColocarPersonajeEnCasilleroOcupadoLanzaExcepcion() throws PosicionInvalida, CeldaOcupada{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		casillero.colocarPersonaje(new Piccolo());
		try {
			casillero.colocarPersonaje(new Freezer());
		} catch(CeldaOcupada e){
			return;
		}
		fail();
	}

	@Test
	public void testColocarPersonajeEnCasilleroYLimpiarlo() throws PosicionInvalida, CeldaOcupada, CeldaVacia{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		casillero.colocarPersonaje(new Piccolo());
		casillero.limpiarCasillero();
		assertFalse(casillero.tienesPersonaje());
	}

	@Test
	public void testLimpiarCeldaVaciaLanzaExcepcion() throws CeldaOcupada, PosicionInvalida{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		try{
			casillero.limpiarCasillero();
		}
		catch(CeldaVacia e){
			return;
		}
		fail();
	}

	@Test
	public void testCrearCasilleroYColocarConsumibleYPreguntarPorPersonajeEsFalse() throws PosicionInvalida, CeldaOcupada{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		//casillero.colocarConsumible(new Consumible());
		assertFalse(casillero.tienesPersonaje());
	}

	@Test
	public void testColocarContenidoYRecuperarlo() throws PosicionInvalida, CeldaOcupada{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		//Consumible consumible = new Consumible();
		//casillero.colocarConsumible(consumible);
		//assertEquals(casillero.getContenido(), consumible);
	}

	@Test
	public void testColocarPersonajeYRecuperarlo() throws PosicionInvalida, CeldaOcupada, CasilleroSinPersonaje{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		Personaje personaje = new Piccolo();
		casillero.colocarPersonaje(personaje);
		assertEquals(casillero.getPersonaje(), personaje);
	}

	@Test
	public void testRecuperarPersonajeDeCasilleroVacioLanzaExcepcion() throws PosicionInvalida{
		Posicion pos = new Posicion(1,1);
		Casillero casillero = new Casillero(pos);
		try{
			casillero.getPersonaje();
		} catch(CasilleroSinPersonaje e){
			return;
		}
		fail();
	}

}