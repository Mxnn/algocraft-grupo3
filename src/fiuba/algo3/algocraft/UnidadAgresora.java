package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class UnidadAgresora extends Unidad {
    protected RangoAtaque rangoAtaque;
    protected Danyo danyo;

    public UnidadAgresora(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, RangoAtaque rangoAtaque, Danyo danyo) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro);
        this.rangoAtaque = rangoAtaque;
        this.danyo = danyo;
    }

    public void atacar(Interactuable enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto {
		int distancia = calcularDistanciaDeEnemigo(enemigo.getParcela());
    	enemigo.recibirAtaque(this, distancia);
	}
    
    private int calcularDistanciaDeEnemigo(Parcela parcelaEnemigo) {
    	return ((this.parcelaUbicacion).devolverDistanciaConParcela(parcelaEnemigo));
    }
    
    public RangoAtaque getRangoAtaque() {
    	return this.rangoAtaque;
    }
    
    public Danyo getDanyo() {
    	return this.danyo;
    }

}
