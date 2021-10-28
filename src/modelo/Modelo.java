package modelo;

import vista.Ventana;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.Stream;

public class Modelo {

    private Ventana vista;

    public Modelo(Ventana vista){
        this.vista = vista;
    }

    public String leerArchivo(String ruta){

        Path path = Paths.get(ruta);
        StringBuilder sb = new StringBuilder();

        try{
            Stream<String> stream = Files.lines(path);
            stream.forEach(s -> sb.append(s));
        } catch (IOException e){
            System.out.println("Pailander");
        }
        return sb.toString();
    }

    public String crearHash(String textToHash) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByteArray = digest.digest(byteOfTextToHash);
        String encoded = Base64.getEncoder().encodeToString(hashedByteArray);
        return encoded;
    }

    public boolean compararArchivos(String uno, String dos){
        return uno.equals(dos);
    }

    public void setComparacion() throws NoSuchAlgorithmException {
        String archivo1Leido = leerArchivo(this.vista.getJtfPath1().getText());
        String archivo2Leido = leerArchivo(this.vista.getJtfPath2().getText());

        String hashArchivo1 = crearHash(archivo1Leido);
        String hashArchivo2 = crearHash(archivo2Leido);

        if(compararArchivos(hashArchivo1,hashArchivo2)){
            JOptionPane.showMessageDialog(null,"Los dos archivos son idénticos");
        }
        else{
            JOptionPane.showMessageDialog(null, "Los dos archivos son diferentes");
        }

    }
}
