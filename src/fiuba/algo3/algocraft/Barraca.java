package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaTerran.Marine;

import java.util.ArrayList;

public class Barraca extends CreadorDeSoldados {

    private static final int VIDA_INICIAL = 1000;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
	public Barraca(Jugador propietario) {
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 12;
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }

    public Marine crearMarine(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        Marine marine = new Marine(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, marine);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), marine);
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

        return marine;
    }
}
