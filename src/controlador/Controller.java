package controlador;

import modelo.Modelo;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class Controller implements ActionListener {

    private Modelo modelo;
    private Ventana vista;

    public Controller(Ventana vista, Modelo modelo){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(this.vista.getBotonComparar())){
            try {
                modelo.setComparacion();
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Estamos jodidos");
            }
        }

    }
}
