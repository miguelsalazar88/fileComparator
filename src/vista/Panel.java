package vista;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(){
        this.setVisible(true);
        this.setSize(900,100);
        this.setBackground(Color.darkGray);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new java.awt.Font("Arial", 0, 50));
        g.setColor(Color.WHITE);
        g.drawString("COMPARADOR DE ARCHIVOS",80,75);
    }

}
