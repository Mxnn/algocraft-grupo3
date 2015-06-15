package fiuba.algo3.algocraft.razas.terran.construcciones;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

public class Fabrica extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 12;
    private static final int VIDA_INICIAL = 1250;
    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
	
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS;
    }

    public Golliat crearGolliat(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Golliat golliat = new Golliat(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, golliat);

        return golliat;
    }
}
