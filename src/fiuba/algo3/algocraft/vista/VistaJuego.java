package fiuba.algo3.algocraft.vista;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.controlador.CerrarFrameListener;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CreadoresListener;
import fiuba.algo3.algocraft.controlador.NuevoJuegoListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.vista.acciones.VistaAcciones;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.util.ArrayList;

public class VistaJuego implements ObservadorJuego {
    private static VistaJuego INSTANCIA = null;

	private Juego modelo;
    private VistaMapa vistaMapa;
    private JFrame ventanaPrincipal;
    private VistaBarraLateral barraLateral;
    private Coordenada coordenadaSeleccionada;
    private ArrayList<String> errores = new ArrayList<String>();

	public static int CANTIDAD_DE_OPCIONES = 8;

    public static VistaJuego createInstance(Juego juego, Controlador controlador) {
        if (INSTANCIA == null) {
            INSTANCIA = new VistaJuego(juego, controlador);
        }

        return INSTANCIA;
    }

    public static VistaJuego getInstance() {
        return INSTANCIA;
    }

	private VistaJuego(Juego elJuego, Controlador controlador)  {
        this.modelo = elJuego;

        JFrame ventanaPrincipal= new JFrame("AlgoCraft");
        this.ventanaPrincipal = ventanaPrincipal;
        ventanaPrincipal.setSize(1024,778);
        
        VistaMapa vistaMapa = new VistaMapa(controlador ,this.modelo.getMapa());
        this.vistaMapa = vistaMapa;
        vistaMapa.setBackground(new Color(240, 240, 240));
        ventanaPrincipal.getContentPane().add(vistaMapa);

        ventanaPrincipal.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        ventanaPrincipal.setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo Juego");
        mnArchivo.add(mntmNuevoJuego);
        mntmNuevoJuego.addActionListener(new NuevoJuegoListener(this.modelo, this));
        JMenuItem mntmSalir = new JMenuItem("Salir");
        mnArchivo.add(mntmSalir);
        mntmSalir.addActionListener(new CerrarFrameListener(ventanaPrincipal));

        JMenu mnAcerca = new JMenu("Acerca De..");
        JMenuItem iCreadores = new JMenuItem("Creadores");
        mnAcerca.add(iCreadores);
        iCreadores.addActionListener(new CreadoresListener());        
        JMenuItem iReferencias = new JMenuItem("Referencias");
        mnAcerca.add(iReferencias);

        menuBar.add(mnArchivo);
        menuBar.add(mnAcerca);

        //esto habria que [ponerlo cuando se inicie el juego pero lo pongo aca para probar
//        panelDeParcela.setParcelas(this.modelo.getMapa());

        this.barraLateral = new VistaBarraLateral(this.modelo);
        this.barraLateral.setLocation(666, 0);
        ventanaPrincipal.getContentPane().add(this.barraLateral);
        this.barraLateral.setPanelAcciones(new VistaAcciones(this.modelo));
        
        ventanaPrincipal.setVisible(false);
        ventanaPrincipal.repaint();
        //sacar de aca despues
	}
	
	public ObservadorMapa getObservadorMapa(){
		return this.vistaMapa;
	}

    public ObservadorJugador getObservadorJugador() {
        return this.barraLateral;
    }
	
	public void refrescar() throws ExcepcionCoordenadaFueraDelMapa {
		Mapa mapa = this.modelo.getMapa();
		this.vistaMapa.refrescar(mapa);
		this.vistaMapa.setVisible(true);
		this.barraLateral.refrescar();
		this.ventanaPrincipal.repaint();
		this.barraLateral.setPanelAcciones(new VistaAcciones(this.modelo));//cambia dependiendo elemento seleccionado
	}

//	public void inicializarMapa() throws ExcepcionCoordenadaFueraDelMapa {
//		vistaMapa.setParcelas(this.modelo.getMapa());
//        ventanaPrincipal.repaint();
//	}

	public void seleccionarCoordenada(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
		/*Mapa mapa = modelo.getMapa();
		Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
		//es un asco esto pero bueno, despues cambiamos
		if(parcela.estaVacia()){
			this.barraLateral.setPanelAcciones(new VistaAccionesParcelaVacia(this.modelo));;
		}else{
			Object o = parcela.devolverElemento();
			VistaAcciones vistaActual = this.getVistaElemento(o.getClass());
			if(vistaActual == null){
				vistaActual = this.getVistaElemento(o.getClass().getSuperclass());
			}
			this.barraLateral.setPanelAcciones(vistaActual);
		}*/
        VistaAcciones vistaDelBoton = this.vistaMapa.getBoton(new Coordenada(x, y)).getVistaDeAcciones(this.modelo);
        this.barraLateral.setPanelAcciones(vistaDelBoton);
		this.coordenadaSeleccionada = new Coordenada(x,y);
        this.ventanaPrincipal.repaint();
	}

	public void abrirVista() throws ExcepcionCoordenadaFueraDelMapa {
		this.ventanaPrincipal.setVisible(true);
	}
	
	public Coordenada getCoordenadaSeleccionada(){
		return this.coordenadaSeleccionada;
	}
	
	public void displayError(String msg){
		this.errores.clear();
		this.errores.add(msg);
		this.barraLateral.displayErrores(this.errores);
		this.errores.clear();
		this.ventanaPrincipal.repaint();
	}

	public void nuevoTurno() {
		this.barraLateral.borrarErrores();
		if(!this.errores.isEmpty()){
			this.barraLateral.displayErrores(this.errores);
			this.errores.clear();
		}
		this.refrescar();
	}

	public void hayPerdedor(Jugador perdedor) {
		// TODO Auto-generated method stub
		//PONER CODIGO QUE MUESTRE UNA VENTANA O ALGO
	}

	@Override
	public void encolarError(Exception error) {
		this.errores.add(error.getMessage());
	}
}
