package fiuba.algo3.algocraft;

public class ParcelaTierra extends Parcela {
    public void guardarElemento(Unidad unidad) {
        this.elemento = unidad;
    }

    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoNoAdmitidoEnParcela {
        this.elemento = unidadVoladora;
    }
}
