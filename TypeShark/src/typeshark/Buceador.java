/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import graphics.Barra;
import graphics.BuceadorG;
import graphics.Moneda;
//import java.awt.Color;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.control.*;


import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    private HBox vida;    // representacion de las vidas
    private LinkedList monedas,listPeces; 
     private Label lLife;
      private Label lSpecial; 
      private Label lPoints;
      private Barra barra;
      boolean gano=true,siguienteLvl=false;
     //  private int puntajeSpecial=1000;
       private int nivel=0;
    public Buceador(){
        //aun no esta la imagen... 
        buceador= (new BuceadorG()).getBuceador();
        special=0;
        vidas=3;
        puntuacion=0;    // para probar la Barra
        this.moveBuceador(0, 100);
        
    }
  
    
    public boolean tieneSpecial(){
        
        return special>0;
    }
    public Node getStatus(){
       return (Node)status; 
    }
    
    public Node getMonedas(){
        return vida;
    }
    private int puntuacionMaxima=1000;
    public Node getBarra(){
        Color color= Color.ALICEBLUE;
        if(puntuacion<puntuacionMaxima)
            color = Color.BLUE;
        if(puntuacion>=puntuacionMaxima&& puntuacion<puntuacionMaxima*2) color = Color.YELLOW;
        if(puntuacion>=puntuacionMaxima*2){
            puntuacionMaxima*=puntuacionMaxima;
            color = Color.RED;
            special++;
        }
        return (new Barra(450-puntuacion/25,puntuacion/25,color)).getBarra();    
    }
    public void crearMonedas(){
        vida = new HBox();
        monedas = new LinkedList();
        Moneda moneda;
        for(int i=0; i<getVidas(); i++){
            moneda = new Moneda();
            vida.getChildren().add(i, moneda.getMoneda());
            monedas.add(i, moneda);
        }
        vida.setSpacing(5);
    }
    public void crearStatus(){     // uso este crearStatus en el Game
        status=new HBox();
        lLife=new Label();
        lSpecial=new Label();
        lPoints=new Label();
        status.getChildren().addAll(lPoints,lLife,lSpecial);
        status.setSpacing(50);
        status.setAlignment(Pos.BOTTOM_CENTER);
        
        
        lLife.setText("Life "+getVidas());
        lPoints.setText("Puntaje "+getPunt());
        lSpecial.setText("Special"+getSpecial());
        //((BorderPane)root).setBottom(status);
    }
     
         @Override
      public void run() {
          while(vidas>0 && !isFondo()){
          Platform.runLater(new Runnable(){
                  
            @Override
            
            public void run() {
               int tmp[]= {-1,-1};
               int cont=0;
                move(buceador.getTranslateX()+0.5,buceador.getTranslateY()+2);
                //System.out.println(""+buceador.getTranslateX());
               for(int i=0; i<listPeces.size();i++){
                   if(((Pez) listPeces.get(i)).getGana() ){  // entra en el mismo pez 
                       restarVida(); 
                       ((Pez) listPeces.get(i)).setGana(false);// y por eso se acaban las vidas enseguida 
                       System.out.println(listPeces.get(i).toString());
                       lLife.setText("Life "+getVidas());
                       tmp[cont]=i;
                       cont++;
                   }
                   if(getVidas()==0 ){
                       gano=false;
                       break;
                   }else if(isFondo()){
                       siguienteLvl=true;
                       break;
                   }
               }
           
               lPoints.setText("Puntaje "+getPunt());
               lSpecial.setText("Special"+getSpecial());
            //  obtenerSpecial();
                  
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

    public boolean siguienteLvl(){
        return siguienteLvl;
    };
    public boolean gano(){
        return gano;
    }
     
     /* private void obtenerSpecial(){
          if(puntuacion>puntajeSpecial){
              special++;
              puntajeSpecial=(int)(puntajeSpecial*1.5);
          }
      }*/
    public int getVidas(){
        return vidas;
    }
    
    public void restarVida(){
        this.vidas --;
        ((Moneda) monedas.get(vidas)).getMoneda().setVisible(false);
    }
    public void aumentarVida(){
        vidas++;
        ((Moneda) monedas.get(vidas)).getMoneda().setVisible(true);
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

    public void setListPeces(LinkedList list){
        this.listPeces = list;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

   

    public void setStatus(HBox status) {
        this.status = status;
    }

    public HBox getVida() {
        return vida;
    }

    public void setVida(HBox vida) {
        this.vida = vida;
    }

    public Label getlLife() {
        return lLife;
    }

    public void setlLife(Label lLife) {
        this.lLife = lLife;
    }

    public Label getlSpecial() {
        return lSpecial;
    }

    public void setlSpecial(Label lSpecial) {
        this.lSpecial = lSpecial;
    }

    public Label getlPoints() {
        return lPoints;
    }

    public void setlPoints(Label lPoints) {
        this.lPoints = lPoints;
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
        return this.getVidas() == 0;
    }
    
    public void  restarSpecial(){
        special--;
    }
    
}
