/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeshark;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author fabkm
 */
public class Hilo extends Thread{
    private Pez pez;
    private Integer index;
    private Integer time;
    
    Hilo(Pez pez, Integer time, Integer i){
        this.index = i;
        this.pez = pez;
        this.time = time;
        //System.out.println("Creando hilo "+index);
    }
    
    @Override
    public void run(){
        System.out.println("Ejecutando hilo  "+index);
        try {
                    Thread.sleep(time*index);
                    pez.run();
                    System.out.println("Iniciando hilo " +index);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Hilo "+index+" termino");
                }
            }
        
        
   
}
