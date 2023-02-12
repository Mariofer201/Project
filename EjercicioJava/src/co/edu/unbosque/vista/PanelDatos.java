package co.edu.unbosque.vista;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatos extends JPanel {

	private static final long serialVersionUID = -4960654057639610529L;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblCedula;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCedula;
	private JLabel lblApellido;
	private JLabel lblCargo;
	private JTextField txtApellido;
	private JTextField txtCargo;

	public PanelDatos() {
		setLayout(new GridLayout(3, 2, 8, 8));
		inicializarComponentes();
		setVisible(true);
	}

	public void inicializarComponentes() {

		lblNombre = new JLabel("NOMBRE:");
		txtNombre = new JTextField();
		lblEdad = new JLabel("EDAD:");
		txtEdad = new JTextField();
		lblCedula = new JLabel("CEDULA:");
		txtCedula = new JTextField();
		lblApellido = new JLabel("APELLIDO:");
		txtApellido = new JTextField();
		lblCargo = new JLabel("CARGO:");
		txtCargo = new JTextField();

		add(lblCedula);
		add(txtCedula);
		add(lblNombre);
		add(txtNombre);
		add(lblEdad);
		add(txtEdad);
		add(lblApellido);
		add(txtApellido);
		add(lblCargo);
		add(txtCargo);

	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblCargo() {
		return lblCargo;
	}

	public void setLblCargo(JLabel lblCargo) {
		this.lblCargo = lblCargo;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtCargo() {
		return txtCargo;
	}

	public void setTxtCargo(JTextField txtCargo) {
		this.txtCargo = txtCargo;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

}
