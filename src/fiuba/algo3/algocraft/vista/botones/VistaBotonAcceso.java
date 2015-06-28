package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesAcceso;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;

public class VistaBotonAcceso extends VistaBotonRepresentante {
	public static final String CODIGO = "Ac";
	public static final String NOMBRE = "Acceso";
	
	public VistaBotonAcceso(Acceso acceso){
		super(acceso);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesAcceso getVistaDeAcciones(Juego modelo) {
    	Acceso representado = (Acceso) this.elementoRepresentado;
    	
    	VistaAccionesAcceso vistaAcciones = new VistaAccionesAcceso(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(representado.ESCUDO_INICIAL, escudoActual);
    	
        return vistaAcciones;
    }
}
