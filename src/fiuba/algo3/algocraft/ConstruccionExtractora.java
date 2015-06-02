package fiuba.algo3.algocraft;

public abstract class ConstruccionExtractora extends Construccion {
	public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
