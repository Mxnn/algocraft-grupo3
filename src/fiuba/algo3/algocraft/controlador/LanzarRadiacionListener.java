package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class LanzarRadiacionListener implements ActionListener {
    private Unidad representado;
	private ControladorAtacar controladorAtacar;
	
	public LanzarRadiacionListener(Unidad representado){
		this.representado = representado;
		this.controladorAtacar = ControladorAtacar.createInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAtacar.setUnidad(this.representado);
		this.controladorAtacar.setComando(new ComandoAtaqueRadiacion());
		
	}

}
