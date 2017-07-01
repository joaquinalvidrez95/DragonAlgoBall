

import db.app.exception.PosicionInvalida;
import db.app.model.entidad.ValidadorDeDistancias;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidadorDeDistanciasTest {

	@Test
	public void testCasilleroADistanciaDosDeOtroEsTrueEnEjeX() throws PosicionInvalida{
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(8, 7), 2));
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(4, 7), 2));
	}

	@Test
	public void testCasilleroADistanciaDosDeOtroEsTrueEnEjeY() throws PosicionInvalida{
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(6, 9), 2));
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(6, 5), 2));
	}

	@Test
	public void testCasilleroADistanciaDosDeOtroEsTrueEnDiagonal() throws PosicionInvalida{
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(8, 9), 2));
		assertTrue(validador.esValidaLaDistancia(new Posicion(6, 7), new Posicion(4, 5), 2));
	}

	@Test
	public void testCasilleroADistanciaMenorDeLaMaximaEsTrueEnEjeX() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 3;
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(4, 7), distanciaMaxima));
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(1, 7), distanciaMaxima));
	}

	@Test
	public void testCasilleroADistanciaMenorDeLaMaximaEsTrueEnEjeY() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 3;
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(3, 8), distanciaMaxima));
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(3, 6), distanciaMaxima));
	}

	@Test
	public void testCasilleroADistanciaMenorDeLaMaximaEsTrueEnDiagonal() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 3;
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(4, 6), distanciaMaxima));
		assertTrue(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(2, 5), distanciaMaxima));
	}


	@Test
	public void testCasilleroADistanciaMayorAMaximaEsFalseEnEjeX() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 2;
		assertFalse(validador.esValidaLaDistancia(new Posicion(4, 7), new Posicion(8, 7), distanciaMaxima));
		assertFalse(validador.esValidaLaDistancia(new Posicion(4, 7), new Posicion(1, 7), distanciaMaxima));
	}

	@Test
	public void testCasilleroADistanciaMayorAMaximaEsFalseEnEjeY() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 3;
		assertFalse(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(3, 11), distanciaMaxima));
		assertFalse(validador.esValidaLaDistancia(new Posicion(3, 7), new Posicion(3, 3), distanciaMaxima));
	}

	@Test
	public void testCasilleroADistanciaMayorAMaximaEsFalseEnDiagonal() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 1;
		assertFalse(validador.esValidaLaDistancia(new Posicion(4, 7), new Posicion(7, 11), distanciaMaxima));
		assertFalse(validador.esValidaLaDistancia(new Posicion(4, 7), new Posicion(1, 3), distanciaMaxima));
	}

	@Test
	public void testCasilleroAMismaPosicionEsTrue() throws PosicionInvalida {
		ValidadorDeDistancias validador = new ValidadorDeDistancias();
		int distanciaMaxima = 1;
		assertTrue(validador.esValidaLaDistancia(new Posicion(4, 7), new Posicion(4, 7), distanciaMaxima));
	}
}
