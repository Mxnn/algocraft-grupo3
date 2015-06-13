package fiuba.algo3.algocraft.terran.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public class NaveCiencia extends UnidadMagica {

    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 225;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 200;
    public static final int VISION = 10;
    public static final int TIEMPO_DE_CONSTRUCCION = 10;
    public static final int CUPO_DE_TRANSPORTE = 0;
    public static final int SUMINISTRO = 2;
    public static final int ENERGIA_MAXIMA = 200;
    public static final int ENERGIA_INICIAL = 50;
    public static final int REGENERACION_ENERGIA = 10;

    public NaveCiencia(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, ENERGIA_MAXIMA, ENERGIA_INICIAL, REGENERACION_ENERGIA);
    }

    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    protected int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
}
