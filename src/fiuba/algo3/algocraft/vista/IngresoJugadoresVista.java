package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;

public class IngresoJugadoresVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre1;
	private JTextField nombre2;

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
	public IngresoJugadoresVista() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreJugador = new JLabel("Nombre Jugador 1:");
			lblNombreJugador.setBounds(10, 13, 101, 14);
			contentPanel.add(lblNombreJugador);
		}
		{
			nombre1 = new JTextField();
			nombre1.setBounds(121, 10, 86, 20);
			contentPanel.add(nombre1);
			nombre1.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			lblColor.setBounds(217, 13, 41, 14);
			contentPanel.add(lblColor);
		}
		{
			JComboBox color1 = new JComboBox();
			color1.setBounds(268, 10, 28, 20);
			contentPanel.add(color1);
		}
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(306, 13, 46, 14);
		contentPanel.add(lblRaza);
		
		JComboBox raza1 = new JComboBox();
		raza1.setBounds(362, 10, 28, 20);
		contentPanel.add(raza1);
		{
			JLabel lblNombreJugador_2 = new JLabel("Nombre Jugador 2:");
			lblNombreJugador_2.setBounds(10, 62, 101, 14);
			contentPanel.add(lblNombreJugador_2);
		}
		
		nombre2 = new JTextField();
		nombre2.setColumns(10);
		nombre2.setBounds(121, 59, 86, 20);
		contentPanel.add(nombre2);
		
		JLabel label = new JLabel("Color:");
		label.setBounds(217, 62, 41, 14);
		contentPanel.add(label);
		
		JComboBox color2 = new JComboBox();
		color2.setBounds(268, 59, 28, 20);
		contentPanel.add(color2);
		
		JLabel label_1 = new JLabel("Raza:");
		label_1.setBounds(306, 62, 46, 14);
		contentPanel.add(label_1);
		
		JComboBox raza2 = new JComboBox();
		raza2.setBounds(362, 59, 28, 20);
		contentPanel.add(raza2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new CerrarFrameControlador(this));
				buttonPane.add(cancelButton);
			}
		}
	}
}
