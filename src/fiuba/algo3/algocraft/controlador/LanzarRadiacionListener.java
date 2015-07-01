package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.comandos.ComandoAtaqueRadiacion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class LanzarRadiacionListener implements ActionListener {
    private Unidad representado;
	private ControladorAccionPorTurno controladorAccionPorTurno;
	
	public LanzarRadiacionListener(Unidad representado){
		this.representado = representado;
		this.controladorAccionPorTurno = ControladorAccionPorTurno.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAccionPorTurno.setUnidad(this.representado);
		this.controladorAccionPorTurno.setComando(new ComandoAtaqueRadiacion());
		
	}

}
