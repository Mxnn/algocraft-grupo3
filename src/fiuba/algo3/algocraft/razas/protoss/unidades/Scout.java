package fiuba.algo3.algocraft.razas.protoss.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

public class Scout extends UnidadAgresora {

    public static final int VIDA_INICIAL = 150;
    public static final int ESCUDO_INICIAL = 100;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 9;
    public static final int CUPO_DE_TRANSPORTE = 0;
    public static final int SUMINISTRO = 2;
    public static final int DANYO_AIRE = 14;
    public static final int DANYO_TIERRA = 8;
    public static final int RANGO_AIRE = 4;
    public static final int RANGO_TIERRA = 4;

    public static int COSTO_MINERAL = 300;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public Scout(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, new RangoAtaque(RANGO_AIRE, RANGO_TIERRA), new Danyo(DANYO_AIRE, DANYO_TIERRA));
    }

    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    public  int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }

    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
    

}
