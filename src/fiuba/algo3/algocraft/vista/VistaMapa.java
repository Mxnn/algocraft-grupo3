package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
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
    private final List<JButton> listaBotones = new ArrayList<JButton>();
    private final List<JLabel> listaLabels = new ArrayList<JLabel>();
    
    private HashMap<Object, Color> coloresParcelas;
    private Representador representador;
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

		this.representador = new Representador();
		 this.setLocation(0, 0);
		 this.setSize(600,600);
		 this.setLayout(new GridLayout(columnas,filas)); 
//		 this.setLayout(new GridLayout(20,20)); //esto lo comente para poder usar el window builder
		 
		 for (int i=0;i<filas*columnas;i++){
			 
			 int y = i / columnas;
	         int x = i % columnas;
	         JButton buttonActual= new JButton();
	         listaBotones.add(buttonActual);
			 this.add(buttonActual);
			 buttonActual.addActionListener(controlador.getParcelaListener());
			 buttonActual.setMargin(new Insets(0, 0, 0, 0));
			 
		    Font font = buttonActual.getFont();
		    font = font.deriveFont(font.getSize() * 0.8f);
		    buttonActual.setFont(font);
//			 JLabel label = new JLabel();
//			 this.listaLabels.add(label);
//			 this.add(label);
			 
//			 Color color = Color.GREEN;
//			 buttonActual.setBackground(color);
		 }
		 
		 
	}

    public JButton getButton(int x, int y) {
        int index = y * this.columnas + x;
        return listaBotones.get(index);
    }
    
//    public JLabel getLabel(int x, int y) {
//        int index = y * this.columnas + x;
//        return listaLabels.get(index);
//    }
    
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

    private void escribirElemento(Object o,int x,int y){
    	JButton buttonActual = this.getButton(x, y);
    	String codigo = this.representador.getCodigo(o);
    	buttonActual.setText(codigo);

//    	JLabel label = this.getLabel(x, y);
//    	label.setText("B");
    }
    
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa {
		for(int x=0; x<this.columnas; x++){
    		for(int y=0; y<this.filas; y++){
    			Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
    			if(!parcela.estaVacia())
    				this.escribirElemento(parcela.devolverElemento(),x,y);
    		}
		}
	}
}