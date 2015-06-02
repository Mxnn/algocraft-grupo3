package fiuba.algo3.algocraft;

public abstract class ConstruccionParaUnidades extends Construccion {
	public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
