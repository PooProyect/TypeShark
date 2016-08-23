/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.files;

import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Puntaje {
    ArrayList listadoTiburon;
    ArrayList listadoPiraña;
    Puntaje(){
       RegistroPalabras reg=new RegistroPalabras();
       listadoTiburon=reg.almacenarEnLista();
       listadoPiraña=reg.AlmacenarEnListaPiraña();
    }
    public void actualizarLista(){
        this.listadoTiburon=listadoTiburon;
        this.listadoPiraña=listadoPiraña;
    }
    public void eliminarTextoTiburon(String nombre){
        listadoTiburon.remove(nombre);
    }
    public ArrayList getListadoTiburon(){
        return listadoTiburon;
    }
    public void eliminarTextoPiraña(String nombre){
        listadoPiraña.remove(nombre);
    }
    public ArrayList getListadoPiraña(){
        return listadoPiraña;
    }
}
