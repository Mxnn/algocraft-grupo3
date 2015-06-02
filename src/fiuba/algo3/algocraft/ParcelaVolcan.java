package fiuba.algo3.algocraft;

public class ParcelaVolcan extends Parcela {
    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoNoAdmitidoEnParcela {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    public void guardarElemento(Unidad unidad) throws ExcepcionElementoNoAdmitidoEnParcela {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    //Si agregan un Construccion ver que sea extractor de gas.
}
