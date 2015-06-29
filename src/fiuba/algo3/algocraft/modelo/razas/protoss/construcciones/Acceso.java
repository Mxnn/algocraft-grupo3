package fiuba.algo3.algocraft.modelo.razas.protoss.construcciones;


import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.vista.ObservadorMapa;


public class Acceso extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 8;
    public static final int ESCUDO_INICIAL = 500;
    public static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

	public Acceso(Jugador propietario) {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, COSTO);
	}

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS;
    }

    public Zealot crearZealot(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Zealot zealot = new Zealot(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, zealot);
        
        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(zealot);
    		zealot.setObservador(observador);
    	}
        
        return zealot;
    }

    public Dragon crearDragon(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        Dragon dragon = new Dragon(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, dragon);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(dragon);
    		dragon.setObservador(observador);
    	}
        
        return dragon;
    }
}




