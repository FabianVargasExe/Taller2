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
public class Censista {
    
    private int codigo;
    private String nombre;
    private ListaPersonas listaPersonas;
    private Comuna comuna;
    
    public Censista(int co, String no){
        codigo = co;
        nombre = no;
        listaPersonas = new ListaPersonas(1000);
        comuna = null;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public void setListaPersonas(ListaPersonas listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPersonas getListaPersonas() {
        return listaPersonas;
    }
    
}

