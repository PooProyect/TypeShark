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
import java.util.HashSet;
import java.util.Iterator;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
/**
 *
 * @author Andres
 */
public class GameOrganizer extends Organizer{

    Buceador buceador;
    
    int time;
    HashSet setTiburon;
    HashSet setTiburonNegro;
    HashSet setPirana;
    Registro registroPalabra, registroLetra;
    ArrayList palabras, letras;
    GameOrganizer(Buceador buceador, int time, int nivel) throws InterruptedException{
        root=new BorderPane();
        registroPalabra =  new Registro("Palabras.txt");
        registroLetra = new Registro("PalabrasPirañas.txt");
        palabras = registroPalabra.getList();
        letras = registroLetra.getList();
        this.buceador=buceador;
        this.time = time;
        //((BorderPane) root).setLeft(buceador.getBuceador());
        añadirPeces();
        ((BorderPane) root).setLeft(buceador.getBuceador());
        juego();
    }
    private void runBuceador(){
  
        Thread t=new Thread(buceador);
        t.start();
        Thread status=new Thread(new Status());
        status.start();
    }
    
    private String getPalabra(){     // Palabras para el tiburon
        
        int n = (int) Math.random()*palabras.size();
        if(n==palabras.size()) n--;
        return  (String) palabras.remove(n);
    }
    
    private String getLetra(){      // Letras para las Pirañas
        int n = (int) Math.random()*letras.size();
        if(n==letras.size()) n--;
        return  (String) letras.remove(n);
    }
    
    private ArrayList getListPalabras(){   // Lista de 2 o 3 Palabras para el Tiburon Negro
        ArrayList list = new ArrayList();
        int n = (int) Math.random()+2;
        for(int i=0; i<n; i++){
            list.add(getPalabra());
        }
        return list;
    }
    
    private void añadirPeces(){
        FlowPane flow = new FlowPane();
        FondoMarino fondo = new FondoMarino(Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);  // extra
        setTiburon = new HashSet();
        setTiburonNegro = new HashSet();
        setPirana = new HashSet();
        StackPane stack;
        Tiburon t;
        TiburonNegro tn;
        Pirana p;
        LabelColor labelC;
        
        flow.setVgap(10);
        flow.setMaxWidth(400);
        root.getChildren().add(fondo.getFondoMarino());  // extra: FondoMarino   no se ve el Status??
          
            for(int j=0; j<3;j++){       // en total 9 hilos .... es mucho??
                stack = new StackPane();
                labelC = new LabelColor(getPalabra());
                t = new Tiburon(500,0,Color.ALICEBLUE,labelC); // 200
                stack.setAlignment(Pos.CENTER);
                stack.getChildren().addAll(t.getPez(),t.getLabel());
                flow.getChildren().add(stack);
                setTiburon.add(t);
            
            //for(int j=0; j<this.cantTiburonNegro; j++){
                /*stack = new StackPane();                                // Todo esto sí va... Pero hay que definir cómo presenta las palabras el TiburonNegro
                labelC = new LabelColor(getListPalabras());
                tn = new TiburonNegro(500,0,Color.ALICEBLUE,labelC);
                stack.setAlignment(Pos.CENTER);
                stack.getChildren().addAll(tn.getPez(),tn.getLabel());
                flow.getChildren().add(stack);
                setTiburonNegro.add(tn);*/
            
            //for(int j=0; j<this.cantPirana; j++){
                stack = new StackPane();
                labelC = new LabelColor(getLetra());
                p = new Pirana(500,0,Color.ALICEBLUE,labelC);
                stack.setAlignment(Pos.CENTER);
                stack.getChildren().addAll(p.getPez(),p.getLabel());
                flow.getChildren().add(stack);
                setPirana.add(p);
            }
            ((BorderPane) root).setCenter(flow);
            //((BorderPane) root).setLeft(buceador.getBuceador());
        
    }
    
    private void runPeces() throws InterruptedException{
        Iterator iterTibu = setTiburon.iterator();
        Iterator iterTibuN = setTiburonNegro.iterator();
        Iterator iterPira = setPirana.iterator();
        Thread hilo;
        int cont =0;
        while(iterTibu.hasNext()){
            cont ++;
            Tiburon tibu = (Tiburon) iterTibu.next();
            //tibu.move(tibu.getPez().getTranslateX(), tibu.getPez().getTranslateY()+100);
            hilo = new Thread(tibu);
            hilo.start();
            if(cont==2) Thread.sleep(time);
            if(cont==3) Thread.sleep(time);
        }cont=0;
        while(iterPira.hasNext()){
            cont++;
            Pirana pira = (Pirana) iterPira.next();
            hilo = new Thread(pira);
            hilo.start();
            if(cont==2) Thread.sleep(time);
            if(cont==3) Thread.sleep(time*2);
        }cont=0;
        /*while(iterTibuN.hasNext()){
            cont++;
            TiburonNegro tibuN = (TiburonNegro) iterTibuN.next();    // Tiburones Negros aun No inicializados
            hilo = new Thread(tibuN);
            hilo.start();
            if(cont==1) hilo.sleep(time*4);
            if(cont==2) hilo.sleep(time*6);
            if(cont==3) hilo.sleep(time*7);
        }*/
    }
    
    
    private void juego() throws InterruptedException{
        runBuceador();
        runPeces();
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