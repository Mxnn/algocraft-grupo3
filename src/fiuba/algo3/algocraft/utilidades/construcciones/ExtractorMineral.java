package fiuba.algo3.algocraft.utilidades.construcciones;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class ExtractorMineral extends Construccion {
    public static final int CANTIDAD_DE_MINERALES_RECOLECTADOS_POR_TURNO = 10;

    public ExtractorMineral(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion) {
        super(propietario, vitalidad, tiempoDeConstruccion);
    }

    public void recolectarRecursos() {
        (this.propietario).sumarMinerales(CANTIDAD_DE_MINERALES_RECOLECTADOS_POR_TURNO);
    }

    @Override
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    @Override
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    @Override
    public void vivir(Mapa mapa) {
        this.recolectarRecursos();
    }
    
}
