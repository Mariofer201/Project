package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.modelo.Candidatos;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.CandidatosDAO;
import co.edu.unbosque.vista.VentanaPrincipal;

public class Controller implements ActionListener {

	private ArrayList<Candidatos> candidatos;
	private VentanaPrincipal ventanaprincipal;
	private Archivo archivo;
	private CandidatosDAO candidatosdao;
	private File file = new File("data/basedatos.dat");

	public Controller() {
		ventanaprincipal = new VentanaPrincipal();
		asignarOyentes();
		candidatos = new ArrayList<Candidatos>();
		archivo = new Archivo(file);
		candidatosdao = new CandidatosDAO(archivo);
		candidatos = archivo.leerArchivo(file);
	}

	public void asignarOyentes() {
		ventanaprincipal.getPanelCentral().getPanelBotones().getBtnAgregar().addActionListener(this);
		ventanaprincipal.getPanelCentral().getPanelBotones().getBtnEliminar().addActionListener(this);
		ventanaprincipal.getPanelCentral().getPanelBotones().getBtnVer().addActionListener(this);
	}
	

	public ArrayList<Candidatos> getCandidatos() {
		return candidatos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("AGREGAR")) {
			if (ventanaprincipal.getPanelCentral().getPanelDatos().getTxtNombre().getText().isEmpty()
					|| ventanaprincipal.getPanelCentral().getPanelDatos().getTxtEdad().getText().isEmpty()
					|| ventanaprincipal.getPanelCentral().getPanelDatos().getTxtApellido().getText().isEmpty()
					|| ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCargo().getText().isEmpty()
					|| ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCedula().getText().isEmpty()) {
				ventanaprincipal.mostrarMensaje("Debes agregar todos los valores solicitados para agregar un nuevo candidato", "ERROR");
			} else {
				if(candidatosdao.agregarCandidatos(ventanaprincipal.getPanelCentral().getPanelDatos().getTxtNombre().getText(),
						Integer.parseInt(ventanaprincipal.getPanelCentral().getPanelDatos().getTxtEdad().getText()),
						(ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCargo().getText()),
						(ventanaprincipal.getPanelCentral().getPanelDatos().getTxtApellido().getText()),
						ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCedula().getText(), candidatos, file)) {
					ventanaprincipal.mostrarMensaje("Se ha agregado el empleado con cedula: " + ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCedula().getText() ,"INFORMACION");
				} else {
					ventanaprincipal.mostrarMensaje("El candidato con cedula " + ventanaprincipal.getPanelCentral().getPanelDatos().getTxtCedula().getText() + " ya se encuentra agregado","ERROR");
				}
			}

		}
		if (command.equals("ELIMINAR")) {
			String cedulaCandidatos = ventanaprincipal.capturarDato("Escribe la cedula del candidato que quieres eliminar:", "INGRESAR CEDULA");
			if (candidatosdao.buscarCandidatos(cedulaCandidatos, candidatos) != null) {
				if(candidatosdao.eliminarCandidatos(cedulaCandidatos, candidatos,file)) {
					ventanaprincipal.mostrarMensaje("Se ha eliminado el candidato con cedula: " + cedulaCandidatos ,"INFORMACION");
				}else {
					ventanaprincipal.mostrarMensaje("No se ha podido eliminar el candidato con cedula: " + cedulaCandidatos ,"INFORMACION");
				}
			} else {
				ventanaprincipal.mostrarMensaje("El candidato con cedula " + cedulaCandidatos + " NO existe en el sistema","ERROR");
			}
		}
		if (command.equals("VER")) {

			if (getCandidatos().size() > 0) {
				ventanaprincipal.mostrarMensaje(candidatosdao.verCandidatos(candidatos),"INFORMACION");
			} else {
				ventanaprincipal.mostrarMensaje("No hay candidatos en el sistema actualmente", "INFORMACION");
			}
		}
	}

}
