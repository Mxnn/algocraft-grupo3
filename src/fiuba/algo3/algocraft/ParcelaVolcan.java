package fiuba.algo3.algocraft;

public class ParcelaVolcan extends Parcela {
    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoInvalidoParaParcela {
        throw new ExcepcionElementoInvalidoParaParcela();
    }

    public void guardarElemento(Unidad unidad) throws ExcepcionElementoInvalidoParaParcela {
        throw new ExcepcionElementoInvalidoParaParcela();
    }

    //Si agregan un Construccion ver que sea extractor de gas.
}
