package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fiuba.algo3.algocraft.controlador.operacionesDeVentana.CerrarFrameListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.controlador.operacionesDeVentana.UnloadDatosJugadoresListener;

public class IngresoJugadoresVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre1;
	private JTextField nombre2;
    private ComboBoxColores colorJ1;
    private ComboBoxColores colorJ2;
    private ComboBoxRazas razaJ1;
    private ComboBoxRazas razaJ2;
    private Juego modelo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			IngresoJugadoresVista dialog = new IngresoJugadoresVista();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	/**
	 * Create the dialog.
	 */
	public IngresoJugadoresVista(Juego modelo, VistaJuego vista) {
        this.modelo = modelo;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 513, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreJugador = new JLabel("Nombre Jugador 1:");
			lblNombreJugador.setBounds(10, 54, 132, 14);
			contentPanel.add(lblNombreJugador);
		}
		{
			nombre1 = new JTextField();
			nombre1.setBounds(152, 51, 86, 20);
			contentPanel.add(nombre1);
			nombre1.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			lblColor.setBounds(248, 54, 41, 14);
			contentPanel.add(lblColor);
		}
		{
			ComboBoxColores color1 = new ComboBoxColores();
			color1.setBounds(299, 51, 60, 20);
			contentPanel.add(color1);
            this.colorJ1 = color1;
		}
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(369, 54, 46, 14);
		contentPanel.add(lblRaza);
		
		ComboBoxRazas raza1 = new ComboBoxRazas();
		raza1.setBounds(406, 51, 60, 20);
		contentPanel.add(raza1);
        this.razaJ1 = raza1;
		{
			JLabel lblNombreJugador_2 = new JLabel("Nombre Jugador 2:");
			lblNombreJugador_2.setBounds(10, 114, 132, 14);
			contentPanel.add(lblNombreJugador_2);
		}
		
		nombre2 = new JTextField();
		nombre2.setColumns(10);
		nombre2.setBounds(152, 111, 86, 20);
		contentPanel.add(nombre2);
		
		JLabel label = new JLabel("Color:");
		label.setBounds(248, 114, 41, 14);
		contentPanel.add(label);
		
		ComboBoxColores color2 = new ComboBoxColores();
		color2.setBounds(299, 111, 60, 20);
		contentPanel.add(color2);
        this.colorJ2 = color2;
		
		JLabel label_1 = new JLabel("Raza:");
		label_1.setBounds(369, 114, 46, 14);
		contentPanel.add(label_1);
		
		ComboBoxRazas raza2 = new ComboBoxRazas();
		raza2.setBounds(406, 111, 60, 20);
		contentPanel.add(raza2);
        this.razaJ2 = raza2;
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
//				okButton.setActionCommand("OK");
				okButton.addActionListener(new UnloadDatosJugadoresListener(this.modelo, this, vista));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new CerrarFrameListener(this));
				buttonPane.add(cancelButton);
			}
		}
	}

    public ArrayList<Jugador> getJugadores() throws ExcepcionNombreCorto {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        jugadores.add(new Jugador(this.nombre1.getText(), this.colorJ1.getSelectedItem(), this.razaJ1.getRazaElegida()));
        jugadores.add(new Jugador(this.nombre2.getText(), this.colorJ2.getSelectedItem(), this.razaJ2.getRazaElegida()));

        return jugadores;
    }
}
