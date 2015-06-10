package fiuba.algo3.algocraft.ConstruccionesProtoss;


import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaProtoss.Zealot;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;


public class Acceso extends CreadorDeSoldados {

    private static final int ESCUDO_INICIAL = 500;
    private static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public Acceso(Jugador propietario){
		this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 8;

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




