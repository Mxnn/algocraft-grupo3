package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class LanzarAlucinacionListener implements ActionListener {
    private Unidad representado;
	private ControladorAccionPorTurno controladorAccionPorTurno;
	
	public LanzarAlucinacionListener(Unidad representado){
		this.representado = representado;
		this.controladorAccionPorTurno = ControladorAccionPorTurno.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAccionPorTurno.setUnidad((AltoTemplario)this.representado);
		this.controladorAccionPorTurno.setComando(new ComandoAlucinacion());

	}

}
