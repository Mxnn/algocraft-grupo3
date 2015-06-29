package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonDepositoSuministro extends VistaBotonRepresentante {
    public static final String CODIGO = "DS";
    public static final String NOMBRE = "Deposito de Suministro";

	public VistaBotonDepositoSuministro(DepositoSuministro depositoSuministro){
		super(depositoSuministro);
		this.setText("DS");
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(DepositoSuministro.VIDA_INICIAL, this.elementoRepresentado.getVida());

        return vistaAcciones;
    }
}
