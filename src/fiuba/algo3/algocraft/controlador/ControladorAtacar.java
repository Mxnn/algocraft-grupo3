package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class ControladorAtacar {
	private static ControladorAtacar INSTANCIA = null;
	private Juego juego;
	private UnidadAgresora unidad;
    public ControladorAtacar(Juego juego) {
		this.juego = juego;
	}

	public static ControladorAtacar createInstance(Juego juego) {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorAtacar(juego);
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
			this.unidad.atacar(this.juego.getMapa().obtenerParcelaEnCoordenada(target));
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionEnemigoFueraDeAlcance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionEstadoMuerto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
