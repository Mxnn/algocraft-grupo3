package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAcciones;
import fiuba.algo3.algocraft.vista.acciones.unidades.VistaAccionesAltoTemplario;

public class VistaBotonAltoTemplario extends VistaBotonRepresentante {
	public static final String CODIGO = "AlT";
	public static final String NOMBRE = "Alto Templario";
	
	public VistaBotonAltoTemplario(AltoTemplario templario){
		super(templario, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	AltoTemplario representado = (AltoTemplario) this.elementoRepresentado;
    	
    	VistaAccionesAltoTemplario vistaAcciones = new VistaAccionesAltoTemplario(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);   	
    	
    	vistaAcciones.setVida(AltoTemplario.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(AltoTemplario.ESCUDO_INICIAL, escudoActual);
    	
    	vistaAcciones.setEnergia(AltoTemplario.ENERGIA_MAXIMA, representado.getEnergia());
    	
    	
        return vistaAcciones;
    }
}

