package fiuba.algo3.algocraft;

public abstract class UnidadTerrestre extends Unidad {
    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoInvalidoParaParcela {
        parcela.guardarElemento(this);
    }
}
