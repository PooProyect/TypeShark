/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import util.files.Registro;

/**
 *
 * @author fabkm
 */
public class InformacionOrganizer extends Organizer{
    private Button guardar,grabar,continuar,topTen,volver;
    private Button cargar;
    private TextField texto;
    private Buceador jugador;
    private Integer nivel;
    private String juegoGuardado[];   // estos datos se mantendrán mientras no se cambie de nombre. No hay problema // no debe aceptar duplicados
    private ArrayList<String> lista;   // se puede reescribir una linea de archivo??
    boolean juegos;   // si tiene juegos guardados 
    public InformacionOrganizer(Buceador buceador, Integer nivel,boolean tengoJuegos){
        this.jugador = buceador;
        this.nivel = nivel;
        this.juegos = tengoJuegos;
        pedirInfo();
    }
    
    private void pedirInfo(){
        guardar = new Button("Guardar");
        HBox info = new HBox();
        Label nombre = new Label("Nombre");
        texto = new TextField();
        info.getChildren().addAll(nombre,texto,guardar);
        info.setAlignment(Pos.BOTTOM_CENTER);
        info.setSpacing(5);
        ((BorderPane) root).setTop(info);
        volver = new Button("Volver");
        ((BorderPane) root).setBottom(volver);
        volver.setOnMouseClicked(new InformacionOrganizer.ClickHandler(false));
        if(jugador.getPunt()!=0 && nivel!=0)((BorderPane) root).setCenter(jugador.getVida());
        guardar.setOnAction(new EventHandler(){    // se guarda

            @Override
            public void handle(Event event) {
                if(juegos){
                    lista = (new Registro("Juego.txt").getList());
                    String temp[];
                    int i=0;
                    while(i<lista.size()){
                        temp=lista.get(i).split(",");
                        if(temp[0].equals(texto.getCharacters().toString())){   // nombre ingresado está en archivo Juego (Guardado)
                            juegoGuardado = temp;
                            jugador.setVidas(Integer.parseInt(juegoGuardado[1]));
                            jugador.setPuntuacion(Integer.parseInt(juegoGuardado[2]));
                            nivel = Integer.parseInt(juegoGuardado[3]);
                            cargarJuego();    // menu donde se puede elegir cargar ese Juego 
                            break;
                        }
                        i++;
                    }
                    
                }     
                else{
                    FileWriter fichero = null;  // creo que primero hay que leer el archivo. Si existe ese nombre entonces se lo actualiza
                    try{                       // se puede actualizar una linea de archivo??
                        fichero = new FileWriter("Puntuaciones.txt");
                        fichero.write(nivel+","+jugador.getPunt()+","+texto.getCharacters().toString()+"\n");  
                        fichero.close();         //  nivel,puntaje,nombre
                    } catch (IOException ex) {
                        Logger.getLogger(InformacionOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    crearMenu();
                }
            }
        });
    }
    
    private void cargarJuego(){
        cargar = new Button("Cargar Juego");
        cargar.setAlignment(Pos.TOP_CENTER);
        ((BorderPane) root).setCenter(cargar);  // en lugar de Mostrar Vidas (Monedas) 
        cargar.setOnMouseClicked(new InformacionOrganizer.ClickHandler(true));  // a nivel que dice el archivo Juego
        
    }
    
    private void crearMenu(){
        VBox menu = new VBox();
        grabar = new Button("Grabar");
        continuar = new Button("Continuar Nivel");
        topTen = new Button("Revisar Top Ten");
        
        menu.getChildren().addAll(continuar,topTen);
        menu.setAlignment(Pos.CENTER_LEFT);
        grabar.setAlignment(Pos.CENTER_RIGHT);
        ((BorderPane) root).setRight(menu);
        ((BorderPane) root).setLeft(grabar);
        continuar.setOnMouseClicked(new InformacionOrganizer.ClickHandler(true));  // a nivel que dice el buceador ( ya se guardó en archivo Puntajes)
        grabar.setOnAction(new EventHandler(){

            @Override
            public void handle(Event event) {
                FileWriter fichero = null;  
                    try{                      
                        fichero = new FileWriter("Juego.txt");  // lo mismo que el archivo Puntuaciones
                        fichero.write(texto.getCharacters().toString()+","+jugador.getVidas()+","+jugador.getPunt()+","+nivel+"\n");  
                        fichero.close();        // nombre,vidas,puntaje,nivel
                    } catch (IOException ex) {
                        Logger.getLogger(InformacionOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    crearMenu();
            }
        });
    }
    
    private class ClickHandler implements EventHandler<MouseEvent>{
        boolean b;
        //Buceador buceador;
        ClickHandler(boolean b){
            this.b=b;
            //if(b) buceador= jugador;
        }

        @Override
        public void handle(MouseEvent t) {
            if(b){   // Game
                switch(nivel+1){
                case 1:{
                    try {
                        root=(new GameOrganizer(jugador,10000,nivel+1)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }break;
                case 2:{
                    try {
                        root=(new GameOrganizer(jugador,7000,nivel+1)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }break;
                case 3:{
                    try {
                        root=(new GameOrganizer(jugador,4000,nivel+1)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }break;
                }
            }else{   // volver
                root=(new MenuOrganizer()).getRoot();
                cambiarPantalla(t,Constantes.DIMENSION_SCENE_X,Constantes.DIMENSION_SCENE_Y);
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
