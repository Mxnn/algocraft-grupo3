package fiuba.algo3.algocraft.ConstruccionesProtoss;


import fiuba.algo3.algocraft.CreadorDeSoldados;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaProtoss.Zealot;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;


public class Acceso extends CreadorDeSoldados {
	public Acceso(Jugador propietario){
		this.propietario = propietario;
        this.vida = 500;
        //escudo = 500
        this.tiempoDeConstruccion = 8;
        //Costo = 150M
	}
        
    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }
    public Zealot crearZealot() throws ExcepcionNoHaySuministrosDisponibles {
        return new Zealot(this.propietario);
    }
    public Dragon crearDragon() throws ExcepcionNoHaySuministrosDisponibles {
        return new Dragon(this.propietario);
    }
}




