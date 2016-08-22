/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.TiburonG;
import java.util.ArrayList;
import java.util.logging.*;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.HBox;


//import graphics.*;

/**
 *clase runnable que genera un canvas(figurilla tiburon)
 * @author fabkm
 */
public class Tiburon extends Pez {
   private HBox contenedor;
   //private int numPalabras;
   //private TiburonG tiburon; 
   
    public Tiburon(double xMove, double yMove, Node pez){
        super(pez);    // 1º paso el nodo del Canvas (dibujo del Tiburon)
        super.move(xMove, yMove);  // 2º se mueve el nodo a posicion especifica (de inicio)
        
    }

    public Tiburon(double x, double y,  ArrayList<String> lista){
        this(x,y,(new TiburonG()).getTiburon());
        this.typePez(lista);
    }
    
    public Tiburon(double x, double y, Node pez,  ArrayList<String> lista){
        this(x,y,pez);
        this.typePez(lista);
    }
    private void typePez(ArrayList<String> lista){
        contenedor=new HBox();
        LabelColor type=new LabelColor(lista);
        
    }
    
    
    public Node getTypePez(){
        return pez;
    }
    
    @Override
    public void run() {
        final int distancia = 1;
        for(int i=0; i<600;i++){
            Platform.runLater(new Runnable(){
            
                @Override
                public void run() {
                    move(pez.getTranslateX()-distancia,pez.getTranslateY());
                }
                
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
