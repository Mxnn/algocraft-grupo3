package fiuba.algo3.algocraft;

public class UnidadVoladora extends Unidad {
    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
