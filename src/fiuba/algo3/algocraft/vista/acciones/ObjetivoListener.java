package fiuba.algo3.algocraft.vista.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.ControladorAtacar;
import fiuba.algo3.algocraft.controlador.ControladorMover;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;

public class ObjetivoListener implements ActionListener {
	private ControladorAtacar controladorAtacar;
	private Coordenada ubicacion;
	
	public ObjetivoListener(Mapa mapa,Coordenada ubicacionParcela){
//		this.modelo = modelo;
		this.ubicacion = ubicacionParcela;
		this.controladorAtacar = ControladorAtacar.createInstance(mapa);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorAtacar.atacar(this.ubicacion);

	}

}
