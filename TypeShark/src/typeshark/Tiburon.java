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
import javafx.scene.paint.Color;


//import graphics.*;

/**
 *clase runnable que genera un canvas(figurilla tiburon)
 * @author fabkm
 */
public class Tiburon extends Pez {
  // private HBox contenedor;
   //private int numPalabras;
   //private TiburonG tiburon; 
   
    public Tiburon(double xMove, double yMove, Node pez, LabelColor label){
        super(pez,label);    // 1º paso el nodo del Canvas (dibujo del Tiburon)
        super.move(xMove, yMove);  // 2º se mueve el nodo a posicion especifica (de inicio)
        
    }

    public Tiburon(double x, double y,Color color,  LabelColor label){
        this(x,y,(new TiburonG(color)).getTiburon(), label);
        try{
            this.typePez(label);       // tuve problemas con este linea
        }catch(NullPointerException e){
            
        }
        
    }
    
    /**
     *
     * @param x
     * @param y
     * @param pez
     * @param label
     */
    
   
    private void typePez(LabelColor label){
        
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
