package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeUnidadesTerrestres;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Mapa;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.terran.unidades.Golliat;

public class Fabrica extends CreadorDeUnidadesTerrestres {
    private static final int VIDA_INICIAL = 1250;
    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
	
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.tiempoDeConstruccion = 12;
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }

    public Golliat crearGolliat(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        Golliat golliat = new Golliat(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, golliat);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), golliat);
//            }
//            catch (ExcepcionElementoNoAdmitidoEnParcela e) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            catch (ExcepcionParcelaOcupada e) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            elementoUbicado = true;
//        }
//
//        if (coordenadasVecinas.size() <= 0)
//            throw new ExcepcionNoHayLugarDisponible();

        return golliat;
    }
}
