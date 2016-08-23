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
    
    public TiburonNegro(double x, double y,Color color, ArrayList<String> lista) {
        super(x, y, (new TiburonNegroG(color)).getTiburonNegro(), lista);
        this.numPalabras = (int) Math.floor((Math.random()+2));
    }

    
    
    
    
    
    
    
}
