package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class CrearExtractorMineralListener extends ConstruccionListener {
	public CrearExtractorMineralListener(Juego modelo, Coordenada ubicacion) {
		super(modelo, ubicacion);
	}

    @Override
    public void actionPerformed(ActionEvent e){
			try {
				this.modelo.getJugadorQueJuega().crearExtractorMineral(this.modelo.getMapa(), this.ubicacion);
			} catch (ExcepcionCoordenadaFueraDelMapa e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExcepcionRecursosInsuficientes e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExcepcionParcelaOcupada e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    }
}