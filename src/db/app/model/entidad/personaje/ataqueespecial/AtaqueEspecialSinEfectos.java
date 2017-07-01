package db.app.model.entidad.personaje.ataqueespecial;

import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.exception.KiInsuficiente;
import db.app.model.entidad.ValidadorDeDistancias;
import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.estado.Personaje;

/**
 * Created by joaquinalan on 15/06/2017.
 */
public class AtaqueEspecialSinEfectos implements AtaqueEspecial {
    private int mKiRequerido;
    private Atacante mAtacante;
    private double mPorcentajeDeDanoExtra;
    private String nombreAtaqueEspecial;

    public AtaqueEspecialSinEfectos(Atacante atacante, int kiRequerido, double porcentajeDeDanoExtra, String nombreAtaqueEspecial) {
        this.mKiRequerido = kiRequerido;
        this.mAtacante = atacante;
        this.mPorcentajeDeDanoExtra = porcentajeDeDanoExtra;
        this.nombreAtaqueEspecial = nombreAtaqueEspecial;
    }

    @Override
    public void atacar(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente {
        ValidadorDeDistancias validadorDeDistancias = new ValidadorDeDistancias();

        if (!validadorDeDistancias.esValidaLaDistancia(mAtacante.getPosicion(), atacado.getPosicion(), mAtacante.getDistanciaDeAtaque())) {
            throw new DistanciaDeAtaqueInsuficiente();
        }

        if (mAtacante.getKi() < mKiRequerido) {
            throw new KiInsuficiente();
        }

        mAtacante.consumirKi(mKiRequerido);
        double poderDePeleaDelAtacante = mAtacante.usarEsferaDelDragon();

        if (mAtacante.getEquipo().equals(atacado.getEquipo())) {
            throw new AtaqueAlMismoEquipo();
        }

        if (poderDePeleaDelAtacante < atacado.getPoderDePelea()) {
            poderDePeleaDelAtacante *= 0.8;
        }

        mPorcentajeDeDanoExtra = mPorcentajeDeDanoExtra / 100 + 1;
        poderDePeleaDelAtacante *= mPorcentajeDeDanoExtra;
        atacado.perderVida(poderDePeleaDelAtacante);
    }

    public String getNombreAtaqueEspecial() {
        return nombreAtaqueEspecial;
    }


}
