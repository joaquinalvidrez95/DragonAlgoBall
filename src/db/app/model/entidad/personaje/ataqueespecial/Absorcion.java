package db.app.model.entidad.personaje.ataqueespecial;


import db.app.exception.AtaqueAlMismoEquipo;
import db.app.exception.DistanciaDeAtaqueInsuficiente;
import db.app.exception.KiInsuficiente;
import db.app.model.entidad.personaje.AtaqueBasico;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;


/**
 * Created by joaquinalan on 15/06/2017.
 */
public class Absorcion implements AtaqueEspecial {
    private int mCantidadDeAbsorcionesHechas;
    private final int KI_REQUERIDO = DragonBallZParametros.AtaquesEspeciales.Absorber.COSTO;
    private Absorbedor mAbsorbedor;

    public Absorcion(Absorbedor absorbedor) {
        mAbsorbedor = absorbedor;
        this.mCantidadDeAbsorcionesHechas = 0;
    }

    @Override
    public void atacar(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente {
        //ValidadorDeDistancias validadorDeDistancias = new ValidadorDeDistancias();

        if (mAbsorbedor.getKi() < KI_REQUERIDO) {
            throw new KiInsuficiente();
        }

        double poderDePeleaDelAtacante = mAbsorbedor.usarEsferaDelDragon();

        AtaqueBasico ataqueBasico = new AtaqueBasico();
        ataqueBasico.atacarA(mAbsorbedor, atacado);

        if (poderDePeleaDelAtacante < atacado.getPoderDePelea()) {
            poderDePeleaDelAtacante *= 0.8;
        }

        mAbsorbedor.consumirKi(KI_REQUERIDO);
        mAbsorbedor.aumentarVida(poderDePeleaDelAtacante);
        mCantidadDeAbsorcionesHechas++;
    }

    public int getCantidadDeAbsorcionesHechas() {
        return mCantidadDeAbsorcionesHechas;
    }

    public String getNombreAtaqueEspecial() {
        return DragonBallZParametros.AtaquesEspeciales.Absorber.NOMBRE;
    }


}
