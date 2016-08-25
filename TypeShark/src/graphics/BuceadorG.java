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
        
        buce.setFill(Color.ANTIQUEWHITE);
        buce.fillOval(0, 0, 80, 180);
        
    }
}
