package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;

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
	public abstract void seleccionarCoordenada(int x, int y);
}
