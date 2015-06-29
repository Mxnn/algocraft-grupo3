package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class ControladorAtacar {
	private static ControladorAtacar INSTANCIA = null;

	private Unidad unidad;
	private ComandoAtaque comando;
	
    public ControladorAtacar() {
    	

	}

	public static ControladorAtacar createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorAtacar();
        }

        return INSTANCIA;
    }
	
    public static ControladorAtacar getInstance() {
        return INSTANCIA;
    }
    
    public void setComando(ComandoAtaque comando){
    	this.comando = comando;
    }
    
    public void setUnidad(Unidad representado){
    	this.unidad = representado;
    }
    
    public void atacar(Mapa mapa, Coordenada target) throws ExcepcionEnergiaInsuficiente{
    	try {
    		if(this.unidad != null){
    			this.comando.ejectutar(this.unidad, mapa, target);
    			this.unidad = null;
    		}
		}  catch (ExcepcionEnemigoFueraDeAlcance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionEstadoMuerto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
