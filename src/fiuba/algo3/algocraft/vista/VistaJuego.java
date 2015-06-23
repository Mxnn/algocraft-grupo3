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

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

public class VistaJuego {
	Juego modelo;
	Controlador controlador;
	VistaMapa panelDeParcela;
	JFrame ventanita;
	VistaBarraLateral barraLateral;
	Coordenada coordenadaSeleccionada;
	
	public static int CANTIDAD_DE_OPCIONES = 8;
	public VistaJuego(Juego elJuego, Controlador elControlador) throws ExcepcionCoordenadaFueraDelMapa {
        this.modelo = elJuego;
        this.controlador = elControlador;

//        int columnas = this.modelo.getMapa().getColumnas();
//        int filas = this.modelo.getMapa().getFilas();

        JFrame ventanita= new JFrame("AlgoCraft");
        this.ventanita = ventanita;
        ventanita.setSize(1000,700);
        
        VistaMapa panelDeParcela = new VistaMapa(this.controlador,this.modelo.getMapa().getFilas(),this.modelo.getMapa().getColumnas());
        this.panelDeParcela = panelDeParcela;
        panelDeParcela.setBackground(new Color(240, 240, 240));
        ventanita.getContentPane().add(panelDeParcela);

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
        ventanita.getContentPane().add(barraLateral);
        this.barraLateral.setPanelAcciones(new VistaAcciones(this.modelo, this.barraLateral,this.controlador));
        ventanita.setVisible(false);
        ventanita.repaint();
	}
	
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa{
		this.panelDeParcela.refrescar(mapa);
		this.barraLateral.refrescar(this.modelo);
		this.ventanita.repaint();
//		this.barraLateral.setPanelAcciones(new VistaAcciones(this.modelo, this.barraLateral, this.controlador));//cambia dependiendo elemento seleccionado
	}

	public void inicializarMapa() throws ExcepcionCoordenadaFueraDelMapa {
        panelDeParcela.setParcelas(this.modelo.getMapa());
        ventanita.repaint();
	}

	public void seleccionarCoordenada(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
		// TODO Auto-generated method stub
		Mapa mapa = modelo.getMapa();
		Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(x,y));
		if(parcela.estaVacia()){
			this.barraLateral.setPanelAcciones(new VistaAccionesParcelaVacia(this.modelo, this.barraLateral, this.controlador));;
		}
		this.coordenadaSeleccionada = new Coordenada(x,y);
		this.refrescar(mapa);
		
	}
	public void abrirVista(){
		this.ventanita.setVisible(true);
	}
	
	public Coordenada getCoordenadaSeleccionada(){
		return this.coordenadaSeleccionada;
	}
}
