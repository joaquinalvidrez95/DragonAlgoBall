import db.app.exception.PersonajeEstaInhabilitado;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.enemigodelatierra.majinboo.MajinBoo;
import db.app.model.entidad.personaje.equipo.EnemigosDeLaTierra;
import db.app.model.entidad.personaje.equipo.Equipo;
import db.app.model.entidad.personaje.equipo.GuerrerosZ;
import db.app.model.entidad.personaje.guerreroz.goku.Goku;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MajinBooTest {
    @Test ( expected = PersonajeEstaInhabilitado.class )
    public void usarAtaqueEspecial_InutilizaPor3TurnosEnemigo_1erTurnoNoPuedeAtacar() throws Exception{
        Goku goku = new Goku( new Posicion(1,1));
        MajinBoo majinboo = new MajinBoo( new Posicion(3,3));
        for(int i=0 ; i<6 ; i++){
            majinboo.actualizarPorTurnoTerminado();
        }
        majinboo.usarAtaqueEspecial(goku);
        goku.actualizarPorTurnoTerminado();
        goku.atacar(majinboo);
    }
    @Test ( expected= PersonajeEstaInhabilitado.class )
    public void usarAtaqueEspecial_InutilizaPor3TurnosEnemigo_3erTurnoNoPuedeMover() throws Exception{
        Equipo guerrerosZ = new GuerrerosZ();
        Equipo enemigosDeLaTierra = new EnemigosDeLaTierra();
        Posicion nuevaPosicion = new Posicion(2,2);
        Goku goku = new Goku( new Posicion(1,1));
        MajinBoo majinboo = new MajinBoo( new Posicion(3,3));
        for(int i=0 ; i<6 ; i++){
            majinboo.actualizarPorTurnoTerminado();
        }
        majinboo.usarAtaqueEspecial(goku);
        for(int i=0 ; i<1 ; i++){
            goku.actualizarPorTurnoTerminado();
        }
        goku.mover(nuevaPosicion,new Tablero(10,10,guerrerosZ,enemigosDeLaTierra));
    }
    @Test
    public void usarAtaqueEspecial_EnemigoHabilitado_PuedeAtacarYMover() throws Exception{
        Posicion primeraPosicion = new Posicion(1,1);
        Posicion nuevaPosicion = new Posicion(2,2);
        Tablero tablero = new Tablero(10,10);
        Goku goku = new Goku(primeraPosicion);
        tablero.colocarPersonaje(primeraPosicion,goku);
        MajinBoo majinboo = new MajinBoo( new Posicion(3,3));
        goku.actualizarPorTurnoTerminado();
        for(int i=0 ; i<6 ; i++){
            majinboo.actualizarPorTurnoTerminado();
        }
        majinboo.usarAtaqueEspecial(goku);
        for(int i= 0; i<3 ; i++) {
            goku.actualizarPorTurnoTerminado();
        }
        goku.atacar(majinboo);
        assertEquals( (int)(DragonBallZParametros.ParametrosDePersonajes.MajinBoo.VIDA
        - (DragonBallZParametros.ParametrosDePersonajes.Goku.GokuNormal.PODER_DE_PELEA*0.8)),
                (int) majinboo.getVida() );
        goku.mover(nuevaPosicion,tablero);
        assertEquals(goku.getPosicion(),nuevaPosicion);
    }

    @Test
    public void usarAtaqueEspecial_AtaqueEspecial_NoHaceDano()throws Exception{
        Goku goku = new Goku( new Posicion(1,1));
        MajinBoo majinboo = new MajinBoo( new Posicion(3,3));
        goku.actualizarPorTurnoTerminado();
        for(int i=0 ; i<6 ; i++){
            majinboo.actualizarPorTurnoTerminado();
        }
        majinboo.usarAtaqueEspecial(goku);
        assertEquals((int)DragonBallZParametros.ParametrosDePersonajes.Goku.VIDA, (int)goku.getVida());
    }
    @Test
    public void usarAtaqueEspecial_AtaqueEspecial_NoAumentaKIPor3Turnos() throws Exception{
        Goku goku = new Goku( new Posicion(1,1));
        MajinBoo majinboo = new MajinBoo( new Posicion(3,3));
        goku.actualizarPorTurnoTerminado();
        for(int i=0 ; i<6 ; i++){
            majinboo.actualizarPorTurnoTerminado();
        }
        majinboo.usarAtaqueEspecial(goku);
        for(int i= 0; i<3 ; i++) {
            goku.actualizarPorTurnoTerminado();
        }
        assertEquals(5,goku.getKi());
    }
}
