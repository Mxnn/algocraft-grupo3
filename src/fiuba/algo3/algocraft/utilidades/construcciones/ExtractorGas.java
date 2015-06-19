package fiuba.algo3.algocraft.utilidades.construcciones;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class ExtractorGas extends Construccion {
    public static final int CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO = 10;

    public ExtractorGas(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion) {
        super(propietario, vitalidad, tiempoDeConstruccion);
    }

    public void recolectarRecursos() {
        (this.propietario).sumarGasVespeno(CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO);
    }

    @Override
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    @Override
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    @Override
    public void vivir(Mapa mapa) {
        this.recolectarRecursos();
    }
}
