package co.edu.unbosque.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    
    private static final long serialVersionUID = 8877347642037037045L;
	private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnVer;
    
    public PanelBotones(){
        setLayout(new GridLayout(3, 1, 8, 8));
        inicializarComponentes();
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        
        btnAgregar = new JButton();
        btnAgregar.setText("Agregar Candidato");
        btnAgregar.setActionCommand("AGREGAR");

        btnEliminar = new JButton();
        btnEliminar.setText("Eliminar Candidato");
        btnEliminar.setActionCommand("ELIMINAR");

        btnVer = new JButton();
        btnVer.setText("Ver Candidato");
        btnVer.setActionCommand("VER");
        
        add(btnAgregar);
        add(btnEliminar);
        add(btnVer);
        
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVer() {
        return btnVer;
    }
    
    
}
