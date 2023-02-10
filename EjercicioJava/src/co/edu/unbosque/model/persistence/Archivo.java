package co.edu.unbosque.model.persistence;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import co.edu.unbosque.modelo.Candidatos;

public class Archivo {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
			
			public Archivo(File archivo) {
				if (archivo.exists()) {
					System.out.println("El archivo ya existe");
				} else {
					try {
						archivo.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			public void escribirEnArchivo(ArrayList<Candidatos> candidatos, File archivo) {
				try {
					System.out.println(archivo);
					salida = new ObjectOutputStream(new FileOutputStream(archivo));
					salida.writeObject(candidatos);
					salida.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}public Archivo() {
				// TODO Auto-generated constructor stub
			}
			public ArrayList<Candidatos> leerArchivo(File archivo) {
				
				System.out.println("entro");
				ArrayList<Candidatos> candidatos = new ArrayList<Candidatos>();
				if (archivo.length() != 0) {
					try {
						entrada = new ObjectInputStream(new FileInputStream(archivo));
						candidatos = (ArrayList<Candidatos>) entrada.readObject();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return candidatos;
				
			}
			public ObjectInputStream getEntrada() {
				return entrada;
			}
			public void setEntrada(ObjectInputStream entrada) {
				this.entrada = entrada;
			}
			public ObjectOutputStream getSalida() {
				return salida;
			}
			public void setSalida(ObjectOutputStream salida) {
				this.salida = salida;
			}
		
	}

