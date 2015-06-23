package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.util.HashMap;

import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;

public class Representador {
	private HashMap<Object, String> codigoElementos; 
	private HashMap<Object, Color> coloresParcelas;
	
	public Representador(){
		this.codigoElementos = new HashMap<Object, String>();
		this.codigoElementos.put(Barraca.class, "Ba");
		this.codigoElementos.put(CentroDeMineral.class, "C.M.");
		this.codigoElementos.put(DepositoSuministro.class, "D.S.");
		this.codigoElementos.put(Fabrica.class, "Fa");
		this.codigoElementos.put(PuertoEstelar.class, "P.E.T.");
		this.codigoElementos.put(Refineria.class, "Re");
		
		this.codigoElementos.put(Espectro.class, "Es");
		this.codigoElementos.put(Golliat.class, "Go");
		this.codigoElementos.put(Marine.class, "Ma");
		this.codigoElementos.put(NaveCiencia.class, "N.C.");
		this.codigoElementos.put(NaveTransporteTerran.class, "N.T.T.");
		
		this.codigoElementos.put(Acceso.class, "Ac");
		this.codigoElementos.put(ArchivosTemplarios.class, "Ar.T.");
		this.codigoElementos.put(Asimilador.class, "As");
		this.codigoElementos.put(NexoMineral.class, "N.M.");
		this.codigoElementos.put(Pilon.class, "Pi");
		this.codigoElementos.put(PuertoEstelarProtoss.class, "P.E.P.");
		
		this.codigoElementos.put(AltoTemplario.class, "A.T.");
		this.codigoElementos.put(Dragon.class, "Dr");
		this.codigoElementos.put(NaveTransporteProtoss.class, "N.T.P.");
		this.codigoElementos.put(Scout.class, "Sc");
		this.codigoElementos.put(Zealot.class, "Ze");

		this.coloresParcelas = new HashMap<Object, Color>();
		coloresParcelas.put(ParcelaTierra.class, Color.GREEN);
		coloresParcelas.put(ParcelaEspacio.class, Color.LIGHT_GRAY);
		coloresParcelas.put(ParcelaVolcan.class, Color.YELLOW);
		coloresParcelas.put(ParcelaMineral.class, Color.CYAN);
		
	}
	
	public String getCodigo(Object o){
		String codigo = this.codigoElementos.get(o.getClass());
		return codigo;
		
	}

	public Color getColorParcela(Object o) {
		// TODO Auto-generated method stub
		return this.coloresParcelas.get(o.getClass());
	}
}
