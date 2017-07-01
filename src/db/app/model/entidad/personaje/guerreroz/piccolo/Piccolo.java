package db.app.model.entidad.personaje.guerreroz.piccolo;

import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.ProvocanteDeTransformacionPorEquipoHerido;
import db.app.model.entidad.personaje.ataqueespecial.Makankosappo;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.entidad.personaje.transformacion.ProvocanteDeTransformacionPorAmigoHerido;
import db.app.model.entidad.personaje.transformacion.TransformablePorAmigoHerido;
import db.app.model.tablero.Posicion;

public class Piccolo extends Personaje implements ProvocanteDeTransformacionPorEquipoHerido, TransformablePorAmigoHerido {
    private ProvocanteDeTransformacionPorAmigoHerido mGohan;
    private final double PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO = 0.3;

    public Piccolo(Posicion posicion) {
        super(DragonBallZParametros.ParametrosDePersonajes.Piccolo.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.PICCOLO,
                DragonBallZParametros.ParametrosDePersonajes.Piccolo.SRC_Img,
                posicion);

        mTransformacionNormal = new PiccoloNormal(this);
        mSegundaTransformacion = new PiccoloFortalecido(this);
        mTerceraTransformacion = new PiccoloProtector();
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Makankosappo(this);
    }

    public Piccolo() {
        super(DragonBallZParametros.ParametrosDePersonajes.Piccolo.VIDA,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z,
                DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.PICCOLO,
                DragonBallZParametros.ParametrosDePersonajes.Piccolo.SRC_Img);
        mTransformacionNormal = new PiccoloNormal(this);
        mSegundaTransformacion = new PiccoloFortalecido(this);
        mTerceraTransformacion = new PiccoloProtector();
        mTransformacionDelPersonaje = mTransformacionNormal;

        mAtaqueEspecial = new Makankosappo(this);
    }

    public void setProvocanteDeTransformacionPorAmigoHerido(ProvocanteDeTransformacionPorAmigoHerido gohan) {
        mGohan = gohan;
    }

    @Override
    public boolean estasHerido() {
        return (getVida() < DragonBallZParametros.ParametrosDePersonajes.Piccolo.VIDA * PORCENTAJE_DE_VIDA_DE_ESTADO_HERIDO);
    }

    @Override
    public boolean tuAmigoEstaHerido() {
        return mGohan.estasHeridoParaTransformacionPorAmigoHerido();
    }
}
