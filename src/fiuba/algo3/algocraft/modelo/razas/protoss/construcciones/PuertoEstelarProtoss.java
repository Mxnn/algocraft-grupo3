package fiuba.algo3.algocraft.modelo.razas.protoss.construcciones;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public class PuertoEstelarProtoss extends Construccion {
    private static final int TIEMPO_DE_CONSTRUCCION = 10;
    public static final int VIDA_INICIAL = 600;
    public static final int ESCUDO_INICIAL = 600;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, COSTO);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
	}

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS;
    }

    public Scout crearScout(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Scout scout = new Scout(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, scout);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearUnidad(scout);
    		scout.setObservador(observador);
    	}

        return scout;
    }
    
    public NaveTransporteProtoss crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        NaveTransporteProtoss nave = new NaveTransporteProtoss(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearUnidad(nave);
    		nave.setObservador(observador);
    	}

        return nave;
    }
}