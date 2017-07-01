
import db.app.exception.PosicionInvalida;
import db.app.model.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by joaquinalan on 07/06/2017.
 */
public class PosicionTest {
    @Test
    public void equals_ObjectSameFields_ShouldBeTrue() throws PosicionInvalida {
        Posicion posicion = new Posicion(2, 3);
        Posicion anotherPosition = new Posicion(2, 3);

        assertTrue(posicion.equals(anotherPosition));
    }

    @Test
    public void equals_ObjectDifferentFields_ShouldBeFalse() throws PosicionInvalida {
        Posicion posicion = new Posicion(2, 3);
        Posicion anotherPosition = new Posicion(4000, 200);

        assertFalse(posicion.equals(anotherPosition));
    }
}
