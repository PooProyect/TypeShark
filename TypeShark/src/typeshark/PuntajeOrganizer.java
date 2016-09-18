/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import util.files.*;


/**
 *
 * @author Andres
 */
public class PuntajeOrganizer extends Organizer{
    private Button continuar,volver,nivelFacil,nivelMedio,nivelDificil;   // cambiar Volver x ContinuarNivel
    private ArrayList<String> lista;
    private Buceador jugador;
    private int nivel;
    PuntajeOrganizer(Buceador buceador, int nivel){       
        lista=(new Registro("Puntuaciones.txt").getList());
        root=new BorderPane();
        jugador = buceador;
        this.nivel = nivel;
        //mostrarPuntaje();
        colocarBotones();
        
    }
    private void colocarBotones(){
        continuar=new Button("Continuar Nivel");   // especificar nivel 
        volver=new Button("volver");
        nivelFacil = new Button("Nivel Facil");
        nivelMedio = new Button("Nivel Medio");
        nivelDificil = new Button("Nivel Dificil");
        HBox bottom=new HBox();
        VBox left = new VBox();
        root.setStyle("-fx-background-color: aliceblue;");
        
        bottom.getChildren().addAll(continuar,volver);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(Constantes.DIMENSION_SCENE_X*.2);
        left.getChildren().addAll(nivelFacil,nivelMedio,nivelDificil);
        left.setAlignment(Pos.CENTER);
        left.setSpacing(Constantes.DIMENSION_SCENE_Y*.2);
        ((BorderPane)root).setBottom(bottom);
        ((BorderPane) root).setLeft(left);

        if(nivel!=0) continuar.setOnMouseClicked(new ClickHandler(true));
        volver.setOnMouseClicked(new ClickHandler(false));
        nivelFacil.setOnAction(new NivelHandler(1));
        nivelMedio.setOnAction(new NivelHandler(2));
        nivelDificil.setOnAction(new NivelHandler(3));
    }
    
    private class ClickHandler implements EventHandler<MouseEvent>{
        boolean b;
        ClickHandler(boolean b){
            this.b=b;
        }

        @Override
        public void handle(MouseEvent t) {
            if(b){
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
            }else{
                root=(new MenuOrganizer()).getRoot();
                cambiarPantalla(t,Constantes.DIMENSION_SCENE_X,Constantes.DIMENSION_SCENE_Y);
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    private class NivelHandler implements EventHandler<ActionEvent>{
        private Integer nivel;
        public NivelHandler(int nivel){
            this.nivel = nivel;
        }

        @Override
        public void handle(ActionEvent event) {
            
            int i=0;
            String[] temp;
            VBox center=new VBox();
            HBox contenedor;
            while(i<lista.size()){
                contenedor=new HBox();
                temp=lista.get(i).split(",");
                if(temp[0].equals(nivel.toString())){
                    contenedor.getChildren().addAll((new Label(temp[2])),(new Label(temp[1])));
                    contenedor.setSpacing(Constantes.DIMENSION_PUNTAJE_X*.3);
                    center.getChildren().add(contenedor);
                    contenedor.setAlignment(Pos.CENTER);
                }
                i++;
            }
            ((BorderPane)root).setCenter(center);
            center.setAlignment(Pos.CENTER);
        
            System.out.println(lista.size());
            event.consume();
        }
    }
}
