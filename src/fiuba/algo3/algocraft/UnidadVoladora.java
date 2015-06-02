package fiuba.algo3.algocraft;

public class UnidadVoladora extends Unidad {
    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoInvalidoParaParcela {
        parcela.guardarElemento(this);
    }
}
