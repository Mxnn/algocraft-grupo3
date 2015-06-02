package fiuba.algo3.algocraft;

public class ParcelaEspacio extends Parcela {
    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoInvalidoParaParcela {
        this.elemento = unidadVoladora;
    }

    public void guardarElemento(Unidad unidad) throws ExcepcionElementoInvalidoParaParcela {
        throw new ExcepcionElementoInvalidoParaParcela();
    }
}
