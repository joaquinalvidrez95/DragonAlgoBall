package db.app.model.entidad.personaje.ataqueespecial;

import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.exception.KiInsuficiente;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 22/06/2017.
 */
public class ConvierteteEnChocolate implements AtaqueEspecial {
    private final int mKiRequerido = DragonBallZParametros.AtaquesEspeciales.ConvierteteEnChocolate.COSTO;
    private final int CANTIDAD_DE_TURNOS_A_DESHABILITAR = 3;
    private Personaje mAtacante;

    public ConvierteteEnChocolate(Personaje atacante) {
        mAtacante = atacante;
    }

    @Override
    public void atacar(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente {
        if (mAtacante.getKi() < mKiRequerido) {
            throw new KiInsuficiente();
        }
        atacado.inhabilitar(CANTIDAD_DE_TURNOS_A_DESHABILITAR);
    }

    @Override
    public String getNombreAtaqueEspecial() {
        return DragonBallZParametros.AtaquesEspeciales.ConvierteteEnChocolate.NOMBRE;
    }
}
