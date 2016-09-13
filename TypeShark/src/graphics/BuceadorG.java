/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author fabkm
 */
public class BuceadorG {
    private Canvas buceador;
    
    public BuceadorG(){
        buceador = new Canvas(100,200);
        this.desingBuceador();
        
    }

      
    public Node getBuceador(){
        return buceador;
    }
    
    private void desingBuceador(){
        GraphicsContext buce = buceador.getGraphicsContext2D();
        double xPan[] = {30,55,50,20};
        double yPan[] = {70,80,110,100};
        double xPant[] = {20,30,15,5};
        double yPant[] = {100,103.33,123.33,120};
        double xPanta[] = {40,50,30,20};
        double yPanta[] = {106.67,110,130,123.33};
        double xP[] = {30,32,40};
        double yP[] = {103.7,90,107};
        
        double xBrazo[] = {50,60,63,66,70,60,85,75};
        double yBrazo[] = {60,45,42,43,45,57,75,80};
        
        double xTronco[] = {30,40,50,60,70,80,81,82,70,60,55};
        double yTronco[] = {70,58,47,37,28,20,30,40,55,71,80};
        
        double xAleta1[] = {4,15,20,0};
        double yAleta1[] = {125,125,145,145};
        double xAleta2[] = {18,31,52,37};
        double yAleta2[] = {132,130,140,150};
        
        double xTanque[] = {50,62,38,26};
        double yTanque[] = {25,35,56,47};
        
        buce.setFill(Color.ALICEBLUE);
        buce.fillRect(0, 0, 100, 150);
        
        buce.setFill(Color.web("#EDBD3C"));
        buce.fillPolygon(xTronco, yTronco, 11);
        buce.setFill(Color.web("#390A89"));  // morado oscuro
        buce.fillOval(70, 0, 30, 30);
        buce.fillPolygon(xPan, yPan, 4);
        buce.fillPolygon(xPant, yPant, 4);
        buce.fillPolygon(xPanta, yPanta, 4);
        buce.fillPolygon(xBrazo, yBrazo, 8);
        
        buce.setFill(Color.web("#F97E0B"));
        buce.fillOval(50, 20, 15, 15);
        buce.fillPolygon(xTanque, yTanque, 4);
        
        buce.setFill(Color.ALICEBLUE);
        buce.fillPolygon(xP, yP, 3);
        
        buce.setFill(Color.AZURE);
        buce.fillRoundRect(70, 10, 30, 10, 10, 10);
        buce.setStroke(Color.ORANGE);
        buce.strokeRoundRect(70, 10, 30, 10, 10, 10);
        buce.strokeRoundRect(72, 12, 26, 6, 10, 10);
        
        buce.setFill(Color.BLACK);
        buce.fillOval(3, 120, 13, 13);
        buce.fillOval(19, 126, 12, 12);
        buce.fillPolygon(xAleta1, yAleta1, 4);
        buce.fillPolygon(xAleta2, yAleta2, 4);
        buce.fillOval(75, 75, 15, 15);
    }
}
