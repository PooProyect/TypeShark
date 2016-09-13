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
   
    public Tiburon(double xMove, double yMove, Node pez, LabelColor label, int nivel){
        super(pez,label,nivel);    // 1º paso el nodo del Canvas (dibujo del Tiburon)
        super.move(xMove, yMove);  // 2º se mueve el nodo a posicion especifica (de inicio)
        sleep = 60-(15*nivel);
    }

    public Tiburon(double x, double y,Color color,  LabelColor label,int nivel){
        this(x,y,(new TiburonG(color)).getTiburon(), label,nivel);
        
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
        while(!esLimite()){
            Platform.runLater(new Runnable(){
            
                @Override
                public void run() {
                    
                    move(pez.getTranslateX()-distancia,pez.getTranslateY());
                    //if(esLimite()) move(Constantes.DIMENSION_GAME_X+100,pez.getTranslateY());  // vuelve al inicio
                    if(esLimite()){ //setPezInVisible();
                        gana = true;
                        move(Constantes.DIMENSION_GAME_X-100,pez.getTranslateY() ); // siempre se queda en el mismo getTranslateY()
                    }
                }
                
            });
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
   
}
