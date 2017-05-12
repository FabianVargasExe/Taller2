/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.io.IOException;
import ucn.ArchivoEntrada;
import ucn.Registro;

/**
 *
 * @author favya
 */
public class Funciones {
    
        public static void leerCensistas (ListaPersonas listaPersonas, ListaCensistas listaCensistas, ListaComunas listaComunas) {
        try {
            ArchivoEntrada in = new ArchivoEntrada("Comunas.txt");
                while(!in.isEndFile()){
                Registro reg = in.getRegistro();
   
                int cod = reg.getInt();
                String nom = reg.getString();
                String comu = reg.getString();

                Censista c = new Censista(cod,nom);
                listaCensistas.ingresarCensistas(c);
  
                Comuna comuna = listaComunas.buscarPorNombre(comu);
                if (comuna != null){
                    comuna.getListaCensistas().ingresarCensistas(c);
                }
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    }  
        
     public void leerComunas (ListaComunas listaComunas) {
        try {
            ArchivoEntrada in = new ArchivoEntrada("Comunas.txt");
                while(!in.isEndFile()){
                Registro reg = in.getRegistro();
   
                int cod = reg.getInt();
                String nom = reg.getString();
                int numc = reg.getInt();
                int canth = reg.getInt();

                Comuna co = new Comuna(cod,nom,numc,canth);
                listaComunas.ingresarComunas(co); 
                
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    }  
     
     
       public void leerPersonas(ListaPersonas listaPersonas, ListaCensistas listaCensistas, ListaComunas listaComunas) {
        try {
            ArchivoEntrada in = new ArchivoEntrada("Personas.txt");
            while(!in.isEndFile()){
                Registro reg = in.getRegistro();
                String nomb = reg.getString();
                int edad = reg.getInt();
                String comu = reg.getString();
                String ocup = reg.getString();
                int cantf = reg.getInt();
                String censis = reg.getString();
  
                Persona p = new Persona(nomb,edad,ocup,cantf);
                listaPersonas.ingresarPersonas(p);
                
                Censista censista = listaCensistas.buscarPorNombre(censis);
                if (censista != null){
                    censista.getListaPersonas().ingresarPersonas(p);
                }
               
                Comuna comuna = listaComunas.buscarPorNombre(comu);
                if (comuna != null){
                    comuna.getListaPersonas().ingresarPersonas(p);
                }                
                
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    }   
    
}
