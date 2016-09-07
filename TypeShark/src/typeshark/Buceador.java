/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.BuceadorG;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Administrador
 */
public class Buceador implements Runnable {
    private int vidas;
    private int puntuacion;
    private int special;
    //private String nombre;
    private Node buceador;
    private HBox status;
     private Label lLife;
      private Label lSpecial; 
      private Label lPoints;
    public Buceador(){
        //aun no esta la imagen... 
        buceador= (new BuceadorG()).getBuceador();
        special=0;
        vidas=3;
        puntuacion=0;
        this.moveBuceador(0, 100);
        crearStatus();
    }
  
    
    
    public Node getStatus(){
       return (Node)status; 
    }
     private void crearStatus(){
        status=new HBox();
        lLife=new Label();
        lSpecial=new Label();
        lPoints=new Label();
        status.getChildren().addAll(lPoints,lLife,lSpecial);
        status.setSpacing(50);
        status.setAlignment(Pos.CENTER);
        
        
        lLife.setText("Life "+getVidas());
        lPoints.setText("Puntaje "+getPunt());
        lSpecial.setText("Special"+getSpecial());
     }
    @Override
    public void run() {
        while(vidas>0){
        Platform.runLater(new Runnable(){
                
            @Override
            public void run() {
                
                
                move(buceador.getTranslateX()+0.5,buceador.getTranslateY()+2);
                
            }
        });
            try{
                Thread.sleep(1000);
                    
            }catch (InterruptedException ex) {
                    Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
             
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
   
    public int getVidas(){
        return vidas;
    }
    public void aumentarVida(){
        vidas++;
    }
    public int getPunt(){
        return puntuacion;
    }
    public Node getBuceador(){
        return buceador;
    }
    public void añadirPuntaje(int valor){
        puntuacion+=valor;
    }
    public void restarVida(){
        vidas--;
    }
    /*
    public void grabarPuntuacion(){
        try{
            FileWriter lector=new FileWriter("Puntuaciones.txt");
            lector.write(nombre, puntuacion, 100);
            
        }
        catch(Exception e){
            
        }
    }*/
    public int getSpecial(){
        return special;
    }
    
    public double getX(){
        return buceador.getTranslateX();
    }
    public double getY(){
        return buceador.getTranslateY();
    }
    
    private void moveBuceador(double x, double y){
        buceador.setTranslateX(x);
        buceador.setTranslateY(y);
    }
    
    public void move(double x, double y){
        this.moveBuceador(x, y);
    }
    
    public boolean isFondo(){
        return this.getY()==Constantes.DIMENSION_GAME_Y-buceador.getScaleY();  //cuando esta en el Fondo
    }
    
    public boolean sinVidas(){
        return this.getPunt() == 0;
    }
    
    
}
