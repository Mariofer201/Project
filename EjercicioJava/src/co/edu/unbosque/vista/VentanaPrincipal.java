package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -6769638857830900014L;
	private PanelCentral panelCentral;

	public VentanaPrincipal() {
		setTitle("Crud canddatos");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {

		getContentPane().setLayout(new BorderLayout());

		panelCentral = new PanelCentral();

		getContentPane().add(panelCentral, BorderLayout.CENTER);

	}

	public PanelCentral getPanelCentral() {
		return panelCentral;
	}

	public void mostrarMensaje(String mensaje, String titulo) {
		if(titulo.equals("ERROR")) {
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public String capturarDato(String mensaje, String titulo) {
		return JOptionPane.showInputDialog(null,mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
	}

}
