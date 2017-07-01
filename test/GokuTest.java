
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.enemigodelatierra.cell.Cell;
import db.app.model.entidad.personaje.enemigodelatierra.freezer.Freezer;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by joaquinalan on 14/06/2017.
 */
public class GokuTest {
    @Test
    public void transformar_KiSuficienteParaKaioKen_DeberiaTransformarse() throws Exception {
        Goku goku = new Goku(new Posicion(1,1));
        for(int i=0 ; i<5 ; i++) goku.actualizarPorTurnoTerminado();
        goku.transformar();

        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.PODER_DE_PELEA,
                (int) goku.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.DISTANCIA_DE_ATAQUE,
                goku.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Goku.GokuKaioKen.VELOCIDAD, goku.getVelocidad());
    }

    @Test
    public void transformar_KiSuficienteParaSuperSayajin_DeberiaTransformarse() throws Exception {
        Goku goku = new Goku(new Posicion(1,1));

        for (int i = 0; i < 14; i++) {
            goku.actualizarPorTurnoTerminado();
        }

        goku.transformar();
        goku.transformar();

        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.PODER_DE_PELEA,
                (int) goku.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.DISTANCIA_DE_ATAQUE,
                goku.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Goku.GokuSuperSayajin.VELOCIDAD,
                goku.getVelocidad());
    }
    @Test
    public void usarAtaqueEspecial_AtaqueEspecial_DeberiaHacer50PorcientoMasDeDano() throws Exception {
        Cell cell = new Cell(new Posicion(1,1));
        Goku goku = new Goku(new Posicion(1,3));

        for(int i=0 ; i<4 ; i++) goku.actualizarPorTurnoTerminado();
        goku.usarAtaqueEspecial(cell);
        assertEquals(((int) (DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.PODER_DE_PELEA *(1.5))),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA - cell.getVida()) );
    }
    @Test
    public void getPoderDePeleaAtaqueNormalYEspecial_PersonajeMenos30PorcientoDeVida_DeberiaIncrementar20PorcientoSuDano()throws Exception{
        Cell cell = new Cell(new Posicion(1,1));
        Freezer freezer= new Freezer(new Posicion(1,4));
        Goku goku = new Goku(new Posicion(1,3));
        goku.perderVida((DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA * 0.8)-1);
        goku.atacar(cell);
        assertEquals(((int) (DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.PODER_DE_PELEA *(1.2))),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Cell.VIDA - cell.getVida()) );
        for(int i=0 ; i<4 ; i++) goku.actualizarPorTurnoTerminado();
        goku.usarAtaqueEspecial(freezer);
        assertEquals(((int) ((DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.PODER_DE_PELEA *(1.5))*1.2)),
                (int)(DragonBallZParametros.ParametrosDePersonajes.Freezer.VIDA - freezer.getVida()) );

    }
}

