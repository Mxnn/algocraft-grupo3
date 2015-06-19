package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;

public abstract class UnidadMagica extends Unidad {
    protected int regeneracionEnergia;
    protected int energiaMaxima;
    protected int energia;

    public UnidadMagica(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, int energiaMaxima, int energiaInicial, int regeneracionEnergia) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro);
        this.energiaMaxima = energiaMaxima;
        this.energia = energiaInicial;
        this.regeneracionEnergia = regeneracionEnergia;
    }

    public void gastarEnergia(int cantidad) throws ExcepcionEnergiaInsuficiente {
        int total = this.energia - cantidad;
        if (total < 0)
            throw new ExcepcionEnergiaInsuficiente();
        else
            this.energia = total;
    }
    
    public int getEnergia(){
    	return this.energia;
    }
    
    public void recibirEmp(){
    	super.recibirEmp();
    	this.energia = 0;
    }

    @Override
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}

    public void vivir(Mapa mapa) {
        this.regenerarEnergia();
        (this.vitalidad).regenerar();
    }

    public void regenerarEnergia() {
        int total = this.energia + this.regeneracionEnergia;
        if (total > this.energiaMaxima)
            this.energia = this.energiaMaxima;
        else
            this.energia = total;
    }
}
