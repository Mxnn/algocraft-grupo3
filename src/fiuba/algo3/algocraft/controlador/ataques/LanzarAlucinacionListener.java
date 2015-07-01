package fiuba.algo3.algocraft.controlador.ataques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.comandos.AccionPorTurnoListener;
import fiuba.algo3.algocraft.controlador.comandos.ComandoAlucinacion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class LanzarAlucinacionListener implements ActionListener {
    private Unidad representado;
	private AccionPorTurnoListener accionPorTurnoListener;
	
	public LanzarAlucinacionListener(Unidad representado){
		this.representado = representado;
		this.accionPorTurnoListener = AccionPorTurnoListener.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.accionPorTurnoListener.setUnidad(this.representado);
		this.accionPorTurnoListener.setComando(new ComandoAlucinacion());

	}

}
