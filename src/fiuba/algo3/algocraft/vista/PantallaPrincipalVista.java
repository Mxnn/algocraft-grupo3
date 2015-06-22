package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;
import fiuba.algo3.algocraft.controlador.IniciarNuevoJuegoListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import javax.swing.*;

public class PantallaPrincipalVista extends JFrame {
    private Juego modelo;
    private JPanel panelPrincipal;
    private JButton botonIniciar;

    public PantallaPrincipalVista(Juego modelo) {
        //Configurando la ventana
        super("AlgoCraft");
        this.setContentPane(panelPrincipal);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        //Agregando barra de menu
        JMenuBar menuBar = new JMenuBar();
        //Menu archivo
        JMenu menuArchivo = new JMenu("Archivo");
        //JMenuItem iIniciarJuego = new JMenuItem("Iniciar nuevo juego");
        JMenuItem iSalir = new JMenuItem("Salir");
        //menuArchivo.add(iIniciarJuego);
        menuArchivo.add(iSalir);

        //Menu Acerca de
        JMenu menuAcercaDe = new JMenu("Acerca de..");
        JMenuItem iCreadores = new JMenuItem("Creadores");
        menuAcercaDe.add(iCreadores);

        menuBar.add(menuArchivo);
        menuBar.add(menuAcercaDe);

        this.setJMenuBar(menuBar);
        this.setVisible(true);

        this.modelo = modelo;

        //Controladores de botones
        this.botonIniciar.addActionListener(new IniciarNuevoJuegoListener(this.modelo));
        iSalir.addActionListener(new CerrarFrameControlador(this));
    }


}
