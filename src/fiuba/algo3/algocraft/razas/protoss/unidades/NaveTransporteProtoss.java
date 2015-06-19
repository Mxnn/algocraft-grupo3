package fiuba.algo3.algocraft.razas.protoss.unidades;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.NaveTransporte;

public class NaveTransporteProtoss extends NaveTransporte {
    public static final int VIDA_INICIAL = 125;
    public static final int ESCUDO_INICIAL = 60;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;
    public static final int CUPO_DE_TRANSPORTE = 0;
    public static final int CAPACIDAD = 8;
    public static final int SUMINISTRO = 2;

    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public NaveTransporteProtoss(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, CAPACIDAD);
    }
    
}
