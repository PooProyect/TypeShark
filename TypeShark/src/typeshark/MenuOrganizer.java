/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
public class MenuOrganizer extends Organizer{
    Button empezar,salir,puntaje;
    MenuOrganizer(){
        root=new Pane();
        generarMenu();
    }
    private void generarMenu(){
        VBox menu=new VBox();
        empezar=new Button("Empezar");
        puntaje=new Button("Puntaje");
        salir=new Button (" Salir ");
      
        menu.getChildren().addAll(empezar,puntaje,salir);
        root.getChildren().add(menu);
        menu.setLayoutX(Constantes.DIMENSION_SCENE_X*.5);
        menu.setLayoutY(Constantes.DIMENSION_SCENE_Y*.3);
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
            Stage stage=new Stage();
            switch(opcion){
                case 1:{
                    
                    root=(new GameOrganizer()).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    stage=(Stage) ((Node)t.getSource()).getScene().getWindow();
                    setScene();
                    stage.setScene(scene);
                    
                    
                }break;
                case 2:{root=(new PuntajeOrganizer()).getRoot();
                    
                }break;
                case 3:{
                    Platform.exit();
                }break;
                        
                
                       
            }
          
            t.consume();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
