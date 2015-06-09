package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Zealot extends UnidadTerrestre implements Agresor {
    public static final int VIDA_INICIAL = 100;
    public static final int ESCUDO_INICIAL = 60;
    public static final int CUPO_TRANSPORTE = 2;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 4;
	
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    

	public Zealot(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.danyo = new Danyo(0, 8);
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(0, 1);
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        this.parcela = parcela;
	}
	
	public void atacar(UnidadTerrestre enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto {
		this.estaEnRango(this.parcela, enemigo, (this.rangoAtaque).obtenerRangoDeAtaqueEnTierra());
		enemigo.recibirDanyo(danyo.obtenerDanyoDeAtaqueEnTierra());
	}
	
	public void atacar(UnidadVoladora enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		throw new ExcepcionEnemigoNoAtacable();
	}
	
	public void atacar(Construccion enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		this.estaEnRango(this.parcela, enemigo, (this.rangoAtaque).obtenerRangoDeAtaqueEnTierra());
		enemigo.recibirDanyo(danyo.obtenerDanyoDeAtaqueEnTierra());
	}
}


