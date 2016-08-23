/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


/**
 *
 * @author Andres
 */
public class PuntajeOrganizer extends Organizer{
    private Button reiniciar,volver;
    PuntajeOrganizer(){
        
        root=new BorderPane();
        colocarBotones();
        
    }
    private void colocarBotones(){
        reiniciar=new Button("reiniciar");
        volver=new Button("volver");
        HBox bottom=new HBox();
        root.setStyle("-fx-background-color: blue;");
        
        bottom.getChildren().addAll(reiniciar,volver);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(Constantes.DIMENSION_SCENE_X*.2);
        ((BorderPane)root).setBottom(bottom);
        ((BorderPane) root).setRight((new Pirana(0,100,Color.BLUE,null)).getPez());
        reiniciar.setOnMouseClicked(new ClickHandler(true));
        volver.setOnMouseClicked(new ClickHandler(false));
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
                cambiarPantalla(t);
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
