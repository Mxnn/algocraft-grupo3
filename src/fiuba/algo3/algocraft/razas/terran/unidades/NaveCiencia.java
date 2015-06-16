package fiuba.algo3.algocraft.razas.terran.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueRadiacion;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadMagica;

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
    public static final int COSTO_ENERGIA_EMP = 100;
    public static final int COSTO_ENERGIA_RADIACION = 75;

    public NaveCiencia(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, ENERGIA_MAXIMA, ENERGIA_INICIAL, REGENERACION_ENERGIA);
    }

    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }
    
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
    
    public AtaqueEMP lanzarEMP(Parcela target) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
    	if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        this.gastarEnergia(COSTO_ENERGIA_EMP);
        
        (this.propietario).agregarAtaque(new AtaqueEMP(target));
		return new AtaqueEMP(target);
    }
    
    public AtaqueRadiacion lanzarRadiacion(Parcela target) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        this.gastarEnergia(COSTO_ENERGIA_RADIACION);
        (this.propietario).agregarAtaque(new AtaqueRadiacion(target));
		return new AtaqueRadiacion(target);
    }
    
}
