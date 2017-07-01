package db.app.model.entidad.personaje.ataqueespecial;

import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.exception.KiInsuficiente;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public interface AtaqueEspecial {
    void atacar(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente;

    String getNombreAtaqueEspecial();

}
