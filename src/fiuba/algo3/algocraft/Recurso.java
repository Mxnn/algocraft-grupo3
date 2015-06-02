package fiuba.algo3.algocraft;

public class Recurso implements Interactuable {
    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
