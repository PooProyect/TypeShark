/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.*;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
      
        //runBuceador();
        añadirPeces();
    }
    private void runBuceador(){
  
   Thread t=new Thread(buceador);
   t.start();
   Thread status=new Thread(new Status());
   status.start();
    }
    
    private void añadirPeces(){
        FlowPane flow = new FlowPane(Orientation.VERTICAL);
        FondoMarino fondo = new FondoMarino(Constantes.DIMENSION_SCENE_X,Constantes.DIMENSION_SCENE_Y);  // extra
        StackPane stack;
        Tiburon t;
        Label l;                                      // Label tambien debe hacer TranslateX  y TranslateY para moverse con el pez
        ArrayList<String>list =new ArrayList();
        list.add("aaaa");
        list.add("BBBBsads");
        list.add("abbbccc");
        ((FlowPane) flow).setVgap(10);
        root.getChildren().add(fondo.getFondoMarino());  // extra: FondoMarino   no se ve el Status??
        for(int i=0;i<3;i++){
            stack = new StackPane();
            t = new Tiburon(200,0,Color.ALICEBLUE,list); // 200
            l = new Label(list.get(i));           // por ahora usé los string de la lista
            l.setTranslateX(200);        // 200
            stack.setAlignment(Pos.CENTER);
            
            stack.getChildren().addAll(t.getPez(),l);
            ((FlowPane) flow).getChildren().add(stack);
        }
        
        
        //Pirana p = new Pirana(100,100,Color.ALICEBLUE, list);
        //((FlowPane) flow).getChildren().add(p.getPez());
        
        ((BorderPane) root).setCenter(flow);
        
        
        /*t.getTypePez().setScaleX(Constantes.DIMENSION_SCENE_X-30);
        t.getTypePez().setScaleY(Constantes.DIMENSION_SCENE_Y-30);*/
        
        /*Thread tibu=new Thread(t);
        tibu.start();*/
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
