package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.protoss.unidades.Scout;


public class PuertoEstelarProtoss extends CreadorDeUnidadesTerrestres {
    private static final int VIDA_INICIAL = 600;
    private static final int ESCUDO_INICIAL = 600;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
		this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 10;

	}
        
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }
    
    public Scout crearScout(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Scout scout = new Scout(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, scout);

        return scout;
    }
    
    public NaveTransporteProtoss crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveTransporteProtoss nave = new NaveTransporteProtoss(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, nave);

        return nave;
    }
}