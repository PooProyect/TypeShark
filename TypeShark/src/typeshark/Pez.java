/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author Andres
 */
public abstract class Pez implements Runnable{
    Canvas Pez;
    Pez(){
        Pez=new Canvas();
    }
    Node getCanvas(){
        return Pez;
    }
    
}
