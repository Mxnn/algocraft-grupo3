package fiuba.algo3.algocraft.modelo.razas.terran.construcciones;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public class PuertoEstelar extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 10;
    public static final int VIDA_INICIAL = 1300;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public PuertoEstelar(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, COSTO);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS;
    }

    public Espectro crearEspectro(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Espectro espectro = new Espectro(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, espectro);
        
        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(espectro);
    	}
        return espectro;
    }

    public NaveTransporteTerran crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        NaveTransporteTerran nave = new NaveTransporteTerran(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);
        
        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(nave);
    	}

        return nave;
    }

    public NaveCiencia crearNaveCiencia(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        NaveCiencia nave = new NaveCiencia(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);
        
        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(nave);
    	}

        return nave;
    }
}
