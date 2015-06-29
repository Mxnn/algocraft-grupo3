package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public interface ObservadorMapa {
	public void crearVistaParcela(ParcelaEspacio parcela);
	public void crearVistaParcela(ParcelaMineral parcela);
	public void crearVistaParcela(ParcelaVolcan parcela);

    public void agregarConstruccionEnEspera();

    public void crearConstruccion(Construccion construccion);
    public void crearUnidad(Unidad unidad);

	public void seleccionarCoordenada(int x, int y);
	
	public void detectarMovimiento(Coordenada origen, Coordenada destino);
}
