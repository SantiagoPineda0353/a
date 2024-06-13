/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author simclub01
 */
public class Venta {
    private int idVenta;
    private Cliente cliente;
    private Pelicula videojuego;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Pelicula videojuego) {
        this.videojuego = videojuego;
    }
    
}
