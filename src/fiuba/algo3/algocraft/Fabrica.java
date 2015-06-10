package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaTerran.Golliat;

import java.util.ArrayList;

public class Fabrica extends CreadorDeUnidadesTerrestres {
    private static final int VIDA_INICIAL = 1250;
    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
	
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 12;
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }

    public Golliat crearGolliat(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Boolean elementoUbicado = false;
        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        Golliat golliat = new Golliat(this.propietario);
        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
            try {
                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), golliat);
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

        return golliat;
    }
}
