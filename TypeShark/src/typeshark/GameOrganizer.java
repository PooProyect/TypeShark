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
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;

import util.files.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
/**
 *
 * @author Andres
 */
public class GameOrganizer extends Organizer{

    Buceador buceador;
    
    int time;
    int nivel;
    LinkedList listPeces;      // aun no es útil 
    Registro registroPalabra, registroLetra;
    ArrayList palabras, letras;
    
    public GameOrganizer(Buceador buceador, int time, int nivel) throws InterruptedException{
        root=new BorderPane();
        listPeces = new LinkedList();
        this.buceador=buceador;
        this.time = time;
        this.nivel = nivel;
        FondoMarino fondo = new FondoMarino(Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y); 
        registroPalabra =  new Registro("Palabras.txt");
        registroLetra = new Registro("PalabrasPirañas.txt");
        palabras = registroPalabra.getList();
        letras = registroLetra.getList();
        
        root.getChildren().add(fondo.getFondoMarino());
        ((BorderPane) root).setLeft(this.buceador.getBuceador());
        juego();
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
    
    
    private void crearPeces(){
        FlowPane flow = new FlowPane();
        Tiburon t;
        TiburonNegro tn;
        Pirana p;
        StackPane stack;
        LabelColor labelC;
        RunPeces runPeces;
        Thread hilo;
        flow.setVgap(-10);
        flow.setMaxWidth(200);
        int i=0;
        for(int j=0; j<2;j++){      
            stack = new StackPane();
            labelC = new LabelColor(getPalabra());
            t = new Tiburon(500,0,Color.ALICEBLUE,labelC,nivel);        // Dos Tiburones 
            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(t.getPez(),t.getLabel());
            flow.getChildren().add(stack);
            listPeces.add(j+i, t);
            runPeces = new RunPeces(t, j);
            hilo = new Thread(runPeces);
            hilo.start();
            i++;
            stack = new StackPane();                                
            labelC = new LabelColor(getListPalabras());
            tn = new TiburonNegro(500,0,Color.ALICEBLUE,labelC,nivel);  // 2 Tiburones Negros
            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(tn.getPez(),tn.getLabel());
            flow.getChildren().add(stack);
            listPeces.add(j+i,tn);
            runPeces = new RunPeces(tn, j);
            hilo = new Thread(runPeces);
            hilo.start();
            i++;
            stack = new StackPane();
            labelC = new LabelColor(getLetra());
            p = new Pirana(500,0,Color.ALICEBLUE,labelC,nivel);         // 2 Pirañas
            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(p.getPez(),p.getLabel());
            flow.getChildren().add(stack);
            listPeces.add(j+i,p);
            runPeces = new RunPeces(p, j);
            hilo = new Thread(runPeces);
            hilo.start();
        }
            ((BorderPane) root).setCenter(flow);
    }
    
    private void runBuceador(){
        
        Thread t=new Thread(new Runnable(){
        Status status = new Status();
            
            @Override
            public void run() {
                //buceador.run();
                status.run();
            }
            
        });
        t.start();
    }
    
    private void juego() throws InterruptedException{     
        crearPeces();
        buceador.setListPeces(listPeces);
        runBuceador();
        
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
         
         
     }
        @Override
        public void run() {
            System.out.print(buceador.getPunt());
            //buceador.run();
            
                while(buceador.getVidas()>0){
                        buceador.run();
                    }
                
            
        }
            
        private void crearStatus(){
            ((BorderPane)root).setBottom(buceador.getStatus());
            root.getChildren().add(buceador.getMonedas() ); // monedas
        }
        private void actualizar(){
            System.out.print(buceador.getVidas());
            for(int i=0; i<listPeces.size();i++){
                if(((Pez) listPeces.get(i)).getGana()){
                    buceador.restarVida();
                    
                    lLife.setText("Life "+buceador.getVidas());
                    
                }if(buceador.getVidas()==0) break;
            }
            
            lPoints.setText("Puntaje "+buceador.getPunt());
            lSpecial.setText("Special"+buceador.getSpecial());
        }
        
    }
    
    private class RunPeces implements Runnable{
        private Pez pez;
        private int factor;
    
        RunPeces(Pez pez,int factor){
            this.factor = factor;
            this.pez = pez;
        }
        @Override
        public void run(){
            try {
                if(pez.isTiburonNegro())      Thread.sleep(time*(factor+2));    // cada tiburon negro debería demorar un poco más en salir
                else Thread.sleep(time*factor);
                pez.run();
                //if(pez.getGana()) buceador.restarVida();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GameOrganizer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    
   
        
}

   
    
    
