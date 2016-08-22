/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.*;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Andres
 */
public class GameOrganizer extends Organizer{

     Buceador buceador;
    int timeDificult;
    GameOrganizer(Buceador buceador, int timeDificult){
        root=new BorderPane();
        this.buceador=buceador;
        this.timeDificult=timeDificult;
      
        runBuceador();
        añadirPeces();
    }
    private void runBuceador(){
  
   Thread t=new Thread(buceador);
   t.start();
   Thread status=new Thread(new Status());
   status.start();
    }
    private void añadirPeces(){
        ArrayList<String>list =new ArrayList();
        list.add("aaaa");
        list.add("BBBBsads");
        Tiburon t=new Tiburon(100,100,list);
        Pirana p = new Pirana(100,100,list);
        //((BorderPane)root).setCenter(t.getPez());
        root.getChildren().addAll(t.getPez(),p.getPez());
        /*t.getTypePez().setScaleX(Constantes.DIMENSION_SCENE_X-30);
        t.getTypePez().setScaleY(Constantes.DIMENSION_SCENE_Y-30);*/
        Thread tibu=new Thread(t);
        tibu.start();
    }
    /**
     * clase interna para mostrar los valores que llevaan mientras va avanzando el juego
     */
    private class Status implements Runnable{
     private HBox status;
     private Label lLife;
     private Label lSpecial; 
     private Label lPoints;
     Status(){
         crearStatus();
         ((BorderPane)root).setBottom(status);
     }
        @Override
        public void run() {
            
            
            while(buceador.getVidas()>0){
                Platform.runLater(new Runnable(){

                    @Override
                    public void run() {
                        
                        actualizar();
                    }
                    
                });
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
        private void crearStatus(){
            status=new HBox();
            lLife=new Label();
            lSpecial=new Label();
            lPoints=new Label();
            status.getChildren().addAll(lPoints,lLife,lSpecial);
            status.setSpacing(50);
            status.setAlignment(Pos.CENTER);
            lLife.setText("Life "+buceador.getVidas());
            lPoints.setText("Puntaje "+buceador.getPunt());
            lSpecial.setText("Special"+buceador.getSpecial());
        }
        private void actualizar(){
            lLife.setText("Life "+buceador.getVidas());
            lPoints.setText("Puntaje "+buceador.getPunt());
            lSpecial.setText("Special"+buceador.getSpecial());
        }
    }
}
