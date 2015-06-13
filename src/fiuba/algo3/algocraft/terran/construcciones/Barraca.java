package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.terran.unidades.Marine;

public class Barraca extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 12;
    private static final int VIDA_INICIAL = 1000;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
	public Barraca(Jugador propietario) {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION);
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }

    public Marine crearMarine(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Marine marine = new Marine(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, marine);

        return marine;
    }
}
