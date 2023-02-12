package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.modelo.Candidatos;

public class CandidatosDAO {
	private Archivo archivo;

	public CandidatosDAO(Archivo archivo) {
		this.archivo = archivo;
		verificarInvariante();
	}

	// CRUD
	public String verCandidatos(ArrayList<Candidatos> candidatos) {
		String texto = "";
		for (int i = 0; i < candidatos.size(); i++) {
			texto = texto.concat(candidatos.get(i).toString() + "\n");
		}
		return texto;
	}

	public Candidatos buscarCandidatos(String cedula, ArrayList<Candidatos> candidatos) {
		Candidatos encontrado = null;
		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getCedula().equals(cedula)) {
					encontrado = candidatos.get(i);
				}
			}
		}

		return encontrado;
	}

	public boolean agregarCandidatos(String pNombre, int pEdad, String pCedula, String pApellido, String pCargo, ArrayList<Candidatos> candidatos, File file) {

		Candidatos nuevo = new Candidatos(pNombre, pEdad, pCedula, pApellido, pCargo);

		if (buscarCandidatos(pCedula, candidatos) == null) {
			candidatos.add(nuevo);

			archivo.escribirEnArchivo(candidatos, file);
			return true;
		} else {
			return false;
		}

	}

	public boolean eliminarCandidatos(String cedula, ArrayList<Candidatos> candidatos, File file) {
		boolean resp=false;
		try {
			Candidatos e = buscarCandidatos(cedula, candidatos);
			if(e!=null) {
				candidatos.remove(e);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivo(candidatos, file);
				resp= true;
			}
			return resp;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return resp;

	}
	
	
	private void verificarInvariante( )
    {
        assert archivo != null : "El archivo con el que se va a trabajar no puede ser null";
    }
	

}
