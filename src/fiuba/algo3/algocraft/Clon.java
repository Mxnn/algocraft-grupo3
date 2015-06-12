package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public class Clon extends UnidadAgresora {
		private UnidadAgresora original;
	
	public Clon(UnidadAgresora aClonar, Jugador propietario){
		this.vitalidad =  new VitalidadProtoss(0, ((VitalidadProtoss) aClonar.getVitalidad()).getEscudo());
		this.rangoAtaque = aClonar.obtenerRangoAtaque();
		this.danyo = new Danyo(0,0);
		this.cupoDeTransporte = aClonar.obtenerCupoDeTransporte();
		this.propietario = propietario;
	}

	@Override
	protected int seleccionarDanyo(Danyo danyo) {
		return original.seleccionarDanyo(danyo);
	}

	@Override
	protected int seleccionarRango(RangoAtaque rango) {
		return original.seleccionarRango(rango);
	}


	@Override
	public void guardarEnParcela(ParcelaEspacio parcela)throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		if(!(this.cupoDeTransporte == 0))
			throw new ExcepcionElementoNoAdmitidoEnParcela();
			
		parcela.setElemento(this);
	}


}
