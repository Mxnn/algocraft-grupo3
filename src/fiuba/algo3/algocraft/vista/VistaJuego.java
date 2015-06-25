package fiuba.algo3.algocraft.vista;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.NuevoJuegoListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.HashMap;

public class VistaJuego {

	Juego modelo;
	Controlador controlador;
	VistaMapa vistaMapa;
	JFrame ventanita;
	VistaBarraLateral barraLateral;
	Coordenada coordenadaSeleccionada;
	private HashMap<Class, VistaAcciones> vistasAcciones;
	
	
	public static int CANTIDAD_DE_OPCIONES = 8;
	public VistaJuego(Juego elJuego, Controlador elControlador) throws ExcepcionCoordenadaFueraDelMapa {
        this.modelo = elJuego;
        this.controlador = elControlador;

//        int columnas = this.modelo.getMapa().getColumnas();
//        int filas = this.modelo.getMapa().getFilas();

        JFrame ventanita= new JFrame("AlgoCraft");
        this.ventanita = ventanita;
        ventanita.setSize(1000,700);
        
        VistaMapa vistaMapa = new VistaMapa(this.controlador,this.modelo.getMapa().getFilas(),this.modelo.getMapa().getColumnas());
        this.vistaMapa = vistaMapa;
        vistaMapa.setBackground(new Color(240, 240, 240));
        ventanita.getContentPane().add(vistaMapa);

        ventanita.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        ventanita.setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo Juego");
        mnArchivo.add(mntmNuevoJuego);
        mntmNuevoJuego.addActionListener(new NuevoJuegoListener(this.modelo, this));
        JMenuItem mntmSalir = new JMenuItem("Salir");
        mnArchivo.add(mntmSalir);
        mntmSalir.addActionListener(new CerrarFrameControlador(ventanita));

        JMenu mnAcerca = new JMenu("Acerca De..");
        JMenuItem iCreadores = new JMenuItem("Creadores");
        mnAcerca.add(iCreadores);
        JMenuItem iReferencias = new JMenuItem("Referencias");
        mnAcerca.add(iReferencias);

        menuBar.add(mnArchivo);
        menuBar.add(mnAcerca);

        //esto habria que [ponerlo cuando se inicie el juego pero lo pongo aca para probar
//        panelDeParcela.setParcelas(this.modelo.getMapa());

        this.barraLateral = new VistaBarraLateral(this.controlador);
        barraLateral.setLocation(666, 0);
        ventanita.getContentPane().add(barraLateral);
        this.barraLateral.setPanelAcciones(new VistaAcciones(this.controlador));
        
        ventanita.setVisible(false);
        ventanita.repaint();
        //sacar de aca despues
		this.vistasAcciones = new HashMap<Class, VistaAcciones>();
		this.vistasAcciones.put(Barraca.class, new VistaAccionesBarraca(controlador));
		this.vistasAcciones.put(Fabrica.class, new VistaAccionesFabrica(controlador));
		this.vistasAcciones.put(NaveCiencia.class, new VistaAccionesNaveCiencia(controlador));
		this.vistasAcciones.put(AltoTemplario.class, new VistaAccionesAltoTemplario(controlador));
		this.vistasAcciones.put(UnidadAgresora.class, new VistaAccionesUnidadAgresora(controlador));
		this.vistasAcciones.put(PuertoEstelar.class, new VistaAccionesPuertoEstelar(controlador));
		this.vistasAcciones.put(Acceso.class, new VistaAccionesAcceso(controlador));
		this.vistasAcciones.put(PuertoEstelarProtoss.class, new VistaAccionesPuertoEstelarProtoss(controlador));
		this.vistasAcciones.put(ArchivosTemplarios.class, new VistaAccionesArchivosTemplarios(controlador));
	}
	
	public ObservadorMapa getObservadorMapa(){
		return this.vistaMapa;
	}
	
	public void refrescar() throws ExcepcionCoordenadaFueraDelMapa{
		Mapa mapa = this.modelo.getMapa();
		this.vistaMapa.refrescar(mapa);
		this.vistaMapa.setVisible(true);
		this.barraLateral.refrescar(this.modelo);
		this.ventanita.repaint();
		this.barraLateral.setPanelAcciones(new VistaAcciones(this.controlador));//cambia dependiendo elemento seleccionado
	}

//	public void inicializarMapa() throws ExcepcionCoordenadaFueraDelMapa {
//		vistaMapa.setParcelas(this.modelo.getMapa());
//        ventanita.repaint();
//	}

	public void seleccionarCoordenada(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
		// TODO Auto-generated method stub
		Mapa mapa = modelo.getMapa();
		Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
		//es un asco esto pero bueno, despues cambiamos
		if(parcela.estaVacia()){
			this.barraLateral.setPanelAcciones(new VistaAccionesParcelaVacia(this.controlador));;
		}else{
			Object o = parcela.devolverElemento();
			VistaAcciones vistaActual = this.getVistaElemento(o.getClass());
			if(vistaActual == null){
				vistaActual = this.getVistaElemento(o.getClass().getSuperclass());
			}
			this.barraLateral.setPanelAcciones(vistaActual);
		}
		this.coordenadaSeleccionada = new Coordenada(x,y);
		ventanita.repaint();
		
	}
	public void abrirVista() throws ExcepcionCoordenadaFueraDelMapa{
		this.ventanita.setVisible(true);
	}
	
	public Coordenada getCoordenadaSeleccionada(){
		return this.coordenadaSeleccionada;
	}
	
	public void displayError(String msg){
		this.barraLateral.displayError(msg);
		this.ventanita.repaint();
	}
	
	private VistaAcciones getVistaElemento(Class c){
		return this.vistasAcciones.get(c);
	}
}
