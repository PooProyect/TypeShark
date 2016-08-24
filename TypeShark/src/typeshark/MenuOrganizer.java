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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
    //private Text title;
    private Buceador buceador;
    
    MenuOrganizer(){
        buceador=new Buceador();
        root=new BorderPane();
        
        generarMenu();
        
        
    }
    private void generarMenu(){
        VBox menu=new VBox();
        
       
        empezar=new Button("Empezar");
        puntaje=new Button("Puntaje");
        salir=new Button (" Salir ");
        Node title=new Text("TYPERSHARK");
        ((Text) title).setFont(Font.font("Ravie",FontWeight.NORMAL,40 ));
        root.setStyle("-fx-background-color: aqua;");
        menu.getChildren().addAll(empezar,puntaje,salir);
        ((BorderPane) root).setTop(title);      //  getChildren().addAll(title,menu);
        ((BorderPane) root).setCenter(menu);
        //title.setLineSpacing(5);
        title.setTranslateX(20);
        title.setTranslateY(20);
        menu.setAlignment(Pos.CENTER);
        /*title.setLayoutX(Constantes.DIMENSION_SCENE_X*.03);
        title.setLayoutY(Constantes.DIMENSION_SCENE_Y*.2);
        menu.setLayoutX(Constantes.DIMENSION_SCENE_X*.403);
        menu.setLayoutY(Constantes.DIMENSION_SCENE_Y*.4);*/
        menu.setSpacing(Constantes.DIMENSION_SCENE_Y*.08);
        
        //((BorderPane) root).setRight((new Tiburon(-30,80,Color.AQUA,null)).getPez());
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
                    cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                    
                
                }break;
                    
                case 2:{
                    root=(new PuntajeOrganizer()).getRoot();
                    
                    cambiarPantalla(t,Constantes.DIMENSION_PUNTAJE_X,Constantes.DIMENSION_PUNTAJE_Y);
                }break;
                case 3:{
                    Platform.exit();
                }break;
                        
                
                       
            }
          
            t.consume();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
   /* private class DificultOrganizer{
        
        DificultOrganizer(){
            
        }
        
    }
    
    /*
     @Override
    public void setScene(){
        scene = new Scene(root, Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
    }*/
}