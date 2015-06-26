package fiuba.algo3.algocraft.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.ParcelaListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.vista.botones.VistaBotonInteractuable;

public class VistaMapa extends JPanel implements ObservadorMapa{
	public static final Color PARCELA_TIERRA = Color.lightGray;
    public static final Color PARCELA_ESPACIO = Color.black;
    public static final Color PARCELA_MINERAL = new Color(0x80C0D2);
    public static final Color PARCELA_VOLCAN = new Color(0xA47861);
    
    public static final String BOTON_PARCELA = "botonParcela";
    public static final String BOTON_INTERACTUABLE = "botonInteractuable";
    
	private int filas;
	private int columnas;
    private final List<JButton> listaBotonesParcela = new ArrayList<JButton>();
    private final List<JPanel> listaPanelesParcela = new ArrayList<JPanel>();
    private Controlador controlador;
    
    private Representador representador;
	/**
	 * Create the panel.
	 */
	public VistaMapa(Controlador controlador, int filas, int columnas) {
		this.setVisible(false);
		this.filas= filas;
		this.columnas = columnas;
		this.controlador = controlador;
		this.representador = new Representador();
		 this.setLocation(0, 0);
		 this.setSize(650,650);
		 this.setLayout(new GridLayout(columnas,filas)); 
//		 this.setLayout(new GridLayout(20,20)); //esto lo comente para poder usar el window builder
		 
		 for (int i=0;i<filas*columnas;i++){
			 
			 int y = i / columnas;
	         int x = i % columnas;
	         
	         JButton buttonActual= new JButton();
	         buttonActual.setOpaque(false);
	         buttonActual.setContentAreaFilled(false);
//	         buttonActual.setBorderPainted(false);
	         listaBotonesParcela.add(buttonActual);
//			 this.add(buttonActual);
	         
	         JPanel panelBotones = new JPanel();
	         panelBotones.setLayout(new CardLayout());
	         panelBotones.setBackground(PARCELA_TIERRA); //el mapa se crea con colores de tierra
	         this.add(panelBotones);
	         this.listaPanelesParcela.add(panelBotones);
	         panelBotones.add(buttonActual, BOTON_PARCELA);
//	         panelBotones.setVisible(true);
	         
	         
	         
			 ParcelaListener l = controlador.getParcelaListener();
			 buttonActual.addActionListener(l);
			 l.setCoordenadasBoton(x,y);
			 buttonActual.setMargin(new Insets(0, 0, 0, 0));
			 buttonActual.setBorder(BorderFactory.createLineBorder(Color.black));
			 
//			 buttonActual.setBorder(null); //sin bordes es otra opcion
			 
		    Font font = buttonActual.getFont();
		    font = font.deriveFont(font.getSize() * 0.8f);
		    buttonActual.setFont(font);

		 }
		 
		 
	}

    public JButton getButton(int x, int y) {
        int index = y * this.columnas + x;
        return listaBotonesParcela.get(index);
    }
    
    public JPanel getPanel(int x, int y) {
        int index = y * this.columnas + x;
        return listaPanelesParcela.get(index);
    }
    

    private void pintarParcela(Coordenada coordenada, Color color){
		int x = coordenada.getX();
		int y = coordenada.getY();
    	JPanel panelParcela = this.getPanel(x, y);
    	panelParcela.setBackground(color);
    }

    private void escribirElemento(Interactuable i,int x,int y){
    	String codigo = this.representador.getCodigo(i);
    	
    	JPanel panelParcela = this.getPanel(x, y);
    	
    	VistaBotonInteractuable buttonActual = new VistaBotonInteractuable();
    	ParcelaListener l = this.controlador.getParcelaListener();
    	l.setCoordenadasBoton(x,y);
    	buttonActual.addActionListener(l);
    	buttonActual.setText(codigo);
        buttonActual.setForeground(this.representador.getColorTexto(i.getPropietario()));
        
        if(!i.estaCreado()){
        	buttonActual.setEnabled(false); 
        }
        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
        CardLayout cl = (CardLayout) panelParcela.getLayout();
        cl.show(panelParcela, BOTON_INTERACTUABLE);
    }
    
    private void desinscribirElemento(int x, int y){  //metodo para limpiar la parcela si la unidad se mueve en otra parcela
    	JPanel panelParcela = this.getPanel(x, y);
    	if(panelParcela.getComponentCount() >1)
    		panelParcela.remove(1);
//    	Component boton = panelParcela.getComponent(1);
//    	CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.removeLayoutComponent(boton);
    }
    
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa {
		for(int x=0; x<this.columnas; x++){
    		for(int y=0; y<this.filas; y++){
    			Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
    			if(!parcela.estaVacia()){
    				this.escribirElemento(parcela.devolverElemento(),x,y);
    			}
    			else{
    				this.desinscribirElemento(x, y);
    			}
    		}
		}
		this.repaint();
	}

	@Override
	public void crearVistaParcela(ParcelaEspacio parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_ESPACIO);
	}

	@Override
	public void crearVistaParcela(ParcelaMineral parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_MINERAL);
	}

	@Override
	public void crearVistaParcela(ParcelaVolcan parcela) {
		this.pintarParcela(parcela.getCoordenada(), PARCELA_VOLCAN);
	}
}