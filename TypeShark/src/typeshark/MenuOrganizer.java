/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
public class MenuOrganizer extends Organizer{
    private Button empezar,salir,puntaje;
    private Text title;
    private Buceador buceador;
    
    MenuOrganizer(){
        buceador=new Buceador();
        root=new Pane();
        
        generarMenu();
        
        
    }
    private void generarMenu(){
        VBox menu=new VBox();
        
        empezar=new Button("Empezar");
        puntaje=new Button("Puntaje");
        salir=new Button (" Salir ");
        title=new Text("TYPERSHARK");
        title.setFont(Font.font("Ravie",FontWeight.NORMAL,40 ));
        root.setStyle("-fx-background-color: blue;");
        menu.getChildren().addAll(empezar,puntaje,salir);
        root.getChildren().addAll(title,menu);
        menu.setAlignment(Pos.CENTER);
        title.setLayoutX(Constantes.DIMENSION_SCENE_X*.03);
        title.setLayoutY(Constantes.DIMENSION_SCENE_Y*.2);
        menu.setLayoutX(Constantes.DIMENSION_SCENE_X*.403);
        menu.setLayoutY(Constantes.DIMENSION_SCENE_Y*.4);
        menu.setSpacing(Constantes.DIMENSION_SCENE_Y*.08);
        empezar.setOnMouseClicked(new ClickHandler(1));
        puntaje.setOnMouseClicked(new ClickHandler(2));
        salir.setOnMouseClicked(new ClickHandler(3));
       
    }
    private class ClickHandler implements EventHandler<MouseEvent>{
        int opcion;
        ClickHandler(int opcion){
            this.opcion=opcion;
        }
        @Override
        public void handle(MouseEvent t) {
            
            switch(opcion){
                case 1:{
                   
                    root=(new GameOrganizer(buceador,1000)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    cambiarPantalla(t);
                    
                
                }break;
                case 2:{root=(new PuntajeOrganizer()).getRoot();
                       cambiarPantalla(t);
                }break;
                case 3:{
                    Platform.exit();
                }break;
                        
                
                       
            }
          
            t.consume();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    private class DificultOrganizer{
        
        DificultOrganizer(){
            
        }
        
    }
}