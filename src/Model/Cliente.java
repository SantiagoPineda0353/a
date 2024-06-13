/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author simclub01
 */
public class Cliente {
    private String nombre;
    private String correoElectronico;
    private long cedula;
    private long telefono;

    public Cliente() {
    }

   
    public Cliente(String nombre, String correoElectronico, long cedula, long telefono) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
}

