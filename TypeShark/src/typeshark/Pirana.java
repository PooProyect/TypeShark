/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.PiranhaG;
import graphics.TiburonG;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Andres
 */
public class Pirana extends Pez{
    private HBox contenedor;
    //private PiranhaG pirana; 
   
    public Pirana(double xMove, double yMove,Node pez, LabelColor label,int nivel){
        super(pez,label,nivel);
        super.move(xMove, yMove);
        isPiraña=true;
        sleep = 20-(5*nivel);
        puntaje = 50;
    }

    
   
    
    
    public Node getTypePez(){
        return pez;
    }
    
    @Override
    public void run() {
        final double distancia = 0.5;
        while(!esLimite()){
            Platform.runLater(new Runnable(){
            
                @Override
                public void run() {
                    move(pez.getTranslateX()-distancia,pez.getTranslateY()); if(esLimite()){ //setPezInVisible();
                        gana = true;
                        move(Constantes.DIMENSION_GAME_X-50,pez.getTranslateY() );
                    
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

