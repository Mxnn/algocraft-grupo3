package fiuba.algo3.algocraft.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.ParcelaListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.botones.*;

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
    private Coordenada coordenadaSeleccionada;
    private Representador representador;
	private VistaBotonInteractuable botonEnEspera = null;

	public VistaMapa(Controlador controlador, Mapa mapa) {
	    this.setVisible(false);
		this.filas=  mapa.getFilas();
		this.columnas = mapa.getColumnas();
		this.controlador = controlador;
		this.representador = new Representador();
		this.setLocation(0, 0);
		this.setSize(650,650);
		this.setLayout(new GridLayout(columnas,filas));
//		this.setLayout(new GridLayout(20,20)); //esto lo comente para poder usar el window builder

		for(int i=0;i<filas*columnas;i++) {

		    int y = i / columnas;
	        int x = i % columnas;

            VistaBotonParcela buttonActual = new VistaBotonParcela(new Coordenada(x, y));
            ParcelaListener l = controlador.getParcelaListener();
            buttonActual.addActionListener(l);
            l.setCoordenadasBoton(x,y);
	        listaBotonesParcela.add(buttonActual);
	        
//			this.add(buttonActual);

	        JPanel panelBotones = new JPanel();
	        panelBotones.setLayout(new CardLayout());
	        panelBotones.setBackground(PARCELA_TIERRA); //el mapa se crea con colores de tierra
	        this.add(panelBotones);
	        this.listaPanelesParcela.add(panelBotones);
	        panelBotones.add(buttonActual, BOTON_PARCELA);
        }
	}

    public JButton getButton(int x, int y) {
        int index = y * this.columnas + x;
        return listaBotonesParcela.get(index);
    }

    public VistaBotonInteractuable getBoton(Coordenada coordenada) {
        JPanel panel = this.getPanel(coordenada);

        return (VistaBotonInteractuable) panel.getComponent(panel.getComponentCount() - 1);
    }
    
    public JPanel getPanel(Coordenada coordenada) {
        int index = coordenada.getY() * this.columnas + coordenada.getX();

        return listaPanelesParcela.get(index);
    }

    private void pintarParcela(Coordenada coordenada, Color color){
    	JPanel panelParcela = this.getPanel(coordenada);
    	panelParcela.setBackground(color);
    }
    
    private void agregarConstruccion(VistaBotonInteractuable buttonActual){   
    	JPanel panelParcela = this.getPanel(this.coordenadaSeleccionada);
    	
//    	if(panelParcela.getComponentCount() >1){
//    		panelParcela.remove(1);
//    	}
    	
    	this.agregarBoton(buttonActual, panelParcela);
    	
    	ParcelaListener l = this.controlador.getParcelaListener();
    	l.setCoordenadasBoton(this.coordenadaSeleccionada.getX(), this.coordenadaSeleccionada.getY());
    	buttonActual.addActionListener(l);

//        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
//        CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.show(panelParcela, BOTON_INTERACTUABLE);
    }
    
    private void agregarUnidad(VistaBotonInteractuable buttonActual, Coordenada coordenada){   
    	JPanel panelParcela = this.getPanel(coordenada);
    	
//    	if(panelParcela.getComponentCount() >1){
//    		panelParcela.remove(1);
//    	}
    	
    	this.agregarBoton(buttonActual, panelParcela);
    	
    	ParcelaListener l = this.controlador.getParcelaListener();
    	l.setCoordenadasBoton(coordenada.getX(), coordenada.getY());
    	buttonActual.addActionListener(l);

//        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
//        CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.show(panelParcela, BOTON_INTERACTUABLE);
    }
    
    private void agregarBoton(VistaBotonInteractuable buttonActual, JPanel panelParcela){
    	if(!(panelParcela.getComponentCount() >1)){
//    		panelParcela.remove(1);
    	
        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
        CardLayout cl = (CardLayout) panelParcela.getLayout();
        cl.show(panelParcela, BOTON_INTERACTUABLE);
    	}
    	
    }

//    private void escribirElemento(Interactuable i,int x,int y){
//    	JButton buttonActual = this.representador.getCodigo(i);
//    	
//    	JPanel panelParcela = this.getPanel(new Coordenada(x,y));
//    	
//    	ParcelaListener l = this.controlador.getParcelaListener();
//    	l.setCoordenadasBoton(x,y);
//    	buttonActual.addActionListener(l);
//        buttonActual.setForeground(this.representador.getColorTexto(i.getPropietario()));
//        
//        if(!i.estaCreado()){
//        	buttonActual.setEnabled(false); 
//        }
//        panelParcela.add(buttonActual, BOTON_INTERACTUABLE);
//        CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.show(panelParcela, BOTON_INTERACTUABLE);
//    }
    
    private void desinscribirElemento(Coordenada coordenada){  //metodo para limpiar la parcela si la unidad se mueve en otra parcela
    	JPanel panelParcela = this.getPanel(coordenada);
    	if(panelParcela.getComponentCount() >1)
    		panelParcela.remove(1);
//    	Component boton = panelParcela.getComponent(1);
//    	CardLayout cl = (CardLayout) panelParcela.getLayout();
//        cl.removeLayoutComponent(boton);
    }
    
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa {
		//ESTO NO SE SI DA DEJARLO ASI, SE FIJA DE BORRAR PARCELAS VACIAS Y ACTIVAR BOTONES
		for(int x=0; x<this.columnas; x++){
    		for(int y=0; y<this.filas; y++){
    			Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
//    			if(!parcela.estaVacia() && (parcela.devolverElemento().getClass().getSuperclass() == Unidad.class)){
//    				this.escribirElemento(parcela.devolverElemento(),x,y);
//    			}
//    			else{
//    				this.desinscribirElemento(x, y);
//    			}
    			//VER POR QUE ESTO DA ERROR AL MOVER, SE SUPONE QUE LAS COSAS SE MUEVEN ANTES
    			if(!parcela.estaVacia() && parcela.devolverElemento().estaCreado()){
    					this.activarBoton(parcela.getCoordenada());
    			}
//    			else if(parcela.estaVacia()){
//    				this.desinscribirElemento(new Coordenada(x,y));
//    			}
    		}
		}
		this.repaint();
	}
	
	public void seleccionarCoordenada(int x, int y){
		this.coordenadaSeleccionada = new Coordenada (x,y);
		//JButton seleccionado = this.getButton(x, y);
		
	}
	
	public void activarBoton(Coordenada coordenada){
		JPanel panelParcela = this.getPanel(coordenada);
//		if(panelParcela.getComponentCount()>1){
//			Component boton = panelParcela.getComponent(1);
//			boton.setEnabled(true);
//		}
		Component boton = panelParcela.getComponent(1);
		boton.setEnabled(true);
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
	
	@Override
	public void detectarMovimiento(Coordenada origen, Coordenada destino) {
		VistaBotonInteractuable botonOrigen = this.getBoton(origen);
		this.desinscribirElemento(origen);
		botonOrigen.removeAllActionListeners();
		this.agregarUnidad(botonOrigen, destino);
	}

	private void ponerColorDeLetraAdecuado(VistaBotonInteractuable boton, Interactuable interactuable) {
        boton.setForeground(this.representador.getColorTexto(interactuable.getPropietario()));
    }

    @Override
    public void crearConstruccion(Construccion construccion) {
        VistaBotonInteractuable boton;
        try {
            Class<?> claseBoton = this.representador.getClaseBoton(construccion);
            boton = (VistaBotonInteractuable) claseBoton.getDeclaredConstructor(construccion.getClass()).newInstance(construccion);
            this.ponerColorDeLetraAdecuado(boton, construccion);

            this.botonEnEspera = boton;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearUnidad(Unidad unidad) {
        VistaBotonInteractuable boton;
        try {
            Class<?> claseBoton = this.representador.getClaseBoton(unidad);
            boton = (VistaBotonInteractuable) claseBoton.getDeclaredConstructor(unidad.getClass()).newInstance(unidad);
            this.ponerColorDeLetraAdecuado(boton, unidad);

            Coordenada coordenada = unidad.getParcela().getCoordenada();
            this.agregarUnidad(boton, coordenada);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void agregarConstruccionEnEspera() {
        if (this.botonEnEspera != null) {
            this.agregarConstruccion(this.botonEnEspera);
            this.botonEnEspera = null;
        }
    }
}