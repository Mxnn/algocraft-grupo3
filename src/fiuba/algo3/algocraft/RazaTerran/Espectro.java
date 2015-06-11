package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class Espectro extends UnidadAgresora {
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 120;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;

    public Espectro(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        this.danyo = new Danyo(20, 8);
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(5, 5);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        
    }
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    
    protected  int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
}
