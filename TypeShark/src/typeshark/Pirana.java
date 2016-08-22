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

/**
 *
 * @author Andres
 */
public class Pirana extends Pez{
    private HBox contenedor;
    //private PiranhaG pirana; 
   
    public Pirana(double xMove, double yMove,Node pez){
        super(pez);
        super.move(xMove, yMove);
    }

    public Pirana(double x, double y, ArrayList<String> lista){
        this(x,y,(new PiranhaG()).getPiranha());
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
        final double distancia = 0.5;
        for(int i=0; i<600;i++){
            Platform.runLater(new Runnable(){
            
                @Override
                public void run() {
                    move(pez.getTranslateX()-distancia,pez.getTranslateY());
                }
                
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

