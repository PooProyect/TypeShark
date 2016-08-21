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
public class PiranhaG {
 private Canvas piranha;
    
    public PiranhaG(){
        piranha = new Canvas(80,80);
        this.desingPiranha();
        //this.moveTiburon(x, y);
    }
    
    
    
    private void desingPiranha(){
        GraphicsContext pira = piranha.getGraphicsContext2D();
        //pira.beginPath();
        double xCola[] = {60,63,75};
        double xColaP[] = {60,75,72};
        double yCola[] = {40,32,25};
        double yColaP[] = {40,25,40};
        double yColaN[] = {40,48,55};
        double yColaPN[] = {40,55,40};
        double xAleta[] = {38,55,50};
        double yAleta[] = {26,21,31};
        double yAletaN[] = {50,55,44};
        
        double xBoca[] = {5,10,20};
        double yBoca[] = {40,28,47};
        
        pira.setFill(Color.DARKSALMON);
        pira.fillPolygon(xCola, yCola, 3);
        pira.fillPolygon(xCola, yColaN, 3);
        pira.fillPolygon(xColaP, yColaP, 3);
        pira.fillPolygon(xColaP, yColaPN, 3);
        
        pira.fillPolygon(xAleta, yAleta, 3);
        pira.fillPolygon(xAleta, yAletaN, 3);
        
        pira.setFill(Color.CORAL);
        pira.fillOval(10, 25, 50, 30);
        
        
        
        //pira.fillArc(x, y, w, h, startAngle, arcExtent, ArcType.CHORD);
        //pira.fillArc(5, 40, 30, 30, 50, 0, ArcType.CHORD);
        pira.setFill(Color.WHITE);
        pira.fillOval(18, 30, 8, 8);
        pira.fillPolygon(xBoca, yBoca, 3);
        
        pira.setFill(Color.BLACK);
        pira.fillOval(20,32,4,4);
        
    }
    
    public Node getPiranha(){
        return piranha;
    }
    
    
}

