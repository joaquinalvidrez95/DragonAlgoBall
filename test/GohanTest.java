
import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.guerreroz.gohan.Gohan;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.entidad.personaje.guerreroz.piccolo.Piccolo;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class GohanTest {
    @Test
    public void transformar_KiSuficienteParaSuperSayajinFase1_DeberiaTransformase() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1,1));
        gohan.actualizarPorTurnoTerminado();
        gohan.actualizarPorTurnoTerminado();
        gohan.transformar();

        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.PODER_DE_PELEA, (int) gohan.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.DISTANCIA_DE_ATAQUE, gohan.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase1.VELOCIDAD, gohan.getVelocidad());
    }

    @Test
    public void transformar_KiSuficienteParaSuperSayajinFase2_DeberiaTransformase() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1,1));
        Piccolo piccolo = new Piccolo(new Posicion(1,2));
        Goku goku = new Goku(new Posicion(1,3));

        for (int i = 0; i < 8; i++) {
            gohan.actualizarPorTurnoTerminado();
            goku.perderVida(50);
            piccolo.perderVida(50);
        }
        gohan.setProvocantesDeTransformacionPorEquipoHerido(goku, piccolo);
        gohan.transformar();
        gohan.transformar();

        assertEquals((int) DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.PODER_DE_PELEA, (int) gohan.getPoderDePelea());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.DISTANCIA_DE_ATAQUE, gohan.getDistanciaDeAtaque());
        assertEquals(DragonBallZParametros.ParametrosDePersonajes.Gohan.GohanSuperSayajinFase2.VELOCIDAD, gohan.getVelocidad());
    }






    @Test (expected = IncapazDeTransformarse.class)
    public void transformar_EquipoSano_NoDeberiaTransformase() throws Exception {
        Gohan gohan = new Gohan(new Posicion(1, 1));
        Piccolo piccolo = new Piccolo(new Posicion(1, 2));
        Goku goku = new Goku(new Posicion(1, 3));

        for (int i = 0; i < 8; i++) {
            gohan.actualizarPorTurnoTerminado();
        }
        gohan.transformar();
        gohan.transformar();
    }
}

