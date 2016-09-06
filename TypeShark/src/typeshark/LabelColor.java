/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
    private ArrayList<String> lista;
    private Label label1,label2;
   
 
    LabelColor(String c){
    lista=new ArrayList(); 
    contenedor=new HBox(); 
    lista.add(c);
    generarLabel(lista);
     
    }
       LabelColor(ArrayList<String> lista){
        contenedor=new HBox();
        this.lista=lista;
        generarLabel(lista);
        
    }
    
    private void generarLabel(ArrayList<String> lista){
      
        label1=new Label();
        label2=new Label(lista.get(0));
        label2.setTextFill(Color.BLACK);
        label1.setTextFill(Color.ORANGE);
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
             
                if(label2.getText().trim().length()==0){
                    lista.remove(label1.getText().trim());
                    if(!lista.isEmpty()){
                          label1.setText("");
                    label2.setText(""+lista.get(0));
                    }else{
                        //no se que colocar xD
                    }
                  
                }
                    
                            
            }
       t.consume();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
   public  Node  getNode(){
        return (Node)contenedor;
        
    }
   
   public void setInVisible(){
       label1.setVisible(false);
       label2.setVisible(false);
   }
}