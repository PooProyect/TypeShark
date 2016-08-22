/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.scene.Node;

/**
 *
 * @author Andres
 */
public abstract class Pez implements Runnable{
    Node pez;
    
    public Pez(Node pez){    // todo Pez recibe un Node (en las clases hijas recibirá el node del canvas de cada dibujo)
        this.pez= pez;
        //this.movePez(x, y);
    }
    public Node getPez(){
        return pez;
    }
    
    private void movePez(double x, double y){
        pez.setTranslateX(x);     
        pez.setTranslateY(y);
    }
    
    public void move(double x,double y){
        this.movePez(x, y);
    }
}
