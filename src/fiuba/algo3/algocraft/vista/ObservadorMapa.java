package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;

public interface ObservadorMapa {
	
//	public abstract void crearVistaParcela(ParcelaTierra parcela);
	public abstract void crearVistaParcela(ParcelaEspacio parcela);
	public abstract void crearVistaParcela(ParcelaMineral parcela);
	public abstract void crearVistaParcela(ParcelaVolcan parcela);
	public abstract void crearInteractuable(ArchivosTemplarios archivo);
	public abstract void crearInteractuable(PuertoEstelar puertoEstelar);
	public abstract void crearInteractuable(Fabrica fabrica);
	public abstract void crearInteractuable(Barraca barraca);
	public abstract void crearInteractuable(DepositoSuministro depositoSuministro);
	public abstract void crearInteractuable(CentroDeMineral centroDeMineral);
	public abstract void crearInteractuable(Refineria refineria);
	public abstract void crearInteractuable(PuertoEstelarProtoss puerto);
	public abstract void crearInteractuable(Acceso acceso);
	public abstract void crearInteractuable(Pilon pilon);
	public abstract void crearInteractuable(NexoMineral nexoMineral);
	public abstract void crearInteractuable(Asimilador asimilador);
	
	public abstract void crearInteractuable(AltoTemplario templario);
	public abstract void crearInteractuable(Dragon dragon);
	public abstract void crearInteractuable(Espectro espectro);
	public abstract void crearInteractuable(Golliat gollait);
	public abstract void crearInteractuable(Marine marine);
	public abstract void crearInteractuable(NaveCiencia nave);
	public abstract void crearInteractuable(NaveTransporteProtoss nave);
	public abstract void crearInteractuable(NaveTransporteTerran nave);
	public abstract void crearInteractuable(Scout scout);
	public abstract void crearInteractuable(Zealot zealot);

	
	public abstract void seleccionarCoordenada(int x, int y);
	
	public abstract void detectarMovimiento(Coordenada origen, Coordenada destino);

}
