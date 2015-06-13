package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.protoss.unidades.Scout;


public class PuertoEstelarProtoss extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 10;
    private static final int VIDA_INICIAL = 600;
    private static final int ESCUDO_INICIAL = 600;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
	}
        
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS;
    }
    
    public Scout crearScout(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Scout scout = new Scout(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, scout);

        return scout;
    }
    
    public NaveTransporteProtoss crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveTransporteProtoss nave = new NaveTransporteProtoss(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);

        return nave;
    }
}