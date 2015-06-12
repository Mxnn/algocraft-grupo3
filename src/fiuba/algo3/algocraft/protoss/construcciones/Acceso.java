package fiuba.algo3.algocraft.protoss.construcciones;


import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.protoss.unidades.Zealot;


public class Acceso extends CreadorDeSoldados {

    private static final int ESCUDO_INICIAL = 500;
    private static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public Acceso(Jugador propietario){
		this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 8;

	}
        
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
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




