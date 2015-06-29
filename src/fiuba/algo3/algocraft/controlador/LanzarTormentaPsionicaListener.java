package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class LanzarTormentaPsionicaListener implements ActionListener {
    private Unidad representado;
	private ControladorAccionPorTurno controladorAtacar;
	
	public LanzarTormentaPsionicaListener(Unidad representado){
		this.representado = representado;
		this.controladorAtacar = ControladorAccionPorTurno.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAtacar.setUnidad(this.representado);
		this.controladorAtacar.setComando(new ComandoAtaqueTormentaPsionica());
		
	}

}
