package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected int vida;
	protected int tiempoDeConstruccion;
	
    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela{
    	parcela.guardarElemento(this);
    }
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    
    
}
