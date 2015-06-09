package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class Scout extends UnidadAgresora {
    public static final int VIDA_INICIAL = 150;
    public static final int ESCUDO_INICIAL = 100;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 9;

    public static int COSTO_MINERAL = 300;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public Scout(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.danyo = new Danyo(14, 8);
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        this.parcelaUbicacion = parcela;
    }
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    
    public void recibirAtaque(UnidadAgresora agresor, int distancia) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
    	RangoAtaque rango = agresor.obtenerRangoAtaque();
    	Danyo danyo = agresor.obtenerDanyo();
    	if(rango.obtenerRangoDeAtaqueAlAire() < distancia){
    		throw new ExcepcionEnemigoFueraDeAlcance();
    	}
    	this.recibirDanyo(danyo.obtenerDanyoDeAtaqueEnAire());
    }
}
