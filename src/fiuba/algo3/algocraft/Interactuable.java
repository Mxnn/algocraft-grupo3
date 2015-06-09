package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected Estado estado;
	protected int tiempoDeConstruccion;
	protected Parcela parcela;

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        try {
            (this.estado).recibirDanyo(cantidad);
        }
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }
    public void setParcela(Parcela parcela){
    	this.parcela = parcela;
    }
    
    public abstract void destruir();
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;
}
