/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;

/**
 *Esta clase esta de prueba aun no defino si estara como clase
 * @author Andres
 */
public class LabelColor{
    private HBox contenedor;
    private ArrayList<String> lista;
    private Label label1,label2;
    //private boolean esObjetivo=true;
 
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
    
  
    }
    boolean esObjetivo=true;
    public void esInicial(char c){
        if(c==label2.getText().trim().charAt(0)){
            colorear();
            //comparo hasta que se llegue el momento que no posea ni un caracter en ese label
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        
                        contenedor.requestFocus();
                        contenedor.addEventFilter(KeyEvent.KEY_TYPED,new KeyHandler());
                            System.out.println("asdksdka");
                    }
                });
            
        }
        
       
    }
    
    
    
    private void colorear(){
        label1.setText(label1.getText().trim()+label2.getText().trim().charAt(0));
                label2.setText(label2.getText().substring(1).trim());
    }
    private class KeyHandler implements EventHandler<KeyEvent>{

        @Override
       
        public void handle(KeyEvent t) {
        
        
            if(t.getCharacter().trim().charAt(0)==label2.getText().trim().charAt(0)){
                colorear();
                if(label2.getText().trim().length()==0){
                    lista.remove(label1.getText().trim());
                
                if(lista.size()>0){
                    label1.setText("");
                    label2.setText(lista.get(0));
                }else{
                    esObjetivo=false;
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