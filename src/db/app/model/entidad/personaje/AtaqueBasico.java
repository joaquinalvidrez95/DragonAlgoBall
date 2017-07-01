package db.app.model.entidad.personaje;

import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.model.entidad.ValidadorDeDistancias;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class AtaqueBasico {
    public void atacarA(Atacante atacante, Personaje atacable) throws AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente {
        ValidadorDeDistancias validadorDeDistancias = new ValidadorDeDistancias();

        if (!validadorDeDistancias.esValidaLaDistancia(atacante.getPosicion(), atacable.getPosicion(), atacante.getDistanciaDeAtaque())) {
            throw new DistanciaDeAtaqueInsuficiente();
        }

        if (atacante.getEquipo().equals(atacable.getEquipo())) {
            throw new AtaqueAlMismoEquipo();
        }

        double poderDePeleaDelAtacante = atacante.usarEsferaDelDragon();

        if (poderDePeleaDelAtacante < atacable.getPoderDePelea()) {
            poderDePeleaDelAtacante *= 0.8;
        }

        atacable.perderVida(poderDePeleaDelAtacante);

//        if (atacable.getVida() <= 0) {
//            pisable.limpiarCasillero(atacable.getPosicion());
//        }
    }
}
