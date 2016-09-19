/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;

/**
 *
 * @author fabkm
 */
public class Ballena extends Pez{
    
    public Ballena(double xMove, double yMove,Node pez, LabelColor label,int nivel){
        super(pez,label,nivel);
        super.move(xMove, yMove);
        isBallena=true;
        sleep = 60-(15*nivel);
        puntaje = 400;
    }
    
    /*@Override
    public boolean esLimite(){
        return pez.getTranslateX() == Constantes.DIMENSION_LIMITE+120;  // igualando linea de limites
    }*/

    @Override
    public void run() {
        final int distancia = 1;
        while(!esLimite()){
            Platform.runLater(new Runnable(){
            
                @Override
                public void run() {
                    //while(label.tieneLetras()){
                    move(pez.getTranslateX()-distancia,pez.getTranslateY());
                    //if(esLimite()) move(Constantes.DIMENSION_GAME_X+100,pez.getTranslateY());  // vuelve al inicio
                    if(esLimite()){ //setPezInVisible();
                        gana = true;
                        move(Constantes.DIMENSION_GAME_X+100,pez.getTranslateY() ); // siempre se queda en el mismo getTranslateY()
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
