
import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.enemigodelatierra.cell.Cell;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class CellTest {

    @Test
    public void transformar_AbsorcionesSuficientesParaSemiPerfecto_DeberiaTransformase() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1, 1));
        Cell cell = new Cell(new Posicion(3, 3));
        for (int i = 0; i < 4 ; i++) {
            cell.actualizarPorTurnoTerminado();
            cell.usarAtaqueEspecial(gohan);
        }
        cell.transformar();

        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.PODER_DE_PELEA, (int) cell.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.DISTANCIA_DE_ATAQUE, cell.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.VELOCIDAD, cell.getVelocidad());
    }


    @Test(expected = IncapazDeTransformarse.class)
    public void transformar() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1, 5));
        Cell cell = new Cell(new Posicion(1, 7));
        for (int i = 0 ; i < 2 ; i++) {
            cell.actualizarPorTurnoTerminado();
            cell.usarAtaqueEspecial(gohan);
        }
        cell.transformar();
    }
    @Test
    public void usaAtaqueEspecial_DeberiaSumarVidaIgualAlDanoHecho() throws Exception {
        Goku goku = new Goku(new Posicion(2, 4));
        Cell cell = new Cell(new Posicion(3, 4));
        cell.actualizarPorTurnoTerminado();
        double vidaAnterior=cell.getVida();
        cell.usarAtaqueEspecial(goku);

        assertEquals((int) (cell.getPoderDePelea() + vidaAnterior),
                (int) cell.getVida());
        assertEquals( (int) goku.getVida(),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA
                        -  DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA) );

        for (int i = 0 ; i < 3; i++){
            cell.actualizarPorTurnoTerminado();
            cell.usarAtaqueEspecial(goku);
        }
        cell.transformar();

        assertEquals( (int) cell.getVida() ,
                 (int)((DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA * 4)
                        + DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA)	);
        assertEquals( (int) goku.getVida(),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA -
                        (DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA * 4)) );


        for (int i = 0 ; i < 8; i++){
            cell.actualizarPorTurnoTerminado();
            cell.usarAtaqueEspecial(goku);
        }
        cell.transformar();

        assertEquals( (int) cell.getVida() ,
                 (int) ((DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA * 4)
                        +  (DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.PODER_DE_PELEA * 8)
                         +  DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA) );
        assertEquals( (int) goku.getVida(),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA -
                        (DragonBallZParametros.ParametrosDePersonajes.Cell.CellNormal.PODER_DE_PELEA * 4)
                        - (DragonBallZParametros.ParametrosDePersonajes.Cell.CellSemiPerfecto.PODER_DE_PELEA * 8)) );

    }

}