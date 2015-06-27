package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import java.awt.event.ActionEvent;

public class CrearAdicionalDeSuministroListener extends ConstruccionListener {

	public CrearAdicionalDeSuministroListener(Juego modelo, Coordenada ubicacion) {
		super(modelo, ubicacion);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
			this.modelo.getJugadorQueJuega().crearAdicionalDeSuministro(this.modelo.getMapa(), this.ubicacion);
		} catch (ExcepcionRecursosInsuficientes e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionParcelaOcupada e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
