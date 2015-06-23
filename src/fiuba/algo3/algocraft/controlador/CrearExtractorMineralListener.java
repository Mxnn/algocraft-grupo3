package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;

public class CrearExtractorMineralListener implements ActionListener {
	private Controlador controlador;
	public CrearExtractorMineralListener(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			controlador.crearExtractorMineral();
		} catch (ExcepcionRecursosInsuficientes e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e1) {
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
