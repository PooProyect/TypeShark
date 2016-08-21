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
import javafx.scene.shape.ArcType;

/**
 *
 * @author fabkm
 */
public class TiburonG {
private Canvas tiburon;
    
    public TiburonG(){
        tiburon = new Canvas(160,85);
        this.diseñarTiburon();
    }

    
    public Node getTiburon(){
        return tiburon;
    }
    
    private void diseñarTiburon(){
        double xPoints[] = {50,70,75};
        double yPoints[] = {31,11,31};
        double xAleta[] = {40,55,60};
        double yAleta[] = {65,60,85};
        double xCola[] = {135,155,150};
        double yCola[] = {53,30,53};
        double yColaN[] = {53,80,53};
        double xBoca[] = {4,27,5};
        double yBoca[] = {54,54,70};
        double xInf[] = {110,125,118};
        double yInf[] = {60,55,73};
        
        GraphicsContext tibu = tiburon.getGraphicsContext2D();
        //tibu.strokeText("Tiburon",10,10);
        
        tibu.setFill(Color.CORNFLOWERBLUE);
        //tibu.fillPolygon(xPoints, yPoints, nPoints);
        tibu.fillPolygon(xPoints, yPoints, 3);
        tibu.fillPolygon(xAleta, yAleta, 3);
        tibu.fillPolygon(xCola, yCola, 3);
        tibu.fillPolygon(xCola, yColaN, 3);
        tibu.fillPolygon(xInf, yInf, 3);
        
        
        tibu.setFill(Color.LIGHTBLUE);
        //tibu.fillArc(x, y, w, h, startAngle, arcExtent, ArcType.CHORD);
        tibu.fillArc(5, 33,134,54,0,180,ArcType.ROUND);
        tibu.fillArc(5, 33,134,30, 0, -180, ArcType.ROUND);
        //tibu.fillOval(x, y, w, h);
        tibu.fillOval(4, 28, 108, 38);
        //tibu.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
        tibu.strokeRoundRect(15, 40, 5, 5, 10, 10);
        
        tibu.setFill(Color.WHITESMOKE);
        tibu.fillOval(15, 40, 8, 8);
        
        tibu.setFill(Color.BLACK);
        tibu.fillOval(17.2, 44, 4, 4);
        
        tibu.setFill(Color.ALICEBLUE);
        tibu.fillPolygon(xBoca, yBoca, 3);
        //tibu.closePath();
    }
    
    /*private void moveTiburon(double x, double y){
        tiburon.setTranslateX(x);     
        tiburon.setTranslateY(y);
    }*/

    
    
}
