package fiuba.algo3.algocraft.modelo.razas.terran.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AtaqueRadiacion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadMagica;

public class NaveCiencia extends UnidadMagica {

    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 225;
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

    public NaveCiencia(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, ENERGIA_MAXIMA, ENERGIA_INICIAL, REGENERACION_ENERGIA, new Costo(COSTO_MINERAL, COSTO_GAS));
    }

    @Override
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    @Override
    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }

    @Override
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
    
    public void lanzarEMP(Parcela target) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
    	if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        this.gastarEnergia(COSTO_ENERGIA_EMP);
        
        (this.propietario).agregarAtaque(new AtaqueEMP(target));
    }
    
    public void lanzarRadiacion(Parcela target) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        this.gastarEnergia(COSTO_ENERGIA_RADIACION);
        (this.propietario).agregarAtaque(new AtaqueRadiacion(target));
    }
}
