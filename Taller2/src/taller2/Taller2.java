/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static taller2.Funciones.*;
import ucn.ArchivoEntrada;
import ucn.ArchivoSalida;
import ucn.Registro;
import ucn.StdOut;


/**
 *
 * @author favya
 */
public class Taller2 {
    
     public static void leerCensistas (ListaPersonas listaPersonas, ListaCensistas listaCensistas, ListaComunas listaComunas) {
        try {
            ArchivoEntrada in = new ArchivoEntrada("Censistas.txt");
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
        
     public static void leerComunas (ListaComunas listaComunas) {
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
     
     
    public static void leerPersonas(ListaPersonas listaPersonas, ListaCensistas listaCensistas, ListaComunas listaComunas) {
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
    
    public static void CensoRF1 (ListaComunas lco) throws IOException {
       
       
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
         fichero = new FileWriter("Censo.txt");
         pw = new PrintWriter(fichero);  
         

            for(int i=0; i < lco.getCantComunas(); i++){
                
                Comuna co = lco.getComunaI(i);
                pw.println("Comuna: " + co.getNombre());
                
                for(int j = 0; j < co.getListaPersonas().getCantPersonas(); j++){
                    
                    Persona p = co.getListaPersonas().getPersonaI(j);
                    
                    pw.println(" Nombre: " + co.getNombre());
                    pw.println(" Edad: " + p.getEdad());
                    pw.println(" Ocupacion: " + p.getOcupacion());    
                    pw.println(" Cantidad Familia: " + p.getCantidadFamilia());
                    pw.println(" Censista: " + p.getCensista().getNombre());
 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }  
    }    
    

    public static void DatosCensistasRF2(ListaCensistas lc){
         
        int SumaFamilia = 0;
        int ContMayor3 = 0;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
         fichero = new FileWriter("DatosCensistas.txt");
         pw = new PrintWriter(fichero);  
           
         for(int i=0; i< lc.getCantCensistas(); i++){
             
            Censista c = lc.getCensistaI(i);
            pw.println("Censista: " + c.getNombre());                        
                  
            for(int j=0; j < c.getListaPersonas().getCantPersonas() ; j++){
                 
                Persona p = c.getListaPersonas().getPersonaI(j);
                pw.println(" " + p.getNombre());
                pw.println(" " + p.getEdad());
             
                // Contador de familias
                int cont = p.getCantidadFamilia();
                SumaFamilia = cont + SumaFamilia;
             
                // Si es mayor que 3 se guarda en su respectivo contador
                if(cont > 3){
                ContMayor3 ++;            
                }
                
            }
            int Porcentaje = (ContMayor3/SumaFamilia)*100;
            pw.println("Total habitantes: " + SumaFamilia);    

            pw.print("Porcentaje Familias mayor 3 integrantes ");          
            pw.println((String.format("%.2s", Porcentaje)));
             
             
         }
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }     
    }

     public static void CensistaRF3(ListaCensistas lc, ListaComunas lco, int codigo){
         
         Censista c = lc.buscarPorCodigo(codigo);
         StdOut.println("Nombre: " + c.getNombre());
         StdOut.println("Codigo: " + c.getCodigo());
         StdOut.println("Comuna: " + c.getComuna().getNombre());
         
         int TotalCensadosCen = c.getListaPersonas().getCantPersonas();
         
         for(int i = 0; i < TotalCensadosCen ; i++){
             
             Persona p = c.getListaPersonas().getPersonaI(i);
             
             StdOut.println("Nombre: " + p.getNombre());
             StdOut.println("Edad: " + p.getEdad());
             StdOut.println("Comuna: " + p.getComuna());
             StdOut.println("Ocupacion: " + p.getOcupacion());
             StdOut.println("Cantidad Familia: " + p.getCantidadFamilia());
         }
         
         // De acuerdo al nombre de la comuna asociada del censista se busca la comuna en la lista general
         String NcomunaCens = c.getComuna().getNombre();
         Comuna co = lco.buscarPorNombre(NcomunaCens);
         
         int TotalCensadosCom = co.getListaPersonas().getCantPersonas();
         
         int Porcentaje = (TotalCensadosCen/TotalCensadosCom)*100;
         
         StdOut.print("Porcentaje Censados Comuna: " );
         StdOut.println((String.format("%.2s", Porcentaje)));
         
     }

    public static void DatosComunaRF4(ListaComunas lc, int CodigoComuna) {
        
        int Cont = 0;
        
        Comuna co = lc.buscarPorCodigo(CodigoComuna);
        StdOut.println("Nombre: " + co.getNombre());
        StdOut.println("Codigo: " + co.getCodigo());
        StdOut.println("Cantidad Total Habitantes: " + co.getCanthabitantes());
         
        for(int i=0; i < co.getListaPersonas().getCantPersonas() ; i++){
             
            int CantPersonas = co.getListaPersonas().getPersonaI(i).getCantidadFamilia();
            Cont = Cont + CantPersonas;
        }
        if (Cont == co.getCanthabitantes()){
            StdOut.println("El censo fue realizado exitosamente");

        }else{           
            StdOut.println("El censo NO fue realizado satisfactoriamente");
        
        }    
    }
       
       
    public static void main(String[] args) throws IOException {
 
    ListaCensistas lc = new ListaCensistas(1000);
    ListaPersonas lp = new ListaPersonas(1000);
    ListaComunas lco = new ListaComunas(1000);
  
    leerCensistas(lp, lc, lco);
    leerPersonas(lp, lc, lco);
    leerComunas(lco);
    
    CensoRF1(lco);
   // DatosComunaRF4(lco,001);
    
    lco.getComunaI(0).getNombre();
   // StdOut.println(lp.getPersonaI(0).getComuna().getNombre());

  
  int op;
  
      /*   do{  
            StdOut.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine()); 
            switch(op){
                
                case 1: 
                  //ReservarHabitacionRF1(lp,lr,lh);
                    break;
                case 2:
                    ReservacionesRF2(lp);
                    break;
                case 3:
                    SueldosRF3 (lp);
                    break;
  StdOut.print("Ingrese patente: ") ;
String patente = StdIn.readString();
                case 4:
                    StdOut.println("Usted está saliendo del menú..." );
                    break;
                default:
                    StdOut.println("OPCION NO VALIDA" );
                    break;
               
            }
            }while( op != 4 );*/
 }
       
    
}
