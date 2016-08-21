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
public class TiburonNegroG {
private Canvas tiburon;
    
    public TiburonNegroG(){
        tiburon = new Canvas(200,100);
        this.desingTiburonN();
        //this.moveTiburon(xMove, yMove);    // getLayoutX() + x    --> 270 + 430
    }

   
    
    public Node getTiburonNegro(){
        return tiburon;
    }
    
    private void desingTiburonN(){
        double xPoints[] = {55,70,75};  //*
        double yPoints[] = {27,5,27};  //*
        double xAleta[] = {50,68,78};  //*
        double yAleta[] = {70,65,95};  //*
        double xCola[] = {165,200,190};  //*
        double yCola[] = {59.5,25,59.5};   //*
        double yColaN[] = {59.5,90,59.5}; //*
        double xBoca[] = {4,30,5};  //*
        double yBoca[] = {54,53,72}; //*
        double xInf[] = {135,155,150};
        double yInf[] = {68,63,90};
        
        GraphicsContext tibu = tiburon.getGraphicsContext2D();
        //tibu.strokeText("TiburonN",10,10);
        
        tibu.setFill(Color.BLACK);
        //tibu.fillPolygon(xPoints, yPoints, nPoints);
        tibu.fillPolygon(xPoints, yPoints, 3);
        tibu.fillPolygon(xAleta, yAleta, 3);
        tibu.fillPolygon(xCola, yCola, 3);
        tibu.fillPolygon(xCola, yColaN, 3);
        tibu.fillPolygon(xInf, yInf, 3);
        
        
        tibu.setFill(Color.DIMGRAY);
        //tibu.fillArc(x, y, w, h, startAngle, arcExtent, ArcType.CHORD);
        tibu.fillArc(5, 30,168,73,0,180,ArcType.ROUND);
        tibu.fillArc(5, 30,168,43, 0, -180, ArcType.ROUND);
        //tibu.fillOval(x, y, w, h);
        tibu.fillOval(3, 25, 130, 50);  //*
        //tibu.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
        //tibu.strokeRoundRect(15, 40, 5, 5, 10, 10);
        
        tibu.setFill(Color.WHITESMOKE);
        tibu.fillOval(18, 38, 10, 10);
        
        tibu.setFill(Color.BLACK);
        
        tibu.fillOval(20, 42, 5, 5);
        
        tibu.setFill(Color.ALICEBLUE);
        tibu.fillPolygon(xBoca, yBoca, 3);
        //tibu.closePath();
    }
    
    /*private void moveTiburon(double x, double y){
        tiburon.setTranslateX(x);     
        tiburon.setTranslateY(y);
    }*/

    
    
}

