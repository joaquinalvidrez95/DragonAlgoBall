package db.app.model.entidad.personaje.estado;

import db.app.exception.*;
import db.app.model.entidad.Movible;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.consumible.esferadeldragon.EsferaDelDragon;
import db.app.model.entidad.consumible.nubevoladora.NubeVoladora;
import db.app.model.entidad.consumidor.ConsumidorDeEsferaDelDragon;
import db.app.model.entidad.consumidor.ConsumidorDeNubeVoladora;
import db.app.model.entidad.personaje.Atacante;
import db.app.model.entidad.personaje.ConsumidorDeKi;
import db.app.model.entidad.personaje.TransformacionDelPersonaje;
import db.app.model.entidad.personaje.ataqueespecial.AtaqueEspecial;
import db.app.model.tablero.Pisable;
import db.app.model.tablero.Posicion;

public abstract class Personaje implements Movible, ConsumidorDeKi, Atacante, ConsumidorDeNubeVoladora, ConsumidorDeEsferaDelDragon {
    protected TransformacionDelPersonaje mTransformacionDelPersonaje;
    protected TransformacionDelPersonaje mTransformacionNormal;
    protected TransformacionDelPersonaje mSegundaTransformacion;
    protected TransformacionDelPersonaje mTerceraTransformacion;

    protected AtaqueEspecial mAtaqueEspecial;

    //private EfectoConsumible efectoModificadorAtaque;
    //private EfectoConsumible efectoModificadorVelocidad;

    private NubeVoladora mNubeVoladora;
    private EsferaDelDragon mEsferaDelDragon;

    private EstadoDePersonaje mEstadoDePersonaje;
    private EstadoDePersonaje mPersonajeInhabilitado;
    private EstadoDePersonaje mPersonajeHabilitado;
    private EstadoDePersonaje mPersonajeMuerto;

    private double mVida;
    private int mKi;
    private final String mEquipo;
    private final String mNombre;
    private String srcProfilImg;
    private Posicion mPosicion;
    private int mCantidadDeTurnosDeshabilitado = 0;

    public Personaje(double vida, String equipo, String nombre, String srcProfilImg, Posicion posicion) {
        this(vida, equipo, nombre, srcProfilImg);
        mPosicion = posicion;
    }

    public Personaje(double vida, String equipo, String nombre, String srcProfilImg) {
        mKi = 0;
        this.mVida = vida;
        this.mEquipo = equipo;
        this.mNombre = nombre;
        this.srcProfilImg = srcProfilImg;

        mNubeVoladora = new NubeVoladora();
        mEsferaDelDragon = new EsferaDelDragon();
        //efectoModificadorVelocidad = new EfectoSinModificadores();
        //efectoModificadorAtaque = new EfectoSinModificadores();

        mPersonajeHabilitado = new PersonajeHabilitado(this);
        mPersonajeInhabilitado = new PersonajeInhabilitado(this);
        mPersonajeMuerto = new PersonajeMuerto(this);
        mEstadoDePersonaje = mPersonajeHabilitado;
    }

    public void actualizarPorTurnoTerminado() throws ElPersonajeEstaMuerto {
        mNubeVoladora.actualizarPorTurnoTerminado();
        mEstadoDePersonaje.actualizarPorTurnoTerminado();
    }

    @Override
    public int getKi() {
        return mKi;
    }

    public int getDistanciaDeAtaque() {
        return mTransformacionDelPersonaje.getDistanciaAtaque();
    }

    public double getPoderDePelea() {
        //return mTransformacionDelPersonaje.getPoderDePelea() + efectoModificadorAtaque.modificadorDeAtaque();
        return mTransformacionDelPersonaje.getPoderDePelea();
    }

    @Override
    public double usarEsferaDelDragon() {
        return mEsferaDelDragon.usarEnAtaque(this) + getPoderDePelea();
    }

    public double getVida() {
        return mVida;
    }

    public String getEquipo() {
        return mEquipo;
    }

    public String getSrcProfilImg() {
        return srcProfilImg;
    }

    public void setSrcProfilImg(String srcProfilImg) {
        this.srcProfilImg = srcProfilImg;
    }

    public AtaqueEspecial getAtaqueEspecial() {
        return mAtaqueEspecial;
    }

    public void inhabilitar(int cantidadDeTurnosDeshabilitado) {
        mEstadoDePersonaje.inhabilitar(cantidadDeTurnosDeshabilitado);
    }
//    public void setmAtaqueEspecial(AtaqueEspecial mAtaqueEspecial) {
//        this.mAtaqueEspecial = mAtaqueEspecial;
//    }

    public void atacar(Personaje enemigo) throws AtaqueAlMismoEquipo, DistanciaDeAtaqueInsuficiente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        mEstadoDePersonaje.atacar(enemigo);
    }

    public void perderVida(double dano) {
        mEstadoDePersonaje.perderVida(dano);
    }

    public void usarAtaqueEspecial(Personaje atacado) throws DistanciaDeAtaqueInsuficiente, AtaqueAlMismoEquipo, KiInsuficiente, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto {
        mEstadoDePersonaje.usarAtaqueEspecial(atacado);
    }

    public void aumentarVida(double cantidadDeVida) {
        mVida += cantidadDeVida;
    }

    @Override
    public Posicion getPosicion() {
        return mPosicion;
    }

    @Override
    public int getVelocidad() {
        return getVelocidadSinNubeVoladora() + mNubeVoladora.getVelocidad(this);//efectoModificadorVelocidad.modificadorDeVelocidad();
        //return mTransformacionDelPersonaje.getVelocidad() + efectoModificadorVelo;
    }

    @Override
    public int getVelocidadSinNubeVoladora() {
        return mTransformacionDelPersonaje.getVelocidad();
    }

    public String getNombre() {
        return mNombre;
    }

    //    public void actualizarPorTurnoTerminado() {
//        mEstadoDePersonaje.actualizarPorTurnoTerminado();
//    }
    public boolean estasVivo() {
        return mEstadoDePersonaje.estasVivo();
    }

    public void transformar() throws IncapazDeTransformarse {
        mTransformacionDelPersonaje.transform();
    }

    public void mover(Posicion destino, Pisable areaEnDondeMoverse) throws CaminoBloqueado, PosicionInvalida, CeldaOcupada, CasilleroNoExistente, FaltaDeVelocidad, PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, CeldaVacia {
        mEstadoDePersonaje.mover(destino, areaEnDondeMoverse);

    }

    public void setTransformacionDelPersonaje(TransformacionDelPersonaje transformacionDelPersonaje) {
        this.mTransformacionDelPersonaje = transformacionDelPersonaje;
    }

    public TransformacionDelPersonaje getEstadoDelPersonaje() {
        return this.mTransformacionDelPersonaje;
    }

    @Override
    public void consumirKi(int kiConsumido) {
        mKi -= kiConsumido;
    }

    public TransformacionDelPersonaje getEstadoNormal() {
        return mTransformacionNormal;
    }

    public TransformacionDelPersonaje getSegundaTransformacion() {
        return mSegundaTransformacion;
    }

    public TransformacionDelPersonaje getTerceraTransformacion() {
        return mTerceraTransformacion;
    }

    @Override
    public void setPosicion(Posicion posicion) {
        this.mPosicion = posicion;
    }

    public void consumirObjeto(Consumible objeto) {
        objeto.consumir(this);
    }

//    public void setEfectoAtaqueAumentado(double bonificacionDeAtaque) {
//        efectoModificadorAtaque = new EfectoModificadorDeAtaque(bonificacionDeAtaque);
//    }

//    public void setEfectoVelocidadAumentada(int bonificacionDeVelocidad) {
//        efectoModificadorVelocidad = new EfectoModificadorDeVelocidad(bonificacionDeVelocidad);
//    }

//    public void efectoAtaqueTerminado() {
//        efectoModificadorAtaque = new EfectoSinModificadores();
//    }

//    public void efectoVelocidadTerminado() {
//        efectoModificadorVelocidad = new EfectoSinModificadores();
//    }

    void setEstadoDelPersonaje(EstadoDePersonaje estadoDePersonaje) {
        mEstadoDePersonaje = estadoDePersonaje;
    }

    EstadoDePersonaje getPersonajeInhabilitado() {
        return mPersonajeInhabilitado;
    }

    EstadoDePersonaje getPersonajeHabilitado() {
        return mPersonajeHabilitado;
    }

    EstadoDePersonaje getPersonajeMuerto() {
        return mPersonajeMuerto;
    }

    void setVida(double vida) {
        this.mVida = vida;
    }

    void setKi(int ki) {
        this.mKi = ki;
    }

    public void activarEsferaDelDragon() {
        mEsferaDelDragon.activar();
    }

    public void activarNubeVoladora() {
        mNubeVoladora.activar();
    }

    void agregarCantidadDeTurnosDeshabilitado(int cantidadDeTurnosDeshabilitado) {
        mCantidadDeTurnosDeshabilitado += cantidadDeTurnosDeshabilitado;
    }

    int getCantidadDeTurnosDeshabilitado() {
        return mCantidadDeTurnosDeshabilitado;
    }

    void restarCantidadDeTurnosDeshabilitado() {
        mCantidadDeTurnosDeshabilitado--;
    }
}

