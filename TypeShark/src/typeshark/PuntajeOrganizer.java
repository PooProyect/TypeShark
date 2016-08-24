/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.ArrayList;
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
    private Button reiniciar,volver;
    private ArrayList<String> lista;
    PuntajeOrganizer(){ 
        lista=(new leerRegistro("Puntuaciones.txt").getList());
        root=new BorderPane();
        mostrarPuntaje();
        colocarBotones();
        
    }
    private void colocarBotones(){
        reiniciar=new Button("reiniciar");
        volver=new Button("volver");
        HBox bottom=new HBox();
        root.setStyle("-fx-background-color: aliceblue;");
        
        bottom.getChildren().addAll(reiniciar,volver);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(Constantes.DIMENSION_SCENE_X*.2);
        ((BorderPane)root).setBottom(bottom);
        
        reiniciar.setOnMouseClicked(new ClickHandler(true));
        volver.setOnMouseClicked(new ClickHandler(false));
    }
    private void mostrarPuntaje(){
        int i=0;
        String[] temp;
        VBox center=new VBox();
        HBox contenedor;
        while(i<lista.size()){
            contenedor=new HBox();
            temp=lista.get(i).split(",");
            contenedor.getChildren().addAll((new Label(temp[1])),(new Label(temp[0])));
            contenedor.setSpacing(Constantes.DIMENSION_PUNTAJE_X*.3);
            center.getChildren().add(contenedor);
            contenedor.setAlignment(Pos.CENTER);
            i++;
        }
        ((BorderPane)root).setCenter(center);
        center.setAlignment(Pos.CENTER);
        
        System.out.println(lista.size());
    }
    private class ClickHandler implements EventHandler<MouseEvent>{
        boolean b;
        ClickHandler(boolean b){
            this.b=b;
        }

        @Override
        public void handle(MouseEvent t) {
            if(b){
                
            }else{
                root=(new MenuOrganizer()).getRoot();
                cambiarPantalla(t,Constantes.DIMENSION_SCENE_X,Constantes.DIMENSION_SCENE_Y);
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
