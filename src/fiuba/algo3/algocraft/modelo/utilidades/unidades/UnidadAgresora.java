package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;

public abstract class UnidadAgresora extends Unidad {
    protected RangoAtaque rangoAtaque;
    protected Danyo danyo;

    public UnidadAgresora(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, RangoAtaque rangoAtaque, Danyo danyo, Costo costo) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro, costo);
        this.rangoAtaque = rangoAtaque;
        this.danyo = danyo;
    }

    public void atacar(Parcela parcela) {
		int distancia = calcularDistanciaDeEnemigo(parcela);
		AtaqueComun ataque = new AtaqueComun(parcela, rangoAtaque, danyo, distancia);
		this.propietario.agregarAtaque(ataque);
//		return new AtaqueComun(parcela, rangoAtaque, danyo, distancia);
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

    @Override
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}
    
}
