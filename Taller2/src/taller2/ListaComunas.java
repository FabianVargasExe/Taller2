/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

/**
 *
 * @author favya
 */
public class ListaComunas {
    
    private Comuna [] lco;
    private int cantComunas;
    private int max;
    
    public ListaComunas(int max){
        this.max = max;
        lco = new Comuna[max];
        cantComunas = 0;
    }
    
   public int getCantComunas (){
       return cantComunas;
   }
   
   public boolean ingresarComunas (Comuna co){
       if(cantComunas < max){
           lco[cantComunas] = co;
           cantComunas++;
           return true;
       }else{
           return false;
       }
   }
   
   public Comuna buscarPorNombre (String nom) {
       int i;
       for(i = 0; i < cantComunas; i++){
           if(lco[i].getNombre().equals(nom)){
           }
       }
       if (i == cantComunas){
          return null;
       }else{
            return lco[i];
       }
   }
   
   public Comuna buscarPorCodigo (int cod) {
       int i;
       for(i = 0; i < cantComunas; i++){
           if(lco[i].getCodigo() == cod){
           }
       }
       if (i == cantComunas){
          return null;
       }else{
            return lco[i];
       }
   }       
   
   public Comuna getComunaI(int i){
       if(i < cantComunas && i >= 0){
           return lco[i];
       }else{
            return null;
       }
   }
    
}
