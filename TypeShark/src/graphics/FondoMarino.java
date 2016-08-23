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
public class FondoMarino {
    private Canvas fondo;
    
    public FondoMarino(double x,double y){
        fondo = new Canvas(x,y);
        this.desingFondoMarino(x, y);
    }
    
    private void desingFondoMarino(double x, double y){
        GraphicsContext f = fondo.getGraphicsContext2D();
        
        f.setFill(Color.ALICEBLUE);
        f.fillRect(0, 0, x, y);
        
        f.setFill(Color.LIGHTGREEN);
        
        
        for(int i=0; i<5; i++){       // disñado para 700 x 500  :P
            f.fillRoundRect(100*(i+1)+100, y-95, 10, 105, 10, 10);
            for(int j=0; j<5;j++){
                f.fillOval(90*(i+1)+100+(10*i), y-(10*(2*j+1)), 30-j, 10);
            }
        }
        
        int w;
        int h;
        for(int i=0; i<50; i++){
            w = (int) (Math.random()*x);
            h = (int) (Math.random()*y);
            f.setFill(Color.AQUA);
            f.fillOval(w, h, 12, 12);
            f.setFill(Color.WHITE);
            f.fillArc(w+2, h+2, 8, 5, 0, 270, ArcType.CHORD);
        }
    }
    
    public Node getFondoMarino(){
        return fondo; 
    }
}
