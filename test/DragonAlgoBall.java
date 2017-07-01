
import db.app.model.entidad.personaje.equipo.EnemigosDeLaTierra;
import db.app.model.entidad.personaje.equipo.GuerrerosZ;
import db.app.model.tablero.Tablero;
import org.junit.Test;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class DragonAlgoBall {
    @Test
    public void atacar_() throws Exception {
        GuerrerosZ guerrerosZ = new GuerrerosZ();
        EnemigosDeLaTierra enemigosDeLaTierra = new EnemigosDeLaTierra();
        Tablero tablero = new Tablero(7, 7, guerrerosZ, enemigosDeLaTierra);


    }
}
