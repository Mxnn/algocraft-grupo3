package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;

public class Clon extends UnidadAgresora {
	public static final int VIDA_INICIAL = 0;
	private UnidadAgresora clonado;
	
	public Clon(UnidadAgresora aClonar, Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        super(propietario, new VitalidadProtoss(0, ((VitalidadProtoss) aClonar.getVitalidad()).getEscudo()), 0, aClonar.getCupoDeTransporte(), aClonar.getVision(), 0, aClonar.getRangoAtaque(), new Danyo(0, 0), new Costo(0, 0));
        this.tiempoDeConstruccion = 0;
        this.clonado = aClonar;
	}

	public UnidadAgresora getClonado(){
		return this.clonado;
	}
	@Override
	public int seleccionarDanyo(Danyo danyo) {
		return clonado.seleccionarDanyo(danyo);
	}

	@Override
	public int seleccionarRango(RangoAtaque rango) {
		return clonado.seleccionarRango(rango);
	}

	@Override
	public void guardarEnParcela(ParcelaEspacio parcela)throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		if(!(this.cupoDeTransporte == 0))
			throw new ExcepcionElementoNoAdmitidoEnParcela();
			
		parcela.setElemento(this);
	}
}
