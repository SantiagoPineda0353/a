/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author simclub01
 */
public class Pelicula {
    private int idPelicula;
    private String nombre;
    private String categoria;
    private int cantidad;
    private int precio;

    public Pelicula(int idPelicula, String nombre, String Categoria, int cantidad, int precio) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.categoria = Categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Pelicula(String nombre, String categoria, int cantidad, int precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Pelicula(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Pelicula(String nombre, String categoria, int cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }
    
    public Pelicula(int idPelicula, int cantidad, int precio) {
        this.idPelicula = idPelicula;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
