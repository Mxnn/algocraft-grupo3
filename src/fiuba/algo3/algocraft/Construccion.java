package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public abstract class Construccion implements Interactuable {
    //Agregar vidaMaxima (la vida se restaria cada vez que es golpeado)
	protected Jugador propietario;
	protected int vida;
	protected int tiempoDeConstruccion;
    //Costo

    public abstract TipoDeConstruccion obtenerTipoDeConstruccion();

    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
