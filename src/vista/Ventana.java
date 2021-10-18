package vista;

import controlador.Controller;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private Panel panel = new Panel();
    private Controller controller;
    private JButton botonComparar = new JButton("Comparar");
    private JTextField jtfPath1 = new JTextField();
    private JTextField jtfPath2 = new JTextField();
    private JLabel labelPath1 = new JLabel("Path 1:");
    private JLabel labelPath2 = new JLabel("Path 2:");
    private JTextArea instrucciones = new JTextArea();


    public Ventana(){
        this.setSize(900,500);
        this.getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.initComponents();
        this.setTexto();
        this.setTitle("Comparador de Archivos");
    }

    private void initComponents() {
        this.add(panel);
        this.add(labelPath1);
        this.labelPath1.setBounds(10,130,90,30);
        this.add(jtfPath1);
        this.jtfPath1.setBounds(100,130,400,30);
        this.add(labelPath2);
        this.labelPath2.setBounds(10,160,90,30);
        this.add(jtfPath2);
        this.jtfPath2.setBounds(100,160,400,30);
        this.add(botonComparar);
        this.botonComparar.setBounds(500,130,100,30);
        this.add(instrucciones);
        this.instrucciones.setBounds(10,230,800,200);
    }


    public void setController(Controller controller) {
        this.controller = controller;
        this.botonComparar.addActionListener(this.controller);
    }

    private void setTexto() {
        this.instrucciones.setEditable(false);
        this.instrucciones.setBackground(Color.GRAY);
        String s =  "\nIntrucciones de uso: \n" +
                "\n" +
                "1. Arrastre dos archivos a la carpeta archivos. \n" +
                "2. Copie el Path on Content Root o la ruta de los dos archivos y peguelos en las dos casillas. \n" +
                "3. Presione el botón Comparar.";

        instrucciones.setText(s);

    }

    //Setters y Getters


    public JButton getBotonComparar() {
        return botonComparar;
    }

    public JTextField getJtfPath1() {
        return jtfPath1;
    }

    public JTextField getJtfPath2() {
        return jtfPath2;
    }
}
