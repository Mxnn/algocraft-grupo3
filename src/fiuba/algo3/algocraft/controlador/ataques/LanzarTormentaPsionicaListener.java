package fiuba.algo3.algocraft.controlador.ataques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.comandos.AccionPorTurnoListener;
import fiuba.algo3.algocraft.controlador.comandos.ComandoAtaqueTormentaPsionica;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class LanzarTormentaPsionicaListener implements ActionListener {
    private Unidad representado;
	private AccionPorTurnoListener controladorAtacar;
	
	public LanzarTormentaPsionicaListener(Unidad representado){
		this.representado = representado;
		this.controladorAtacar = AccionPorTurnoListener.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAtacar.setUnidad(this.representado);
		this.controladorAtacar.setComando(new ComandoAtaqueTormentaPsionica());
		
	}

}
