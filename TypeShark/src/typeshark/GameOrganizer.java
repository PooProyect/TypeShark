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

import javafx.scene.layout.*;


import util.files.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author Andres
 */
public class GameOrganizer extends Organizer{

    Buceador buceador;
    
    int time;
    int nivel;
    LinkedList<Pez> listPeces;      // aun no es útil 
    Registro registroPalabra, registroLetra;
    ArrayList palabras, letras;
    Button info;
    
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
        type();
    }
    
      
    private String getPalabra(){     // Palabras para el tiburon
        
        int n = (int) (Math.random()*palabras.size());
       
        return  (String) palabras.get(n);
    }
    
    private String getLetra(){      // Letras para las Pirañas
        int n = (int) (Math.random()*letras.size());
        
        return  (String) letras.get(n);
    }
    
    private ArrayList getListPalabras(){   // Lista de 2 o 3 Palabras para el Tiburon Negro
        ArrayList list = new ArrayList();
        int n = 2+((int) (Math.random()*1));
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
        Ballena b;
        StackPane stack;
        LabelColor labelC;
        RunPeces runPeces;
        Thread hilo;
        flow.setVgap(-32);
        flow.setMaxWidth(100);
        flow.setMaxHeight(100);
        int i=0;
        for(int j=0; j<2;j++){      
            stack = new StackPane();
            labelC = new LabelColor(getPalabra());
            t = new Tiburon(500,0,(new TiburonG()).getTiburon(),labelC,nivel);        // Dos Tiburones 
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
            tn = new TiburonNegro(500,0,(new TiburonNegroG()).getTiburonNegro(),labelC,nivel);  // 2 Tiburones Negros
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
            p = new Pirana(500,0,(new PiranhaG()).getPiranha(),labelC,nivel);         // 2 Pirañas
            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(p.getPez(),p.getLabel());
            flow.getChildren().add(stack);
            listPeces.add(j+i,p);
            runPeces = new RunPeces(p, j);
            hilo = new Thread(runPeces);
            hilo.start();
            if(j==1){
                //HBox tmp = new HBox();
                stack = new StackPane();                                
                labelC = new LabelColor(getPalabra());
                b = new Ballena(600,0,(new BallenaG()).getBallena(),labelC,nivel);  // 1 Ballena
                stack.setAlignment(Pos.CENTER);
                stack.getChildren().addAll(b.getPez(),b.getLabel());
                flow.getChildren().add(stack);
                listPeces.add(j+i,b);
                runPeces = new RunPeces(b, j);
                hilo = new Thread(runPeces);
                hilo.start();
                i++;
            }
        }
            ((BorderPane) root).setCenter(flow);
    }
    
    private void runBuceador(){
        //Thread b = new Thread(buceador);
        Thread t=new Thread(new Runnable(){
        Status status = new Status();
            
            @Override
            public void run() {
                //buceador.run();
                status.run();
            }
            
        });
        //b.start();
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
        Status(){
            crearStatus();
            if(buceador.isFondo() || buceador.sinVidas()){
                ((BorderPane) root).setBottom(info);
                info.setOnMouseClicked(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    root = (new InformacionOrganizer(buceador,nivel,false)).getRoot();   // true porque sí hay elementos q cargar en Juego 
                    cambiarPantalla(event,Constantes.DIMENSION_SCENE_X,Constantes.DIMENSION_SCENE_Y);
                    event.consume();
                }
            });
            }
        }
        @Override
        public void run() {
          //  System.out.print(buceador.getPunt());
            while(buceador.getVidas()>0){
                buceador.run();
            }
            
        }
            
        
        private void crearStatus(){
            buceador.crearStatus();
            buceador.crearMonedas();
            ((BorderPane) root).setBottom(buceador.getStatus());
            root.getChildren().addAll(buceador.getMonedas(),buceador.getBarra() ); 
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
                else if(pez.isBallena())  Thread.sleep(time*(factor+1));
                else Thread.sleep(time*factor);
                pez.run();
                //if(pez.getGana()) buceador.restarVida();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GameOrganizer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
  private boolean tieneObjetivo =false;
   Pez objetivo;
   private boolean tieneObjetivo(){
       return tieneObjetivo;
   }
   
   //este metodo funciona directamente como eliminacion de la piraña o buscar el objetivo
   private void buscarInicial(char c){
       int i=0;
       
       while(i<listPeces.size()){
           
           //se necesita un metodo que indique o asegure que esta dentro de la pantalla, para asi evitar que se tipeen los que estan fuera del scene
           if(listPeces.get(i).getX()<=400&&listPeces.get(i).getLabelColor().comparar(c)){
              tieneObjetivo=true;
              objetivo=listPeces.get(i);
              objetivo.getLabelColor().colorear();
              if(!objetivo.getLabelColor().tieneLetras()){
                  tieneObjetivo=false;
                  buceador.añadirPuntaje(objetivo.getPuntaje());
                  root.getChildren().add(buceador.getBarra() );
                  objetivo.move(500, objetivo.getY());
                  objetivo.getLabelColor().añadirLista(getLetra());
                 // objetivo.getLabelColor().colocarALista(getLetra());
              }
              i=listPeces.size();
           }
           i++;
       }
   }     
   
   private void eliminarMasivamentePeces(){
       int i=0;
       while(i<listPeces.size()){
           if(listPeces.get(i).getX()<=400){
               listPeces.get(i).move(600, listPeces.get(i).getY());
               if(listPeces.get(i).isPiraña){
                   listPeces.get(i).getLabelColor().añadirLista(getLetra());
               
           }else if(listPeces.get(i).isTiburonNegro){
               listPeces.get(i).getLabelColor().añadirLista(getListPalabras());
           }else if(listPeces.get(i).esBallena()){
               listPeces.get(i).getLabelColor().añadirLista(getPalabra());// desconocemos cual es la lista
               listPeces.get(i).move(1500, listPeces.get(i).getY());
               
           }else
           {
             listPeces.get(i).getLabelColor().añadirLista(getPalabra()); 
             
           }
              
           }
           i++;
       }
       
   }
   
    private class KeyHandler implements EventHandler<KeyEvent>{

        @Override
       
        public void handle(KeyEvent t) {
            if(buceador.tieneSpecial()&&t.getCode().equals(KeyCode.ENTER)){
                buceador.restarSpecial();
                eliminarMasivamentePeces();
                tieneObjetivo=false;
            }else if(!tieneObjetivo()){
                buscarInicial(t.getText().charAt(0));
            }else{
                if(objetivo.getLabelColor().comparar(t.getText().charAt(0))){
                    objetivo.getLabelColor().colorear();
                    if(!objetivo.getLabelColor().tieneLetras()){
                         buceador.añadirPuntaje(objetivo.getPuntaje());
                         root.getChildren().add(buceador.getBarra() );
                         tieneObjetivo=false;
                         objetivo.move(500, objetivo.getY());
                         if(objetivo.esTNegro()){
                             objetivo.getLabelColor().añadirLista(getListPalabras());
                         }else if (objetivo.esBallena()){
                             objetivo.getLabelColor().añadirLista(getPalabra());//se usa el mismo listado de palabras, debido a que no tenemos el listado de ballena
                             
                         }else{
                             objetivo.getLabelColor().añadirLista(getPalabra());
                         }
                    }
                }
           
                
            }
        
        
       
       t.consume();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    private void type(){
        Platform.runLater(new Runnable(){

            @Override
            public void run() {
                root.requestFocus();
                root.setOnKeyPressed(new KeyHandler());


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
            
        });
    }
 
        
}

   
    
    
