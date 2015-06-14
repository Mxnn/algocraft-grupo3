package fiuba.algo3.algocraft.utilidades.unidades;

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

    public AtaqueComun atacar(Interactuable enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto {
		int distancia = calcularDistanciaDeEnemigo(enemigo.getParcela());
		AtaqueComun ataque = new AtaqueComun(enemigo, rangoAtaque, danyo,distancia);
//    	enemigo.recibirAtaque(ataque);
		return ataque;
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
    
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}
}
