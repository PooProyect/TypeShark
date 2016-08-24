/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.*;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;

import util.files.*;
import graphics.*;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
/**
 *
 * @author Andres
 */
public class GameOrganizer extends Organizer{

      Buceador buceador;
    int timeDificult;
    private ArrayList<String> listaPalabras;
    private ArrayList<String> listaLetras;
    GameOrganizer(Buceador buceador, int timeDificult){
        listaLetras=(new leerRegistro("PalabrasPirañas.txt")).getList();
        listaPalabras=(new leerRegistro("Palabras.txt")).getList();
        //root=new FlowPane();
        this.buceador=buceador;
        this.timeDificult=timeDificult;
        añadirPeces();
        
        ///dejar el metodo run buceador al final de este costructor, para que muestre los stat
        runBuceador();
       
       
    }
    private void runBuceador(){
  
   Thread t=new Thread(buceador);
   t.start();
   Thread status=new Thread(new Status());
   status.start();
    }
     FlowPane flow;
    private void añadirPeces(){
       // TypePez t =new TypePez((new TiburonG(Color.ALICEBLUE)).getTiburon(),listaPalabras.get((int)(Math.random()*listaPalabras.size())),500);
        FondoMarino fondo = new FondoMarino(Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);  // extra
        root.getChildren().add(fondo.getFondoMarino());  
       flow=new FlowPane(Orientation.VERTICAL);
        flow.setVgap(10);
       // flow.getChildren().add(t.getNode());
        root.getChildren().add(flow);
        flow.setLayoutX(500);
      
        
        StackPane stack;
        Tiburon t;
        LabelColor labelC;
        
      
        ((FlowPane) flow).setVgap(10);
        
        Thread hilo;
        for(int i=0;i<3;i++){
           stack = new StackPane();
            labelC = new LabelColor("abc"+1);
            t = new Tiburon(500-i*100,0,Color.ALICEBLUE,labelC); // 200
         
            stack.setAlignment(Pos.CENTER);
            
            stack.getChildren().addAll(t.getPez(),t.getLabel());
          // ((FlowPane) flow).getChildren().add((new TypePez((new TiburonG(Color.ALICEBLUE)).getTiburon(),listaPalabras.get((int)(Math.random()*listaPalabras.size())),500)).getNode());
            //hilo = new Thread(t);
            //hilo.start();
            
            
        }
        
        
     //  ((BorderPane) root).setCenter(flow);
        /*Thread tibu=new Thread(t);
        tibu.start();*/
    }
    private class TypePez{
        Label label1;
        Label label2;
        StackPane stack;
        ArrayList<String> lista;
        TypePez(Pez pez,String word ,double speed){
            lista=new ArrayList();
            lista.add(word);
            TypePez(pez.getPez(),lista,speed);
            
        }
        //en teoria todo pez es como la funcionabilidad, pero por conveniencia todos tendran un listado
       public void TypePez(Node pez, ArrayList<String> lista,double speed){
            HBox contenedor=new HBox();
            colocarPalabras(lista);
            label1.setTextFill(Color.ORANGE);
            label2.setTextFill(Color.OLIVE);
            contenedor.getChildren().addAll(label1,label2);
            contenedor.setAlignment(Pos.CENTER);
            stack=new StackPane();
            stack.getChildren().addAll(pez,contenedor);
            
            root.getChildren().add(stack);
            stack.setLayoutX(Constantes.DIMENSION_GAME_X/2);
            stack.setLayoutY(Constantes.DIMENSION_GAME_Y/2);
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                    flow.setFocusTraversable(true);
                    flow.addEventHandler(KeyEvent.KEY_PRESSED,new KeyHandler(50));
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
            });
           
            
        }
       private void colocarPalabras(ArrayList<String> lista){
            label1=new Label("");
            label2=new Label(lista.get(0));
            lista.remove(0);
           
       }
        /*private StackPane getNode(){
            return stack;
        }*/
        public class KeyHandler implements EventHandler<KeyEvent>{
           int point;
                KeyHandler(int point){
                this.point=point;    
                }
        @Override
       
        public void handle(KeyEvent t) { 
            if(t.getCode().equals(KeyCode.ENTER)){
                flow.getChildren().remove(stack);
               // flow.setFocusTraversable(false);
            }else 
                if(t.getText().trim().charAt(0)==label2.getText().charAt(0)){
                    label1.setText(label1.getText().trim()+label2.getText().trim().charAt(0));
                    label2.setText(label2.getText().substring(1).trim());
                    if(label2.getText().trim().length()==0){
                        if(!lista.isEmpty()){
                            colocarPalabras(lista); 
                        }else{
                            flow.getChildren().remove(stack);
                            buceador.añadirPuntaje(point);
                        }
                    }//en el siguiente if colocar un valor de puntaje a reducir, cambiarlo dentro de la clase constantes
                    if(t.getCode().equals(KeyCode.ENTER)&&buceador.getPunt()>Constantes.PUNTAJE_EPECIAL){
                        buceador.añadirPuntaje(-Constantes.PUNTAJE_EPECIAL);
                        flow.getChildren().remove(stack);
                    }
                }
        
            t.consume();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
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
         crearStatus();//aqui hay que hacer un posicionamiento absoluto
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
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
        private void crearStatus(){
            status=new HBox();
            lLife=new Label();
            lSpecial=new Label();
            lPoints=new Label();
            status.getChildren().addAll(lPoints,lLife,lSpecial);
            status.setSpacing(50);
            status.setAlignment(Pos.CENTER);
            actualizar();
        }
        private void actualizar(){
            lLife.setText("Life "+buceador.getVidas());
            lPoints.setText("Puntaje "+buceador.getPunt());
            lSpecial.setText("Special"+buceador.getSpecial());
        }
    }
    
/*     @Override
    public void cambiarPantalla(Event t){
        super.cambiarPantalla(t);
    }*/
    
    
}
