package fiuba.algo3.algocraft.modelo.razas.terran.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class Espectro extends UnidadAgresora {
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static final int VIDA_INICIAL = 120;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;
    public static final int CUPO_DE_TRANSPORTE = 0;
    public static final int SUMINISTRO = 2;
    public static final int DANYO_AIRE = 20;
    public static final int DANYO_TIERRA = 8;
    public static final int RANGO_AIRE = 5;
    public static final int RANGO_TIERRA = 5;

    public Espectro(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, new RangoAtaque(RANGO_AIRE, RANGO_TIERRA), new Danyo(DANYO_AIRE, DANYO_TIERRA), new Costo(COSTO_MINERAL, COSTO_GAS));
    }

    @Override
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    @Override
    public  int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }

    @Override
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
}
