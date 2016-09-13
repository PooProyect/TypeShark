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
public class Moneda {
private Canvas moneda;

    
    public Moneda(){
        moneda = new Canvas(40,40);
        this.desingMoneda();
    }
    
    public Node getMoneda(){
        return moneda;
    }
    
    private void desingMoneda(){
        GraphicsContext mone = moneda.getGraphicsContext2D();
        
        mone.setFill(Color.web("#F7E443"));
        mone.fillOval(0, 0, 40, 40);
        mone.setStroke(Color.web("#DDB10E"));
        mone.strokeOval(5, 5, 30, 30);
        mone.strokeLine(15, 15, 20, 30);
        mone.strokeLine(25, 15, 20, 30);
    }
    
}

