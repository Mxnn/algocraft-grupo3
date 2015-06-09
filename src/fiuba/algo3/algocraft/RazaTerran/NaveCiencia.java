package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class NaveCiencia extends UnidadMagica {
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 225;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 200;
    public static final int VISION = 10;
    public static final int TIEMPO_DE_CONSTRUCCION = 10;
    /*public static final int ENERGIA_MAXIMA = 200;
    public static final int ENERGIA_INICIAL = 50;
    public static final int REGENERACION_ENERGIA = 10;*/

    public NaveCiencia(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);

        this.vision = VISION;
 
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        this.parcelaUbicacion = parcela;
    }
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    protected  int seleccionarDanyo(Danyo danyo){
    	return danyo.obtenerDanyoDeAtaqueEnAire();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.obtenerRangoDeAtaqueAlAire();
    }
}
