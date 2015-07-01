package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Clon;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonClon extends VistaBotonRepresentante {
//	private String codigoClonado;
//	private String nombreClonado;
	
	public VistaBotonClon(Clon clon, VistaBotonInteractuable botonAClonar) {
		super(clon,botonAClonar.getCodigo(), botonAClonar.getNombre());
//		this.codigoClonado = botonAClonar.getCodigo();
//		this.nombreClonado = botonAClonar.getNombre();
		this.setText(this.codigo);
	}
	
    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Clon representado = (Clon) this.elementoRepresentado;

    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(this.nombre);

    	vistaAcciones.setVida(Clon.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoInicial = ((VitalidadProtoss) representado.getClonado().getVitalidad()).getEscudo();
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(escudoInicial, escudoActual);
    	
        return vistaAcciones;
    }
}
