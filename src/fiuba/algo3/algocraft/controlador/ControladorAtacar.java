package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class ControladorAtacar {
	private static ControladorAtacar INSTANCIA = null;
	private Mapa mapa;
	private UnidadAgresora unidad;
    public ControladorAtacar(Mapa mapa) {
		this.mapa = mapa;
	}

	public static ControladorAtacar createInstance(Mapa mapa) {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorAtacar(mapa);
        }

        return INSTANCIA;
    }
	
    public static ControladorAtacar getInstance() {
        return INSTANCIA;
    }
    
    public void setUnidad(UnidadAgresora unidad){
    	this.unidad = unidad;
    }
    
    public void atacar(Coordenada target){
    	try {
			this.unidad.atacar(this.mapa.obtenerParcelaEnCoordenada(target));
		}  catch (ExcepcionEnemigoFueraDeAlcance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionEstadoMuerto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
