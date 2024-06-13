/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Model.Pelicula;
import java.util.ArrayList;

/**
 *
 * @author simclub01
 */
public interface DaoInterfacePelicula {
    public void actualizar(Pelicula pelicula);
    public void actualizarCantidad(Pelicula pelicula);
    public void crear(Pelicula pelicula);
    public void eleminar(int idpelicula);
    public Pelicula buscar(Pelicula pelicula);
   // public int disponibilidad(Pelicula pelicula);
    public ArrayList<Pelicula> buscarTodo();
}
