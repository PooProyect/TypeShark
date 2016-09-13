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
public class Barra {
    private Canvas barra;
    private double y;
    private double heigth;
    
    private Color color;
    
    public Barra(double y, double alto, Color color){
        this.y = y;
        this.heigth = alto;
        this.color = color;
        barra = new Canvas(10,heigth);
        barra.setTranslateX(5);
        barra.setTranslateY(450);
        this.desingBarra();
    }
    
    public Node getBarra(){
        return barra;
    }
    private void desingBarra(){
        GraphicsContext ba = barra.getGraphicsContext2D();
        
        ba.setFill(color);
        ba.fillRect(0, 0, 10, heigth);
        
    }
}
