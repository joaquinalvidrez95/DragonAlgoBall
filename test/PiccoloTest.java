import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.enemigodelatierra.cell.Cell;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class PiccoloTest {
    @Test
    public void transformar_GohanDebajoDel20PorcientoVida_DeberiaTransformase() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1,1));
        Piccolo piccolo = new Piccolo(new Posicion(1,2));

        for(int i=0 ; i<5 ; i++){
            piccolo.actualizarPorTurnoTerminado();
            gohan.perderVida(50);
        }
        piccolo.transformar();
        piccolo.setProvocanteDeTransformacionPorAmigoHerido(gohan);
        piccolo.transformar();
        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.PODER_DE_PELEA,
                (int) piccolo.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.DISTANCIA_DE_ATAQUE,
                piccolo.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloProtector.VELOCIDAD,
                piccolo.getVelocidad());
    }

    @Test
    public void usarAtaqueEspecial_DeberiaHacer25PorcientoMasDeDano()throws Exception {
        Cell cell = new Cell(new Posicion(1,1));
        Piccolo piccolo = new Piccolo(new Posicion(1,3));

        piccolo.actualizarPorTurnoTerminado();
        piccolo.actualizarPorTurnoTerminado();
        piccolo.usarAtaqueEspecial(cell);
        assertEquals((int) (DragonBallZParametros.ParametrosDePersonajes.Piccolo.PiccoloNormal.PODER_DE_PELEA *1.25),
                (int) (DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA - cell.getVida()) );
    }



    @Test(expected = IncapazDeTransformarse.class)
    public void transformar() throws Exception {
        Piccolo piccolo = new Piccolo();
        Gohan gohan = new Gohan();
        for (int i = 0; i < 5; i++) {
            piccolo.actualizarPorTurnoTerminado();
        }
        piccolo.setProvocanteDeTransformacionPorAmigoHerido(gohan);
        piccolo.transformar();
        piccolo.transformar();
    }

}