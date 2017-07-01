import db.app.exception.PosicionInvalida;
import db.app.model.tablero.ColeccionDeCasilleros;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.casillero.Casillero;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by joaquinalan on 07/06/2017.
 */
public class ColeccionDeCasillerosTest {
    @Test
    public void existsSquare_ExistingSquare_ShouldBeTrue() throws PosicionInvalida {
        ColeccionDeCasilleros squareCollection = new ColeccionDeCasilleros();
        Posicion posicion = new Posicion(2, 3);

        squareCollection.agregarCasillero(new Casillero(posicion));

        assertTrue(squareCollection.existeCasillero(posicion));
    }

    @Test
    public void existsSquare_NotExistingSquare_ShouldBeFalse() throws PosicionInvalida {
        ColeccionDeCasilleros squareCollection = new ColeccionDeCasilleros();
        Posicion posicion = new Posicion(2, 3);
        Posicion anotherPosition = new Posicion(222, 666);

        squareCollection.agregarCasillero(new Casillero(posicion));

        assertFalse(squareCollection.existeCasillero(anotherPosition));
    }
}
