package fiuba.algo3.algocraft.protoss.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaTierra;

public class Zealot extends UnidadAgresora /*implements Alucinable*/ {
    public static final int VIDA_INICIAL = 100;
    public static final int ESCUDO_INICIAL = 60;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 4;
    public static final int CUPO_DE_TRANSPORTE = 2;
    public static final int SUMINISTRO = 2;
    public static final int DANYO_AIRE = 0;
    public static final int DANYO_TIERRA = 8;
    public static final int RANGO_AIRE = 0;
    public static final int RANGO_TIERRA = 1;
	
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    

	public Zealot(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, new RangoAtaque(RANGO_AIRE, RANGO_TIERRA), new Danyo(DANYO_AIRE, DANYO_TIERRA));
	}
	
	public boolean destinacionPermitida(Parcela parcelaDestinacion) {

		return (parcelaDestinacion.getClass() == ParcelaTierra.class);
	}
}


