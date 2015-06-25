package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;

public interface ObservadorMapa {
	
//	public abstract void crearVistaParcela(ParcelaTierra parcela);
	public abstract void crearVistaParcela(ParcelaEspacio parcela);
	public abstract void crearVistaParcela(ParcelaMineral parcela);
	public abstract void crearVistaParcela(ParcelaVolcan parcela);
}
