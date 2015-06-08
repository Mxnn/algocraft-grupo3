package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected Estado estado;
	protected int tiempoDeConstruccion;

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        try {
            (this.estado).recibirDanyo(cantidad);
        }
        catch (ExcepcionEstadoMuerto e) {
            //Matarlo (sacarlo de la parcela, sacarlo de la lista de unidades, sumar poblacion)
        }
    }

    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela{
    	parcela.guardarElemento(this);
    }
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela;
    
    
}
