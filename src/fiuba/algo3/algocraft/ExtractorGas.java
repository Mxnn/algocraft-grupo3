package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public abstract class ExtractorGas extends ConstruccionExtractora {
    private static final int CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO = 10;

    public void absorberGasVespeno() {
        (this.propietario).sumarGasVespeno(CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO);
    }

    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
