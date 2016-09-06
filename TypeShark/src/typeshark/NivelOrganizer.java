/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author fabkm
 */
public class NivelOrganizer extends Organizer{        // En esta clase tambien debe ir el ingreso del usuario Por eso le paso Buceador
    private Button nivelFacil, nivelMedio, nivelDificil;   // o quizá realmente aquí se cree al buceador :P
    private Buceador buceador;
    public NivelOrganizer(Buceador buceador){
        root = new BorderPane();
        this.buceador = buceador;
        this.generarMenuNiveles();
    }
    
    private void generarMenuNiveles(){
        VBox menu = new VBox();
        nivelFacil = new Button("FACIL");
        nivelMedio = new Button("MEDIO");
        nivelDificil = new Button("DIFICIL");
        Node title=new Text("Elegir Nivel");
        ((Text) title).setFont(Font.font("Ravie",FontWeight.NORMAL,40 ));
        root.setStyle("-fx-background-color: aqua;");
        menu.getChildren().addAll(nivelFacil,nivelMedio,nivelDificil);
        ((BorderPane) root).setTop(title);      //  getChildren().addAll(title,menu);
        ((BorderPane) root).setCenter(menu);
        //title.setLineSpacing(5);
        title.setTranslateX(20);
        title.setTranslateY(20);
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(Constantes.DIMENSION_SCENE_Y*.08);
        
        //((BorderPane) root).setRight((new Tiburon(-30,80,Color.AQUA,null)).getPez());
        nivelFacil.setOnMouseClicked(new NivelOrganizer.ClickHandler(1));
        nivelMedio.setOnMouseClicked(new NivelOrganizer.ClickHandler(2));
        nivelDificil.setOnMouseClicked(new NivelOrganizer.ClickHandler(3));

    }
    
    private class ClickHandler implements EventHandler<MouseEvent>{
        //Buceador buceador = new Buceador();
        int opcion;
        ClickHandler(int opcion){
            this.opcion=opcion;
            //this.buceador = buceador;
        }
        @Override
        public void handle(final MouseEvent t) {
            
            switch(opcion){
                case 1:{
                    try {
                    root=(new GameOrganizer(buceador,10000,opcion)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                }
                }break;
                case 2:{
                try {
                    root=(new GameOrganizer(buceador,7000,opcion)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                }
                }break;
                case 3:{
                try {
                    root=(new GameOrganizer(buceador,4000,opcion)).getRoot();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    cambiarPantalla(t,Constantes.DIMENSION_GAME_X,Constantes.DIMENSION_GAME_Y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NivelOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                }
                }break;
                }
        }
    }
}
