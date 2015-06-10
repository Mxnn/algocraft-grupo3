package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.RazaProtoss.Scout;

import java.util.ArrayList;


public class PuertoEstelarProtoss extends CreadorDeUnidadesTerrestres {
    private static final int VIDA_INICIAL = 600;
    private static final int ESCUDO_INICIAL = 600;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
		this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 10;

	}
        
    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }
    
    public Scout crearScout(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Boolean elementoUbicado = false;
        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        Scout scout = new Scout(this.propietario);
        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
            try {
                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), scout);
            }
            catch (ExcepcionElementoNoAdmitidoEnParcela e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionParcelaOcupada e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
                coordenadasVecinas.remove(0);
                continue;
            }
            elementoUbicado = true;
        }

        if (coordenadasVecinas.size() <= 0)
            throw new ExcepcionNoHayLugarDisponible();

        return scout;
    }
    
    public NaveTransporteProtoss crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Boolean elementoUbicado = false;
        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        NaveTransporteProtoss nave = new NaveTransporteProtoss(this.propietario);
        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
            try {
                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), nave);
            }
            catch (ExcepcionElementoNoAdmitidoEnParcela e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionParcelaOcupada e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
                coordenadasVecinas.remove(0);
                continue;
            }
            elementoUbicado = true;
        }

        if (coordenadasVecinas.size() <= 0)
            throw new ExcepcionNoHayLugarDisponible();

        return nave;
    }
}