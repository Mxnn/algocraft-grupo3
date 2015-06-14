package fiuba.algo3.algocraft.razas.terran.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

public class Golliat extends UnidadAgresora {
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 125;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 6;
    public static final int CUPO_DE_TRANSPORTE = 2;
    public static final int SUMINISTRO = 2;
    public static final int DANYO_AIRE = 10;
    public static final int DANYO_TIERRA = 12;
    public static final int RANGO_AIRE = 5;
    public static final int RANGO_TIERRA = 6;

    public Golliat(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, new RangoAtaque(RANGO_AIRE, RANGO_TIERRA), new Danyo(DANYO_AIRE, DANYO_TIERRA));
    }
    
	public boolean destinacionPermitida(Parcela parcelaDestinacion) {

		return parcelaDestinacion.noEsEspacio();
	}
    
}