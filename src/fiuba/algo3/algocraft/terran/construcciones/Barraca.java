package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeSoldados;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Mapa;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.terran.unidades.Marine;

public class Barraca extends CreadorDeSoldados {

    private static final int VIDA_INICIAL = 1000;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
	public Barraca(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.tiempoDeConstruccion = 12;
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }

    public Marine crearMarine(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Marine marine = new Marine(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, marine);

        return marine;
    }
}
