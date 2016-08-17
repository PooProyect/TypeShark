/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author Administrador
 */
public class Buceador implements Runnable {
    private int vidas;
    private int puntuacion;
    private String nombre;
    private Node buceador;
    public Buceador(){
        //aun no esta la imagen
        buceador=new Canvas();
        vidas=3;
        puntuacion=0;
        
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getVidas(){
        return vidas;
    }
    public void aumentarVida(){
        vidas++;
    }
    public int getPunt(){
        return puntuacion;
    }
    public Node getBuceador(){
        return buceador;
    }
    public void añadirPuntaje(int valor){
        puntuacion+=valor;
    }
    public void restarVida(){
        vidas--;
    }
    
    public void grabarPuntuacion(){
        try{
            FileWriter lector=new FileWriter("Puntuaciones.txt");
            lector.write(nombre, puntuacion, 100);
            
        }
        catch(Exception e){
            
        }
    }
}
