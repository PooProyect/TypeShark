/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *Esta clase esta de prueba aun no defino si estara como clase
 * @author Andres
 */
public class LabelColor{
    private HBox contenedor;
   
    private Label label1,label2;
   

    LabelColor(String c){
      
    contenedor=new HBox(); 
   
    generarLabel(c);
     
    }
    private void generarLabel(String c){
      
        label1=new Label();
        label2=new Label(c);
        label1.setTextFill(Color.RED);

        contenedor.getChildren().addAll(label1,label2);
        contenedor.setAlignment(Pos.CENTER);
       Platform.runLater(new Runnable(){
           
            @Override
            public void run() {
                contenedor.setFocusTraversable(true);
                    contenedor.addEventFilter(KeyEvent.KEY_TYPED,new KeyHandler());
            }
           
       });
       
   

        
    }
    private class KeyHandler implements EventHandler<KeyEvent>{

        @Override
       
        public void handle(KeyEvent t) {
        
        
            if(t.getCharacter().trim().charAt(0)==label2.getText().trim().charAt(0)&&label2.getText().length()>0){
                label1.setText(label1.getText().trim()+label2.getText().trim().charAt(0));
                label2.setText(label2.getText().substring(1).trim());
               //  if(label2.getText().trim().length()==0) Platform.exit();
                
                //solo es usable para el tiburon negro
                /*if(label2.getText().trim().length()==0){
                    label1.setText("");
                    label2.setText("yolo");
                }*/
                    //if interno digamos para que se elimite o se restaure las propiedades del tiburon
            }
       t.consume();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    Pane getNode(){
        return contenedor;
        
    }
}