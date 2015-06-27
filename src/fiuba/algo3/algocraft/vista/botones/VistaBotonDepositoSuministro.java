package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;


public class VistaBotonDepositoSuministro extends VistaBotonInteractuable {
	private DepositoSuministro representador;

	public VistaBotonDepositoSuministro(DepositoSuministro depositoSuministro){
		super();
		this.setText("DS");
		this.representador = depositoSuministro;
	}
}
