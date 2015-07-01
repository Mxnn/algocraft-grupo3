package fiuba.algo3.algocraft.modelo.razas.terran.construcciones;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.vista.observadores.mapa.ObservadorMapa;

public class Fabrica extends Construccion {
    private static final int TIEMPO_DE_CONSTRUCCION = 12;
    public static final int VIDA_INICIAL = 1250;
    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
	
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, COSTO);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS;
    }

    public Golliat crearGolliat(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionRecursosInsuficientes {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Golliat golliat = new Golliat(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, golliat);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearUnidad(golliat);
    		golliat.setObservador(observador);
    	}

        return golliat;
    }
}
