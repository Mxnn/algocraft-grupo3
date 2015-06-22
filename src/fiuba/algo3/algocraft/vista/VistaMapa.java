package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.GridLayout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;

public class VistaMapa extends JPanel {
	private static final char GREEN = 0;
	private int filas;
	private int columnas;
    private final List<JButton> list = new ArrayList<JButton>();
    private HashMap<Object, Color> coloresParcelas;
	/**
	 * Create the panel.
	 */
	public VistaMapa(Controlador controlador, int filas, int columnas) {
		this.filas= filas;
		this.columnas = columnas;
		this.coloresParcelas = new HashMap<Object, Color>();
		coloresParcelas.put(ParcelaTierra.class, Color.GREEN);
		coloresParcelas.put(ParcelaEspacio.class, Color.LIGHT_GRAY);
		coloresParcelas.put(ParcelaVolcan.class, Color.YELLOW);
		coloresParcelas.put(ParcelaMineral.class, Color.CYAN);

		 this.setLocation(0, 0);
		 this.setSize(500,500);
//		 panelDeParcela.setLayout(new GridLayout(columnas,filas)); esto lo comente para poder usar el window builder
		 this.setLayout(new GridLayout(20,20));
		 
		 for (int i=0;i<filas*columnas;i++){
			 
			 int y = i / columnas;
	         int x = i % columnas;
	         JButton buttonActual= new JButton();
			 list.add(buttonActual);
			 this.add(buttonActual);
			 buttonActual.addActionListener(controlador.getParcelaListener());
			 Color color = Color.GREEN;
			 buttonActual.setBackground(color);
		 }
	}

    public JButton getButton(int x, int y) {
        int index = x * this.columnas + y;
        return list.get(index);
    }
    
    public void setParcelas(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa{
    	for(int x=0; x<this.columnas; x++){
    		for(int y=0; y<this.filas; y++){
    			this.pintarBoton(mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y)),x,y);
    		}
    	}
    }
    /// lo hice asi porque lo dijeron en clase, que conste jaja
    private void pintarBoton(Object o,int x,int y){
    	Color color = this.coloresParcelas.get(o.getClass());
    	JButton buttonActual = this.getButton(x, y);
    	buttonActual.setBackground(color);
    }
}
