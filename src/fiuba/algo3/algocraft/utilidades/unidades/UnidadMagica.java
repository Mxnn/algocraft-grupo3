package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

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

    public void regenerarEnergia() {
        int total = this.energia + this.regeneracionEnergia;
        if (total > this.energiaMaxima)
            this.energia = this.energiaMaxima;
        else
            this.energia = total;
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
    	this.energia = 0;
    }
    
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}
}
