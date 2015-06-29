package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;

public interface ObservadorMapa {
	public void crearVistaParcela(ParcelaEspacio parcela);
	public void crearVistaParcela(ParcelaMineral parcela);
	public void crearVistaParcela(ParcelaVolcan parcela);

    public void agregarConstruccionEnEspera();

	public void crearInteractuable(ArchivosTemplarios archivo);
	public void crearInteractuable(PuertoEstelar puertoEstelar);
	public void crearInteractuable(Fabrica fabrica);
	public void crearInteractuable(Barraca barraca);
	public void crearInteractuable(DepositoSuministro depositoSuministro);
	public void crearInteractuable(CentroDeMineral centroDeMineral);
	public void crearInteractuable(Refineria refineria);
	public void crearInteractuable(PuertoEstelarProtoss puerto);
	public void crearInteractuable(Acceso acceso);
	public void crearInteractuable(Pilon pilon);
	public void crearInteractuable(NexoMineral nexoMineral);
	public void crearInteractuable(Asimilador asimilador);
	
	public void crearInteractuable(AltoTemplario templario);
	public void crearInteractuable(Dragon dragon);
	public void crearInteractuable(Espectro espectro);
	public void crearInteractuable(Golliat gollait);
	public void crearInteractuable(Marine marine);
	public void crearInteractuable(NaveCiencia nave);
	public void crearInteractuable(NaveTransporteProtoss nave);
	public void crearInteractuable(NaveTransporteTerran nave);
	public void crearInteractuable(Scout scout);
	public void crearInteractuable(Zealot zealot);

	public void seleccionarCoordenada(int x, int y);
	
	public void detectarMovimiento(Coordenada origen, Coordenada destino);
}
