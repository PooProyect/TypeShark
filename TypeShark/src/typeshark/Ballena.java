/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.BallenaG;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 *
 * @author fabkm
 */
public class Ballena extends Pez{
    
    public Ballena(double xMove, double yMove,Node pez, LabelColor label,int nivel){
        super(pez,label,nivel);
        super.move(xMove, yMove);
        sleep = 60-(15*nivel);
        puntaje = 400;
    }
    
    public Ballena(double x, double y,Color color,  LabelColor label,int nivel){
        this(x,y,(new BallenaG()).getBallena(), label,nivel);
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
