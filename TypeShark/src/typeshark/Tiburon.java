/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.ArrayList;
import java.util.logging.*;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.canvas.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 *clase runnable que genera un canvas(figurilla tiburon)
 * @author fabkm
 */
public class Tiburon extends Pez {
   private HBox contenedor;
    
    public Tiburon(double xMove, double yMove){
        Pez = new Canvas(160,85);
        this.diseñarTiburon();
        this.moveTiburon(xMove, yMove);    // getLayoutX() + x    --> 270 + 430
    }

    public Tiburon(ArrayList<String> lista){
            Pez=new Canvas(160,85);
            this.diseñarTiburon();
            this.typePez(lista);
    }
    private void typePez(ArrayList<String> lista){
        contenedor=new HBox();
        LabelColor type=new LabelColor(lista);
        
       // contenedor.getChildren().add(Pez);
        
      //  type.getNode().setLayoutX(type.getNode().getLayoutX()+20);
     //   type.getNode().setLayoutY(type.getNode().getLayoutY()+20);
    }
    
    
    
    public Node getTypePez(){
        return Pez;
    }
    private void diseñarTiburon(){
        double xPoints[] = {50,70,75};
        double yPoints[] = {31,11,31};
        double xAleta[] = {40,55,60};
        double yAleta[] = {65,60,85};
        double xCola[] = {135,155,150};
        double yCola[] = {52,30,52};
        double yColaN[] = {52,80,52};
        double xBoca[] = {4,27,5};
        double yBoca[] = {54,54,70};
        double xInf[] = {110,125,118};
        double yInf[] = {60,55,73};
        
        GraphicsContext tibu = Pez.getGraphicsContext2D();
        
        //tibu.strokeText("Tiburon",10,10);
        
        tibu.setFill(Color.LIGHTBLUE);
        //tibu.fillArc(x, y, w, h, startAngle, arcExtent, ArcType.CHORD);
        tibu.fillArc(5, 35,134,47,0,180,ArcType.ROUND);
        tibu.fillArc(5, 35,134,30, 0, -180, ArcType.ROUND);
        //tibu.fillOval(x, y, w, h);
        tibu.fillOval(4, 28, 108, 38);
        //tibu.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
        tibu.strokeRoundRect(15, 40, 5, 5, 10, 10);
        
        tibu.setFill(Color.CORNFLOWERBLUE);
        //tibu.fillPolygon(xPoints, yPoints, nPoints);
        tibu.fillPolygon(xPoints, yPoints, 3);
        tibu.fillPolygon(xAleta, yAleta, 3);
        tibu.fillPolygon(xCola, yCola, 3);
        tibu.fillPolygon(xCola, yColaN, 3);
        tibu.fillPolygon(xInf, yInf, 3);
        
        tibu.setFill(Color.ALICEBLUE);
        tibu.fillPolygon(xBoca, yBoca, 3);
    }
    
    private void moveTiburon(double x, double y){
        Pez.setTranslateX(x);     
       Pez.setTranslateY(y);
    }

    @Override
    public void run() {
        final int distancia = 1;
        for(int i=0; i<600;i++){
            Platform.runLater(new Runnable(){
            

                @Override
                public void run() {
                    this.moveTiburon(Pez.getTranslateX()-distancia,Pez.getTranslateY());
                }

                private void moveTiburon(double d, double d0) {
                    Tiburon.this.moveTiburon(d, d0);
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
