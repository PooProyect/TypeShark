/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


/**
 *
 * @author fabkm
 */
public abstract class Organizer {
   Pane root;
   // private Tiburon tiburon;
   // private Set<Tiburon> tiburones;
    //private int cantTiburones;
    Scene scene;
    public Organizer(){
        
        root=new Pane();
        setScene();
//   root = new BorderPane();
      //  this.cantTiburones = cantidad;
      //  this.tiburones =  new HashSet<Tiburon>();
      //  Button btn = new Button("start");
        
      //  root.setBottom(btn);
       // this.crearTiburones(cantTiburones);
      //  btn.setOnAction(new TiburonClick());
        //root.getChildren().add(tiburon.getCanvas(),btn);
    }
    
    public Pane getRoot(){
        root.setFocusTraversable(true);
        return root;
    }
    public Scene getScene(){
        return scene;
    }
    public void setScene(){
        scene=new Scene(root,300,300);
    }
    /*
    private void crearTiburones(int cant){
        for(int i=0; i<cant; i++){
            tiburon = new Tiburon(700,Math.random()*400,Color.GRAY); 
            tiburones.add(tiburon);
            root.getChildren().add(tiburon.getCanvas());  // como si fuera sólo un panel 
        }
    }
    
    
    private class TiburonClick implements EventHandler<ActionEvent>{
        Iterator iterar = tiburones.iterator();
        
        @Override
        public void handle(ActionEvent event) {
            while(iterar.hasNext()){
                Thread hilo = new Thread((Runnable) iterar.next());
                hilo.start();
            }
        }
    } */
}