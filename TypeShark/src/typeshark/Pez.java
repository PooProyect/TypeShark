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
    int nivel;
    int sleep;
    
    public Pez(Node pez, LabelColor label, int nivel){    // todo Pez recibe un Node (en las clases hijas recibirá el node del canvas de cada dibujo)
        this.pez= pez;
        this.label = label;
        this.nivel = nivel;
        this.sleep = 0;
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
        return pez.getTranslateX() == Constantes.DIMENSION_LIMITE-250;  // quedarian 110 para el buceador 
    }
    
    public void setPezInVisible(){
        pez.setVisible(false);
        label.setInVisible();
    }
    
    public boolean isVisible(){
        return pez.isVisible();
    }
    
    public boolean isTiburonNegro(){    
        return sleep%10==0;
    }
}
