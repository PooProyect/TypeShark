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
    LabelColor label;
    
    public Pez(Node pez, LabelColor label){    // todo Pez recibe un Node (en las clases hijas recibirá el node del canvas de cada dibujo)
        this.pez= pez;
        this.label = label;
    }
    public Node getPez(){
        return pez;
    }
    
    public Node getLabel(){
        return label.getNode();
    }
    
    private void movePez(double x, double y){
        pez.setTranslateX(x);     
        pez.setTranslateY(y);
        label.getNode().setTranslateX(x);
        label.getNode().setTranslateY(y);
    }
    
    public void move(double x,double y){
        this.movePez(x, y);
    }
    
    public boolean esLimite(){
        return pez.getTranslateX() == Constantes.DIMENSION_LIMITE-160;  // quedarian 180 para el buceador 
    }
    
    
}
