package fiuba.algo3.algocraft.razas.protoss.construcciones;


import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;


public class Acceso extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 8;
    private static final int ESCUDO_INICIAL = 500;
    private static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public Acceso(Jugador propietario) {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);
	}
        
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS;
    }

    public Zealot crearZealot(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Zealot zealot = new Zealot(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, zealot);

        return zealot;
    }

    public Dragon crearDragon(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Dragon dragon = new Dragon(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, dragon);

        return dragon;
    }
}




