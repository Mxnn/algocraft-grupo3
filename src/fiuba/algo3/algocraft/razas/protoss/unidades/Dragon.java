package fiuba.algo3.algocraft.razas.protoss.unidades;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

public class Dragon extends UnidadAgresora {
    public static final int VIDA_INICIAL = 100;
    public static final int ESCUDO_INICIAL = 80;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 9;
    public static final int CUPO_DE_TRANSPORTE = 4;
    public static final int SUMINISTRO = 2;
    public static final int DANYO_AIRE = 20;
    public static final int DANYO_TIERRA = 20;
    public static final int RANGO_AIRE = 4;
    public static final int RANGO_TIERRA = 4;

    public static int COSTO_MINERAL = 125;
    public static int COSTO_GAS = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    

    public Dragon(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, new RangoAtaque(RANGO_AIRE, RANGO_TIERRA), new Danyo(DANYO_AIRE, DANYO_TIERRA));
    }
}
