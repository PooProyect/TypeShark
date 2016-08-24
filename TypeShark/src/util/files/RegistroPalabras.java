/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class RegistroPalabras {
    private ArrayList lista;
    
    
    public RegistroPalabras(String txt){
        try{
           BufferedReader bf=new BufferedReader(new FileReader("src\\util\\files\\"+txt));
           lista=new ArrayList();
           String bfread;
           String temp="";
           while((bfread=bf.readLine())!=null){
               
               lista.add(bfread);
               
           }
           bf.close();
        }
        catch(Exception e){
            
        }
       
    }
 
     
    public ArrayList<String> getList(){
        return lista;
    }
}
