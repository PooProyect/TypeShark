/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.TiburonNegroG;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 *
 * @author fabkm
 */
public class TiburonNegro extends Tiburon{
    private int numPalabras;
    
    
    public TiburonNegro(double x, double y,Node pez, LabelColor label,int nivel) {
        super(x, y, pez, label,nivel);
        this.numPalabras = (int) Math.floor((Math.random()+2));
        isTiburonNegro=true;
        sleep -= 5;
        if(numPalabras == 2) this.puntaje= 200;
        else this.puntaje = 300;
    }
    
    
    @Override
    public void run(){
        super.run();
    }

    
    
    
    
    
    
    
}
