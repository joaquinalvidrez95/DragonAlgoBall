import db.app.exception.*;
import db.app.model.entidad.personaje.enemigodelatierra.cell.Cell;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaquinalan on 08/06/2017.
 **/

public class PersonajeTest {
    @Test(expected = IncapazDeTransformarse.class)
    public void transformar_KiInsuficiente_DeberiaLanzarExcepcion() throws IncapazDeTransformarse {
        Goku goku = new Goku();
        goku.transformar();
    }

    @Test
    public void transformar_CapazDeTransformarse_DeberiaDeTenerMasVelocidad() throws Exception {
        Posicion posicionInicial = new Posicion(2, 2);
        Posicion posicionFinal = new Posicion(5, 2);
        Posicion posicionFinal2 = new Posicion(5, 7);

        Goku goku = new Goku(posicionInicial);
        Tablero tablero = new Tablero(10, 10);

        tablero.colocarPersonaje(goku.getPosicion(), goku);
        for (int i = 0; i < 20; i++) {
            goku.actualizarPorTurnoTerminado();
        }

        goku.transformar();
        goku.mover(posicionFinal, tablero);
        assertEquals(posicionFinal, goku.getPosicion());

        goku.transformar();
        goku.mover(posicionFinal2, tablero);
        assertEquals(posicionFinal2, goku.getPosicion());
    }

    @Test
    public void mover_CaminoDisponible_DeberiaMoverse() throws Exception {
        Posicion posicionInicial = new Posicion(3, 3);
        Posicion posicionFinal = new Posicion(5, 5);


        Goku goku = new Goku(posicionInicial);
        Tablero tablero = new Tablero(7, 7);
        tablero.colocarPersonaje(goku.getPosicion(), goku);

        goku.mover(posicionFinal, tablero);
        assertEquals(posicionFinal, goku.getPosicion());

    }

    @Test(expected = FaltaDeVelocidad.class)
    public void mover_VelocidadInsuficiente_DeberiaLanzarExcepcion() throws Exception {
        Posicion posicionInicialDeGoku = new Posicion(3, 3);
        Posicion posicionFinalDeGoku = new Posicion(6, 6);

        Goku goku = new Goku(posicionInicialDeGoku);

        Tablero tablero = new Tablero(7, 7);

        goku.mover(posicionFinalDeGoku, tablero);

    }

    @Test(expected = CaminoBloqueado.class)
    public void mover_CaminoBloqueado_DeberiaLanzarExcepcion() throws Exception {
        Posicion posicionInicialDeGoku = new Posicion(3, 3);
        Posicion posicionDeGohan = new Posicion(4, 4);
        Posicion posicionFinalDeGoku = new Posicion(5, 5);

        Personaje goku = new Goku(posicionInicialDeGoku);
        Personaje gohan = new Gohan(posicionDeGohan);

        Tablero tablero = new Tablero(7, 7);

        tablero.colocarPersonaje(gohan.getPosicion(), gohan);

        goku.mover(posicionFinalDeGoku, tablero);
    }

    @Test(expected = AtaqueAlMismoEquipo.class)
    public void atacar_AtaqueAlMismoEquipo_DeberiaLanzarExcepcion() throws Exception {
        Personaje gohan = new Gohan(new Posicion(3, 6));
        Personaje piccolo = new Piccolo(new Posicion(4, 6));

        gohan.atacar(piccolo);
    }

    @Test(expected = DistanciaDeAtaqueInsuficiente.class)
    public void atacar_DistanciaInsuficiente_DeberiaLanzarExcepcion() throws DistanciaDeAtaqueInsuficiente, PosicionInvalida, AtaqueAlMismoEquipo, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        Personaje gohan = new Gohan(new Posicion(1, 1));
        Personaje cell = new Cell(new Posicion(5, 5));

        gohan.atacar(cell);
    }

    @Test
    public void atacar_DistanciaSuficiente_DeberiaAtacar_PoderDePeleaMenor() throws DistanciaDeAtaqueInsuficiente, PosicionInvalida, AtaqueAlMismoEquipo, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        Personaje gohan = new Gohan(new Posicion(1, 1));
        Personaje cell = new Cell(new Posicion(3, 3));
        double vidaCell = cell.getVida();

        gohan.atacar(cell);
        assertEquals((int) (gohan.getPoderDePelea()*0.8), (int) (vidaCell - cell.getVida()));

    }

}

