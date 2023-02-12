package co.edu.unbosque.vista;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelCentral extends JPanel {

	private static final long serialVersionUID = -3058875128977026240L;
	private PanelDatos panelDatos;
	private PanelBotones panelBotones;

	public PanelCentral() {
		setLayout(new GridLayout(1, 2, 15, 15));
		inicializarComponentes();
		setVisible(true);
	}

	public void inicializarComponentes() {

		// PANEL INFORMACION
		panelDatos = new PanelDatos();

		// PANEL BOTONES
		panelBotones = new PanelBotones();

		add(panelDatos);
		add(panelBotones);

	}

	public PanelDatos getPanelDatos() {
		return panelDatos;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}
}
