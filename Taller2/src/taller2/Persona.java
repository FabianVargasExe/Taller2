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
public class Persona {
    
    private String nombre;
    private int edad;
    private String ocupacion;
    private int cantidadFamilia;
    private Comuna comuna;
    private Censista censista;

    public Persona(String nombre, int edad, String ocupacion, int cantidadFamilia) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.cantidadFamilia = cantidadFamilia;
        comuna = null;
        censista = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getCantidadFamilia() {
        return cantidadFamilia;
    }

    public void setCantidadFamilia(int cantidadFamilia) {
        this.cantidadFamilia = cantidadFamilia;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Censista getCensista() {
        return censista;
    }

    public void setCensista(Censista censista) {
        this.censista = censista;
    }
}
