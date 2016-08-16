/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 //adasdasd
package typeshark;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
public class TypeShark extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Organizer pane = new MenuOrganizer();
        Scene scene = new Scene(pane.getRoot(), Constantes.DIMENSION_SCENE_X, Constantes.DIMENSION_SCENE_Y, Color.ALICEBLUE);primaryStage.setTitle("TypeShark");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
