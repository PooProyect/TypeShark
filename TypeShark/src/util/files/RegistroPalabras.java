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
    private ArrayList listaPalabra;
    private ArrayList listaPirañas;
    
    public RegistroPalabras(){
        
        
    }
    public ArrayList almacenarEnLista(){
        
        try{
           BufferedReader bf=new BufferedReader(new FileReader("palabras.txt"));
           listaPalabra=new ArrayList();
           String bfread;
           String temp="";
           while((bfread=bf.readLine())!=null){
               temp=temp+bf;
               listaPalabra.add(temp);
               temp="";
           }
        }
        catch(Exception e){
            
        }
        return listaPalabra;
    }
    public ArrayList AlmacenarEnListaPiraña(){
        try{
           BufferedReader bf=new BufferedReader(new FileReader("PalabrasPirañas.txt"));
           listaPirañas=new ArrayList();
           String bfread;
           String temp="";
           while((bfread=bf.readLine())!=null){
               temp=temp+bf;
               listaPirañas.add(temp);
               temp="";
           }
        }
        catch(Exception e){
            
        }
        return listaPirañas;
    }
    
    
}
